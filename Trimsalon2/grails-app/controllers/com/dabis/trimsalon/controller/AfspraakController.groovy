package com.dabis.trimsalon.controller

class AfspraakController {

    def scaffold = com.dabis.trimsalon.model.Afspraak
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
}


