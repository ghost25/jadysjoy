package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Afspraak

class HondController {

    def scaffold = com.dabis.trimsalon.model.Hond
	
	def logout = {
		flash.message = "Prettige dag, ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def beforeInterceptor = [action:this.&auth, except:'list']
	
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
}
