package com.dabis.trimsalon.controller

class HondController {

    def scaffold = com.dabis.trimsalon.model.Hond
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
	
}
