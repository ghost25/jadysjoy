package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Inkomsten
import grails.converters.JSON

class InkomstenController {

    def scaffold = com.dabis.trimsalon.model.Inkomsten
	
	def logout = {
		flash.message = "Prettige dag, ${session.inkomsten.login}"
		session.inkomsten = null
		redirect(controller:"inkomsten", action:"login")
	  }
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def inkomstenList = Inkomsten.withCriteria {
		projections {
		distinct "afspraak"
			}
		}
		[inkomstenInstanceList: Inkomsten.list(params), inkomstenInstanceTotal: Inkomsten.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
	
	def listafspraak = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def afspraakList = afspraak.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[afspraakInstanceList: afspraak.list(params)]
	}
	
	def listHond = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def hondList = Hond.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[hondInstanceList: Hond.list(params)]
	}
	
	def listProduct = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def productenList = Producten.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[productenInstanceList: Producten.list(params)]
	}
	
	// return JSON list of inkomsten
	def jq_inkomsten_list = {
			def sortIndex = params.sidx ?: 'afspraak'
			def sortOrder  = params.sord ?: 'asc'
	  
			def maxRows = Integer.valueOf(params.rows)
			def currentPage = Integer.valueOf(params.page) ?: 1
	  
			def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
			
			def inkomsten = Inkomsten.createCriteria().list(max:maxRows, offset:rowOffset) {
				
							// first name case insensitive where the field begins with the search term
							if (params.afspraak)
								ilike('afspraak',params.afspraak + '%')
							
							if (params.dateCreated)
								ilike('dateCreated',params.dateCreated + '%')
								
							if (params.betaald)
								ilike('betaald',params.betaald + '%')								
							
							
							// set the order and direction
							order(sortIndex, sortOrder).ignoreCase()
					  }
			
			def totalRows = inkomsten.totalCount
			def numberOfPages = Math.ceil(totalRows / maxRows)
	  
			def jsonCells = inkomsten.collect {
				 [cell: [it.afspraak,
					 it.dateCreated,
					 it.betaald,
					], id: it.id]
			  }
			  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
			  render jsonData as JSON
	}
	
	def jq_edit_inkomsten = {
		def inkomsten = null
		def message = ""
		def state = "FAIL"
		def id
  
		// determine our action
		switch (params.oper) {
		  case 'add':
			// add instruction sent
			inkomsten = new Inkomsten(params)
			if (! inkomsten.hasErrors() && inkomsten.save()) {
			  message = "Inkomsten ${inkomsten.afspraak} toegevoegd"
			  id = inkomsten.id
			  state = "OK"
			} else {
			  message = "Kan inkomsten niet opslaan"
			}
  
			break;
		  case 'del':
			// check exists
			inkomsten = Inkomsten.get(params.id)
			if (inkomsten) {
			  // delete inkomsten
			  inkomsten.delete()
			  message = "Inkomsten ${inkomsten.afspraak} verwijderd"
			  state = "OK"
			}
			break;
		  default:
			// default edit action
			// first retrieve the inkomsten by its ID
			inkomsten = Inkomsten.get(params.id)
			if (inkomsten) {
			  // set the properties according to passed in parameters
			  inkomsten.properties = params
			  if (! inkomsten.hasErrors() && inkomsten.save()) {
				message = "Inkomsten ${inkomsten.afspraak} bijgewerkt"
				id = inkomsten.id
				state = "OK"
			  } else {
				message = "Kan de inkomsten niet bijwerken"
			  }
			}
			break;
		}
  
		def response = [message:message,state:state,id:id]
  
		render response as JSON
	  }
}
