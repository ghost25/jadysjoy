package com.dabis.trimsalon.controller

class ProductenController {

    def scaffold = com.dabis.trimsalon.model.Producten
	
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(controller:"user", action:"login")
	  }
}
