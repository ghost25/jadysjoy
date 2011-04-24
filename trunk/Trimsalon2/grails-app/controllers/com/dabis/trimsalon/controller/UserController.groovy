package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.User

class UserController {
	static allowedMethods = [save: "POST",
							update: "POST",
							delete: "POST"]
	def index = {
		redirect(action: "list", params: params)
	}
	
	def list = {
		params.max = Math.min(params.max ?
			params.int('max') : 10, 100)
		[userInstanceList: User.list(params),
			userInstanceTotal: User.count()]
	}
	
	def create = {
		def userInstance = new User()
		userInstance.properties = params
		return [userInstance: userInstance]
	}
	
	def save = {
		def userInstance = new User(params)
		if (userInstance.save(flush: true)) {
		flash.message="${message(code: 'default.created.message',args: [message(code: 'user.label',default: 'User'), userInstance.id])}"
		redirect(action: "show", id: userInstance.id)
		}
		else {
		render(view:"create",model: [userInstance: userInstance])
		}
	 }

		def show = { 
		def userInstance = User.get(params.id)
		if (!userInstance) {
		flash.message="${message(code:'default.not.found.message',args: [message(code: 'user.label',default: 'User'), params.id])}"
          redirect(action: "list")
         }
     else {
       [userInstance: userInstance]
     }
	}		
	
	def edit = { }
	def update = { }
	def delete = { }
	
	def login = {}
	def logout = {
		flash.message = "Goodbye ${session.user.login}"
		session.user = null
		redirect(action:"login")
		}
	
	def authenticate = {
		def user =
		User.findByLoginAndPassword(params.login,
		params.password)
		if(user){
		session.user = user
		flash.message = "Hello ${user.login}!"
		redirect(controller:"afspraak", action:"list")
		}else{
		flash.message =
		"Sorry, ${params.login}. Please try again."
		redirect(action:"login")
		}
		}
}