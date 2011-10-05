package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Opmerking

class OpmerkingController {

    def scaffold = com.dabis.trimsalon.model.Opmerking
	
	def logout = {
		flash.message = "Prettige dag, ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def beforeInterceptor = [action:this.&auth]
	
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
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def opmerkingList = Opmerking.withCriteria {
		projections {
		distinct "hond"
			}
		}
		[opmerkingInstanceList: Opmerking.list(params), opmerkingInstanceTotal: Opmerking.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
}
