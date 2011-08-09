package com.dabis.trimsalon.controller

class OpmerkingController {

    def scaffold = com.dabis.trimsalon.model.Opmerking
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
	def beforeInterceptor = [action:this.&auth]
	
	def auth() {
		if(!session.user) {
		  redirect(controller:"user", action:"login")
		  return false
		}
    }
}
