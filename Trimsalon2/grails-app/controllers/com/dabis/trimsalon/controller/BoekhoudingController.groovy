package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Boekhouding

class BoekhoudingController {

    def scaffold = com.dabis.trimsalon.model.Boekhouding
	
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
	
		def boekhoudingList = Boekhouding.withCriteria {
		projections {
		distinct "datum"
			}
		}
		[boekhoudingInstanceList: Boekhouding.list(params), boekhoudingInstanceTotal: Boekhouding.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"datum", order:"desc"),]
	}
}
