package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Afspraak
import grails.converters.JSON

class HondController {

    def scaffold = com.dabis.trimsalon.model.Hond
	
	def logout = {
		flash.message = "Prettige dag, ${session.hond.login}"
		session.hond = null
		redirect(controller:"hond", action:"login")
	  }
	
	def save = {
		def hondInstance = new Hond(params)
		hondInstance = hondInstance.merge(flush:true)
		if (hondInstance.save()) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'hond.label', default: 'Hond'), hondInstance.naam])}"
			redirect(controller:"hond", action: "list")
		}
		else {
			render(view: "create", model: [hondInstance: hondInstance])
		}
	}
	
	def show = {
		def hondInstance = Hond.get(params.id)
		
		if (!hondInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'hond.label', default: 'Hond'), params.id])}"
			redirect(action: "list")
		}
		else {
			[hondInstance:hondInstance]
		}	
	}
	
		def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def hondList = Hond.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[hondInstanceList: Hond.list(params), hondInstanceTotal: Hond.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
		
		def listHond = {
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
			def hondList = Hond.withCriteria {
			projections {
			distinct "naam"
				}
			}
			[hondInstanceList: Hond.list(params)]
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
		
		// return JSON list of hond
		def jq_hond_list = {
				def sortIndex = params.sidx ?: 'naam'
				def sortOrder  = params.sord ?: 'asc'
		  
				def maxRows = Integer.valueOf(params.rows)
				def currentPage = Integer.valueOf(params.page) ?: 1
		  
				def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
				
				def hond = Hond.createCriteria().list(max:maxRows, offset:rowOffset) {
					
								// first name case insensitive where the field begins with the search term
								if (params.naam)
									ilike('naam',params.naam + '%')
								
								if (params.ras)
									ilike('ras',params.ras + '%')
									
								if (params.geslacht)
									ilike('geslacht',params.geslacht + '%')
									
								if (params.gecastreerd)
									ilike('gecastreerd',params.gecastreerd + '%')
									
								if (params.kleur)
									ilike('kleur',params.kleur + '%')
									
								if (params.leeftijd)
									ilike('leeftijd',params.leeftijd + '%')
									
								if (params.klant)
									ilike('klant',params.klant + '%')
								
								// set the order and direction
								order(sortIndex, sortOrder).ignoreCase()
						  }
				
				def totalRows = hond.totalCount
				def numberOfPages = Math.ceil(totalRows / maxRows)
		  
				def jsonCells = hond.collect {
					 [cell: [it.naam,
						 it.ras,
						 it.geslacht,
						 it.kleur,
						 it.leeftijd,
						 it.klant
						], id: it.id]
				  }
				  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
				  render jsonData as JSON
		}
		
		def jq_edit_hond = {
			def hond = null
			def message = ""
			def state = "FAIL"
			def id
	  
			// determine our action
			switch (params.oper) {
			  case 'add':
				// add instruction sent
				hond = new Hond(params)
				if (! hond.hasErrors() && hond.save()) {
				  message = "Hond ${hond.naam} toegevoegd"
				  id = hond.id
				  state = "OK"
				} else {
				  message = "Kan hond niet opslaan"
				}
	  
				break;
			  case 'del':
				// check exists
				hond = Hond.get(params.id)
				if (hond) {
				  // delete hond
				  hond.delete()
				  message = "Hond ${hond.naam} verwijderd"
				  state = "OK"
				}
				break;
			  default:
				// default edit action
				// first retrieve the hond by its ID
				hond = Hond.get(params.id)
				if (hond) {
				  // set the properties according to passed in parameters
				  hond.properties = params
				  if (! hond.hasErrors() && hond.save()) {
					message = "Hond ${hond.naam} bijgewerkt"
					id = hond.id
					state = "OK"
				  } else {
					message = "Kan de hond niet bijwerken"
				  }
				}
				break;
			}
	  
			def response = [message:message,state:state,id:id]
	  
			render response as JSON
		  }
}
