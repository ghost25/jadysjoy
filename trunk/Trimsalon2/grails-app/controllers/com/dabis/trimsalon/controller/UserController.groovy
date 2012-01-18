package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.User
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Calendar
import grails.converters.JSON

class UserController {
	
		static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
		def beforeInterceptor = [action:this.&auth,
				   except:['login', 'logout', 'authenticate']]
	
		def auth() {
		  if(!session.user) {
			  
			  def originalRequestParams =
			  [controller:controllerName,
			  action:actionName]
			  originalRequestParams.putAll(params)
			  session.originalRequestParams =
			  originalRequestParams
			  
			redirect(controller:"user", action:"login")
			return false
		  }
	
		  if(!session.user.admin){
			flash.message = "Alleen voor beheerders beschikbaar"
			redirect(controller:"user", action:"list")
			return false
		  }
		}
		
	def login = {
			if (request.method == "GET") {
			session.userId = null
			def user = new User()
			}
			else {
			def user =
			User.findByUserIdAndPassword(params.userId,
			params.password)
			if (user) {
			session.userId = user.userId
			
			def redirectParams =
			session.originalRequestParams ?
			session.originalRequestParams :
			[controller:'calendar', action:'show', id:'1']
			redirect(redirectParams)
			
			}
			else {
			flash['message'] = 'Please enter a valid user ID and password'
			}
			}
			}
	
		def logout = {
		  flash.message = "Prettige dag ${session.user.login}"
		  session.user = null
		  redirect(action:"login")
		}
		
		def authenticate = {
		  def user = User.findByLoginAndPassword(params.login,
												 params.password)
		  if(user){
			session.user = user
			flash.message = "Welkom ${user.login}!"
			if(user.admin){
			  redirect(controller:'calendar', action:'show', id:'1')
			} else{
			  redirect(controller:'calendar', action:'show', id:'1')
			}
		  }else{
			flash.message =
			   "Sorry. Gebruikesnaam of wachtwoord niet juist, probeer opnieuw!"
			redirect(action:"login")
		  }
		}
	
	
	
		def index = {
			redirect(action: "list", params: params)
		}
	
		def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def userList = User.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[userInstanceList: User.list(params), userInstanceTotal: User.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
		
		def listPopup = {
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
		
			def userList = User.withCriteria {
			projections {
			distinct "naam"
				}
			}
			[userInstanceList: User.list(params), userInstanceTotal: User.count()]
		}
	
		def create = {
			def userInstance = new User()
			userInstance.properties = params
			return [userInstance: userInstance]
		}
	
		def save = {
			def userInstance = new User(params)
			if (userInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
				redirect(action: "show", id: userInstance.id)
			}
			else {
				render(view: "create", model: [userInstance: userInstance])
			}
		}
	
		def show = {
			def userInstance = User.get(params.id)
			if (!userInstance) {
				flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
				redirect(action: "list")
			}
			else {
				[userInstance: userInstance]
			}
		}
	
		def edit = {
			def userInstance = User.get(params.id)
			if (!userInstance) {
				flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
				redirect(action: "list")
			}
			else {
				return [userInstance: userInstance]
			}
		}
	
		def update = {
			def userInstance = User.get(params.id)
			if (userInstance) {
				if (params.version) {
					def version = params.version.toLong()
					if (userInstance.version > version) {
						
						userInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'user.label', default: 'User')] as Object[], "Another user has updated this User while you were editing")
						render(view: "edit", model: [userInstance: userInstance])
						return
					}
				}
				userInstance.properties = params
				if (!userInstance.hasErrors() && userInstance.save(flush: true)) {
					flash.message = "${message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
					redirect(action: "show", id: userInstance.id)
				}
				else {
					render(view: "edit", model: [userInstance: userInstance])
				}
			}
			else {
				flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
				redirect(action: "list")
			}
		}
	
		def delete = {
			def userInstance = User.get(params.id)
			if (userInstance) {
				try {
					userInstance.delete(flush: true)
					flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
					redirect(action: "list")
				}
				catch (org.springframework.dao.DataIntegrityViolationException e) {
					flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
					redirect(action: "show", id: params.id)
				}
			}
			else {
				flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
				redirect(action: "list")
			}
		}
		
		// return JSON list of user
		def jq_user_list = {
				def sortIndex = params.sidx ?: 'naam'
				def sortOrder  = params.sord ?: 'asc'
		  
				def maxRows = Integer.valueOf(params.rows)
				def currentPage = Integer.valueOf(params.page) ?: 1
		  
				def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
				
				def user = User.createCriteria().list(max:maxRows, offset:rowOffset) {
					
								// first name case insensitive where the field begins with the search term
								if (params.login)
									ilike('login',params.login + '%')
								
								if (params.password)
									ilike('password',params.password + '%')
									
								if (params.naam)
									ilike('naam',params.naam + '%')
									
								if (params.role)
									ilike('role',params.role + '%')
								
								// set the order and direction
								order(sortIndex, sortOrder).ignoreCase()
						  }
				
				def totalRows = user.totalCount
				def numberOfPages = Math.ceil(totalRows / maxRows)
		  
				def jsonCells = user.collect {
					 [cell: [it.login,
						 it.password,
						 it.naam,
						 it.role
						], id: it.id]
				  }
				  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
				  render jsonData as JSON
		}
		
		def jq_edit_user = {
			def user = null
			def message = ""
			def state = "FAIL"
			def id
	  
			// determine our action
			switch (params.oper) {
			  case 'add':
				// add instruction sent
				user = new User(params)
				if (! user.hasErrors() && user.save()) {
				  message = "Gebruiker ${user.naam} toegevoegd"
				  id = user.id
				  state = "OK"
				} else {
				  message = "Kan gebruiker niet opslaan"
				}
	  
				break;
			  case 'del':
				// check exists
				user = User.get(params.id)
				if (user) {
				  // delete user
				  user.delete()
				  message = "Gebruiker ${user.naam} verwijderd"
				  state = "OK"
				}
				break;
			  default:
				// default edit action
				// first retrieve the user by its ID
				user = User.get(params.id)
				if (user) {
				  // set the properties according to passed in parameters
				  user.properties = params
				  if (! user.hasErrors() && user.save()) {
					message = "Gebruiker ${user.naam} bijgewerkt"
					id = user.id
					state = "OK"
				  } else {
					message = "Kan de gebruiker niet bijwerken"
				  }
				}
				break;
			}
	  
			def response = [message:message,state:state,id:id]
	  
			render response as JSON
		  }
	}