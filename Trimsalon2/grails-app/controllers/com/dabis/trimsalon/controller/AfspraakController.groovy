package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Producten
import com.dabis.trimsalon.model.Calendar
import grails.converters.JSON

class AfspraakController {

    def scaffold = com.dabis.trimsalon.model.Afspraak
	
	def logout = {
		flash.message = "Prettige dag, ${session.afspraak.login}"
		session.afspraak = null
		redirect(controller:"afspraak", action:"login")
	  }
	
	def save = {
		def afspraakInstance = new Afspraak(params)
		afspraakInstance = afspraakInstance.merge(flush:true)
		if (afspraakInstance.save()) {
							
			println afspraakInstance.dump()
			println params.dump()
			
			 if( afspraakInstance.afgehandeld==true ) {				 
				flash.message = "${message(code: 'default.created.message', args: [message(code: 'afspraak.label', default: 'Afspraak'), afspraakInstance.id])}"
				redirect(controller:"inkomsten", action: "create")
			}
			else {
			
				try  {
					sendMail {
						to  "${afspraakInstance.hond.klant.email}"
						from "rob.daalman@gmail.com"
						subject "Afspraak trimsalon JadysJoy"
						html g.render(template:'/email/afspraak',model:[afspraakInstance: afspraakInstance])
					}
					flash.message = "Bevestiging afspraak is verstuurd naar ${afspraakInstance.hond.klant.naam}"
					} catch(Exception e){
					log.error "Probleem met versturen email $e.message", e
					flash.message = "Email is niet verstuurd"
					}
					redirect(action: "show", id: afspraakInstance.id)
				}
		}
		else {
			render(view: "create", model: [afspraakInstance: afspraakInstance])
		}
	}
	
	def saveAfspraak = {
		def afspraakInstance = new Afspraak(params)
		afspraakInstance = afspraakInstance.merge(flush:true)
		if (afspraakInstance.save()) {
							
			println afspraakInstance.dump()
			println params.dump()
			
			 if( afspraakInstance.afgehandeld==true ) {
				flash.message = "${message(code: 'default.created.message', args: [message(code: 'afspraak.label', default: 'Afspraak'), afspraakInstance.id])}"
				redirect(controller:"inkomsten", action: "create")
			}
			else {
			
				try  {
					sendMail {
						to  "${afspraakInstance.hond.klant.email}"
						from "rob.daalman@gmail.com"
						subject "Afspraak trimsalon JadysJoy"
						html g.render(template:'/email/afspraak',model:[afspraakInstance: afspraakInstance])
					}
					flash.message = "Bevestiging afspraak is verstuurd naar ${afspraakInstance.hond.klant.naam}"
					} catch(Exception e){
					log.error "Probleem met versturen email $e.message", e
					flash.message = "Email is niet verstuurd"
					}
					redirect(controller: "calendar", action: "show", id: "1")
				}
		}
		else {
			render(view: "create", model: [afspraakInstance: afspraakInstance])
		}
	}

	def mail = {
		try  {
			sendMail {
				to  "${klantInstance.email}"
				from "rob.daalman@gmail.com"
				subject "Afspraak trimsalon JadysJoy"
				html g.render(template:'/email/afspraak',model:[klant:klantInstance])
			}
			flash.message = "Bevestiging afspraak is verstuurd naar ${klantInstance.naam}"
			} catch(Exception e){
			log.error "Probleem met versturen email $e.message", e
			flash.message = "Email is niet verstuurd"
				redirect(controller:"afspraak", action: "list")
			}
		}

	
	def update = {
		def afspraakInstance = Afspraak.get(params.id)
		if (afspraakInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (afspraakInstance.version > version) {
					
					afspraakance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'afspraak.label', default: 'Afspraak')] as Object[], "Another afspraak has updated this afspraak while you were editing")
					render(view: "edit", model: [afspraakInstance: afspraakInstance])
					return
				}
			}
			afspraakInstance.properties = params
			afspraakInstance = afspraakInstance.merge(flush:true)
			if (!afspraakInstance.hasErrors() && afspraakInstance.save()) {
				if( afspraakInstance.afgehandeld==true ){
			    flash.message = "${message(code: 'default.updated.message', args: [message(code: 'afspraak.label', default: 'Afspraak'), afspraakInstance.id])}"
				redirect(controller:"inkomsten", action: "create")
				}
			    else {
					try  {
						sendMail {
							to  "${afspraakInstance.klant.email}"
							from "rob.daalman@gmail.com"
							subject "Afspraak trimsalon JadysJoy"
							html g.render(template:'/email/afspraak',model:[afspraakInstance: afspraakInstance])
						}
						flash.message = "Bevestiging afspraak is verstuurd naar ${afspraakInstance.hond.klant.naam}"
						} catch(Exception e){
						log.error "Probleem met versturen email $e.message", e
						flash.message = "Email is niet verstuurd"
							redirect(action: "show", id: afspraakInstance.id)
						}
					
						}
				}
			else {
				render(view: "edit", model: [afspraakInstance: afspraakInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'afspraak.label', default: 'Afspraak'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def toggleCompleted = {
		def afspraak = Afspraak.get(params.id)
		if (afspraak){
		afspraak.afgehandeld = params.afgehandeld == 'true'
		task.save()
		}
		render ''
		}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def afspraakList = Afspraak.withCriteria {
		projections {
		distinct "begindatum"
			}
		}
		[afspraakInstanceList: Afspraak.list(params), afspraakInstanceTotal: Afspraak.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
	
	def updateEndDate={
		Afspraak e=Afspraak.get(params.id.toLong())
		e.einddatum.time+=24*3600000*Long.parseLong(params.dayDelta)+60000*Long.parseLong(params.minuteDelta)
		println e.einddatum
		e.save(flush:true)
		render 'update OK'
		}
		
	def updateMoveDate={
		
		println "Dump voor get:"+params.dump()
				
		Afspraak e=Afspraak.get(params.id.toLong())
		
		e.allDay=params.allDay=='true'
		e.begindatum.time+=24*3600000*Long.parseLong(params.dayDelta)+60000*Long.parseLong(params.minuteDelta)
		e.einddatum.time+=24*3600000*Long.parseLong(params.dayDelta)+60000*Long.parseLong(params.minuteDelta)
		e.save(flush:true)
		render 'update OK'
		}

	
	def listafspraak = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def afspraakList = afspraak.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[afspraakInstanceList: afspraak.list(params)]
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
	
	def listProduct = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def productenList = Producten.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[productenInstanceList: Producten.list(params)]
	}
	
	def selectafspraak={
		def afspraakInstance = afspraak.get(params.id)
		println "Dump voor get:"+params.dump()
				
		}
	
	// return JSON list of afspraak
	def jq_afspraak_list = {
			def sortIndex = params.sidx ?: 'omschrijving'
			def sortOrder  = params.sord ?: 'asc'
	  
			def maxRows = Integer.valueOf(params.rows)
			def currentPage = Integer.valueOf(params.page) ?: 1
	  
			def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
			
			def afspraak = Afspraak.createCriteria().list(max:maxRows, offset:rowOffset) {
				
							// first name case insensitive where the field begins with the search term
							if (params.omschrijving)
								ilike('omschrijving',params.omschrijving + '%')
							
							if (params.begindatum)
								ilike('begindatum',params.begindatum + '%')
								
							if (params.einddatum)
								ilike('einddatum',params.einddatum + '%')
								
							if (params.producten)
								ilike('producten',params.producten + '%')
							
							if (params.hond)
								ilike('hond',params.hond + '%')
								
							if (params.ophalen)
								ilike('ophalen',params.ophalen + '%')
								
							if (params.opmerkingen)
								ilike('opmerkingen',params.opmerkingen + '%')
								
							if (params.afgehandeld)
								ilike('afgehandeld',params.afgehandeld + '%')
								
							if (params.user)
								ilike('user',params.user + '%')						
							
							// set the order and direction
							order(sortIndex, sortOrder).ignoreCase()
					  }
			
			def totalRows = afspraak.totalCount
			def numberOfPages = Math.ceil(totalRows / maxRows)
	  
			def jsonCells = afspraak.collect {
				 [cell: [it.omschrijving,
					 it.begindatum,
					 it.einddatum,
					 it.producten,
					 it.hond,
					 it.ophalen,
					 it.opmerkingen,
					 it.afgehandeld,
					 it.user
					], id: it.id]
			  }
			  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
			  render jsonData as JSON
	}
	
	def jq_edit_afspraak = {
		def afspraak = null
		def message = ""
		def state = "FAIL"
		def id
  
		// determine our action
		switch (params.oper) {
		  case 'add':
			// add instruction sent
			afspraak = new Afspraak(params)
			if (! afspraak.hasErrors() && afspraak.save()) {
			  message = "Afspraak ${afspraak.omschrijving} toegevoegd"
			  id = afspraak.id
			  state = "OK"
			} else {
			  message = "Kan afspraak niet opslaan"
			}
  
			break;
		  case 'del':
			// check exists
			afspraak = Afspraak.get(params.id)
			if (afspraak) {
			  // delete afspraak
			  afspraak.delete()
			  message = "Afspraak ${afspraak.omschrijving} verwijderd"
			  state = "OK"
			}
			break;
		  default:
			// default edit action
			// first retrieve the afspraak by its ID
			afspraak = Afspraak.get(params.id)
			if (afspraak) {
			  // set the properties according to passed in parameters
			  afspraak.properties = params
			  if (! afspraak.hasErrors() && afspraak.save()) {
				message = "Afspraak ${afspraak.omschrijving} bijgewerkt"
				id = afspraak.id
				state = "OK"
			  } else {
				message = "Kan de afspraak niet bijwerken"
			  }
			}
			break;
		}
  
		def response = [message:message,state:state,id:id]
  
		render response as JSON
	  }

}
