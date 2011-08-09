package com.dabis.trimsalon.controller

class ProductenController {

	def beforeInterceptor = [action:this.&auth]
	
    def scaffold = com.dabis.trimsalon.model.Producten
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def auth() {
		if(!session.user) {
		  redirect(controller:"user", action:"login")
		  return false
		}
	}

}
