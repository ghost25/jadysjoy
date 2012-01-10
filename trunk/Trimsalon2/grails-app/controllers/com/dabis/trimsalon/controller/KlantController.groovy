package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import grails.converters.JSON

class KlantController {

    def scaffold = com.dabis.trimsalon.model.Klant
	
	def logout = {
		flash.message = "Prettige dag, ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def beforeInterceptor = [action:this.&auth, except:['list','jq_klant_list']]
		
	def auth() {
		if(!session.user) {
			def originalRequestParams =
			[controller:controllerName,
			action:actionName]
			originalRequestParams.putAll(params)
			session.originalRequestParams =
			originalRequestParams
			
		  redirect(controller:"user", action:"login")
		  return false
		}
    }
	
	def search = {
	  def searchResults = Klant.search(params.q, params)
	  flash.message = "${searchResults.total} resultaten gevonden binnen zoekopdracht naar: ${params.q}"
	  flash.q = params.q
	  if (searchResults != null) {
	  return [searchResults:searchResults.results, resultCount:searchResults.total]}
	  else {
		  redirect(controller:"klant", action: "list")
	  }
	  
	}
	
	def save = {
		def klantInstance = new Klant(params)
		if (klantInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'klant.label', default: 'Klant'), klantInstance.naam])}"
			redirect(controller:"hond", action: "create")
		}
		else {
			render(view: "create", model: [userInstance: klantInstance])
		}
	}	
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def klantList = Klant.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[klantInstanceList: Klant.list(params), klantInstanceTotal: Klant.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
	
	// return JSON list of klant
	def jq_klant_list = {
			def sortIndex = params.sidx ?: 'naam'
			def sortOrder  = params.sord ?: 'asc'
	  
			def maxRows = Integer.valueOf(params.rows)
			def currentPage = Integer.valueOf(params.page) ?: 1
	  
			def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
			
			def klant = Klant.createCriteria().list(max:maxRows, offset:rowOffset) {
				
							// first name case insensitive where the field begins with the search term
							if (params.naam)
								ilike('naam',params.naam + '%')
							
							if (params.adres)
								ilike('adres',params.adres + '%')
								
							if (params.huisnummer)
								ilike('huisnummer',params.huisnummer + '%')
								
							if (params.postcode)
								ilike('postcode',params.postcode + '%')
										
							// last name case insensitive where the field begins with the search term
							if (params.woonplaats)
								ilike('woonplaats',params.woonplaats + '%')
				
							// age search where the age Equals the search term
							if (params.telefoon)
								eq('telefoon', Integer.valueOf(params.telefoon))
				
							// email case insensitive where the field contains search term
							if (params.email)
								ilike('email','%' + params.email + '%')
							
							if (params.opmerkingen)
								ilike('opmerkingen',params.opmerkingen + '%')
							
							// set the order and direction
							order(sortIndex, sortOrder).ignoreCase()
					  }
			
			def totalRows = klant.totalCount
			def numberOfPages = Math.ceil(totalRows / maxRows)
	  
			def jsonCells = klant.collect {
				 [cell: [it.naam,
					 it.adres,
					 it.huisnummer,
					 it.postcode,
					 it.woonplaats,
					 it.telefoon,
					 it.email,
					 it.opmerkingen
					], id: it.id]
			  }
			  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
			  render jsonData as JSON
	}
	
	def jq_edit_klant = {
		def klant = null
		def message = ""
		def state = "FAIL"
		def id
  
		// determine our action
		switch (params.oper) {
		  case 'add':
			// add instruction sent
			klant = new Klant(params)
			if (! klant.hasErrors() && klant.save()) {
			  message = "Klant ${klant.naam} toegevoegd"
			  id = klant.id
			  state = "OK"
			} else {
			  message = "Kan klant niet opslaan"
			}
  
			break;
		  case 'del':
			// check klant exists
			klant = Klant.get(params.id)
			if (klant) {
			  // delete klant
			  customer.delete()
			  message = "Klant ${klant.naam} verwijderd"
			  state = "OK"
			}
			break;
		  default:
			// default edit action
			// first retrieve the klant by its ID
			klant = Klant.get(params.id)
			if (klant) {
			  // set the properties according to passed in parameters
			  klant.properties = params
			  if (! klant.hasErrors() && klant.save()) {
				message = "Klant ${klant.naam} bijgewerkt"
				id = klant.id
				state = "OK"
			  } else {
				message = "Kan de klant niet bijwerken"
			  }
			}
			break;
		}
  
		def response = [message:message,state:state,id:id]
  
		render response as JSON
	  }
	
	def info = {
		def klantList = Klant.withCriteria {
			projections {
			distinct "naam"
			}
			}
			[top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"datum", order:"desc"),]
			}
	
	def mailKlant = {
		try {
		sendMail {
			to  "${userInstance.email}"
			from "rob.daalman@gmail.com"
			subject "Afspraak trimsalon JadysJoy"
			html g.render(template:'/email/afspraak',model:[user:UserInstance])
		}
		flash.message = "Bevestiging afspraak is verstuurd naar ${userInstance.naam}"
		} catch(Exception e){
		log.error "Probleem met versturen email $e.message", e
		flash.message = "Email is niet verstuurd"
			redirect(controller:"klant", action: "list")
		}
	}
	
	def listKlant = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def klantList = Klant.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[klantInstanceList: Klant.list(params)]
	}
}
	

