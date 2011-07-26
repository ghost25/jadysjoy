package com.dabis.trimsalon.controller

class BoekhoudingController {

    def scaffold = com.dabis.trimsalon.model.Boekhouding
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
}
