package com.dabis.trimsalon.controller
	
abstract class BaseController {
	
	def auth() {
		if(!session.user) {
		def originalRequestParams =
		[controller:controllerName,
		action:actionName]
		originalRequestParams.putAll(params)
		session.originalRequestParams =
		originalRequestParams
		redirect(controller:'user',action:'login')
		return false
		}
  
		if(!session.user.admin){
		  flash.message = "Alleen voor beheerders beschikbaar"
		  redirect(controller:"user", action:"list")
		  return false
		}
	  }
	
}


