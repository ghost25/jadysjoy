package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond

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
				
		if (afspraakInstance.save(flush: true)) {
							
			println afspraakInstance.dump()
			println params.dump()
			
			 if( afspraakInstance.afgehandeld==true ) {				 
				flash.message = "${message(code: 'default.created.message', args: [message(code: 'afspraak.label', default: 'Afspraak'), afspraakInstance.id])}"
				redirect(controller:"boekhouding", action: "create")
			}
			else {
			
				try  {
					sendMail {
						to  "${afspraakInstance.klant.email}"
						from "rob.daalman@gmail.com"
						subject "Afspraak trimsalon JadysJoy"
						html g.render(template:'/email/afspraak',model:[afspraakInstance: afspraakInstance])
					}
					flash.message = "Bevestiging afspraak is verstuurd naar ${afspraakInstance.klant.naam}"
					} catch(Exception e){
					log.error "Probleem met versturen email $e.message", e
					flash.message = "Email is niet verstuurd"
						redirect(action: "show", id: afspraakInstance.id)
					}
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
			if (!afspraakInstance.hasErrors() && afspraakInstance.save(flush: true)) {
				if( afspraakInstance.afgehandeld==true ){
			    flash.message = "${message(code: 'default.updated.message', args: [message(code: 'afspraak.label', default: 'Afspraak'), afspraakInstance.id])}"
				redirect(controller:"boekhouding", action: "create")
				}
			    else {
					try  {
						sendMail {
							to  "${afspraakInstance.klant.email}"
							from "rob.daalman@gmail.com"
							subject "Afspraak trimsalon JadysJoy"
							html g.render(template:'/email/afspraak',model:[afspraakInstance: afspraakInstance])
						}
						flash.message = "Bevestiging afspraak is verstuurd naar ${afspraakInstance.klant.naam}"
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
		distinct "datum"
			}
		}
		[afspraakInstanceList: Afspraak.list(params), afspraakInstanceTotal: Afspraak.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"datum", order:"desc"),]
	}
	
	def json={
		render createJSON(Long.parseLong(params.id))
	}

	private String createJSON(long id){
		def json="["
		boolean first=true
		Calendar c=Calendar.get(id)
		c.events.each{
			if(first){
				first=false
				json+="{"
			}
			else {
				json+=",{"
			}

			json+="title:\""+it.summary+"\","
			json+="start:'"+it.startDate+"',"
			json+="end:'"+it.endDate+"',"
			json+="allDay:"+it.allDay+","
			json+="url:\"${request.contextPath}/event/show/"+it.id+"\","
			json+="backgroundColor:'"+c.color+"',"
			json+="textColor:'"+c.textColor+"'"
			json+="}"
		}
		json+="]"
		return json
	}


	def ical={
		render createIcal(Long.parseLong(params.id))
	}

	private String createIcal(long id){
		def df=new java.text.SimpleDateFormat("yyyyMMdd'T'HHmmss")
		Calendar c=Calendar.get(id)
		def ical='''BEGIN:VCALENDAR
X-WR-CALNAME:'''+c.name+'''
X-WR-CALDESC:GRAILS Plugin Calendar
PRODID:-//Francois-Xavier Thoorens/NONSGML Bennu 0.1//EN
VERSION:2.0
'''
		c.events.each{
			ical+="BEGIN:VEVENT\n"
			ical+="UID:"+c.name+it.id+"@grails\n"
			ical+="DTSTAMP:"+df.format(new Date())+"Z\n"
			ical+="SUMMARY:"+it.summary+"\n"
			ical+="DTSTART:"+df.format(it.startDate)+"\n"
			ical+="DTEND:"+df.format(it.endDate)+"\n"
			ical+="DESCRIPTION:"+it.description+"\n"
			ical+="LOCATION:"+it.location+"\n"
			ical+="END:VEVENT\n"
		}
		ical+="END:VCALENDAR\n"
		return ical
	}

}
