package com.dabis.trimsalon.controller

class OpmerkingController {

    def scaffold = com.dabis.trimsalon.model.Opmerking
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
}
