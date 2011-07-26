package com.dabis.trimsalon.controller

class KlantController {

    def scaffold = com.dabis.trimsalon.model.Klant
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
}
