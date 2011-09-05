package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak

class KlantController {

    def scaffold = com.dabis.trimsalon.model.Klant
	
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
	
	def search = {
			if (request.method == 'POST') {
			def criteria = Naam.createCriteria()
			def results = criteria {
			and {
			like('city', '%' + params.naam + '%')
			like('state', '%' + params.woonplaats + '%')
			}
			}
			render(view:'searchresults', model:[ klantList: results ])
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
			top5Afspraak: Afspraak.list(max:5, sort:"datum", order:"desc"),]
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
}
	

