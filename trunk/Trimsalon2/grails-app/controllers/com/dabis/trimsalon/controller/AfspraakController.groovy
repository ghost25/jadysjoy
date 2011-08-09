package com.dabis.trimsalon.controller

class AfspraakController {

    def scaffold = com.dabis.trimsalon.model.Afspraak
	
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


