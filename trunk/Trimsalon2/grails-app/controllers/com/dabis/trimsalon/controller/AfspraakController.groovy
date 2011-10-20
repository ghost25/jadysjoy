package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Producten
import com.dabis.trimsalon.model.User
import com.dabis.trimsalon.model.Calendar

class AfspraakController {

    def scaffold = com.dabis.trimsalon.model.Afspraak
	
	def logout = {
		flash.message = "Prettige dag, ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def beforeInterceptor = [action:this.&auth, except:'list']
	
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
					
					afspraakance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'user.label', default: 'Afspraak')] as Object[], "Another user has updated this User while you were editing")
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
				render(view: "edit", model: [userInstance: afspraakInstance])
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

	
	def listUser = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def userList = User.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[userInstanceList: User.list(params)]
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
	
	def selectUser={
		def userInstance = User.get(params.id)
		println "Dump voor get:"+params.dump()
				
		}

}
