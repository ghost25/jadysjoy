package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Producten
import grails.converters.JSON

class ProductenController {
	
    def scaffold = com.dabis.trimsalon.model.Producten
	
	def logout = {
		flash.message = "Prettige dag, ${session.producten.login}"
		session.producten = null
		redirect(controller:"producten", action:"login")
	  }
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def productenList = Producten.withCriteria {
		projections {
		distinct "naam"
			}
		}
		[productenInstanceList: Producten.list(params), productenInstanceTotal: Producten.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
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
	
	// return JSON list of producten
	def jq_producten_list = {
			def sortIndex = params.sidx ?: 'naam'
			def sortOrder  = params.sord ?: 'asc'
	  
			def maxRows = Integer.valueOf(params.rows)
			def currentPage = Integer.valueOf(params.page) ?: 1
	  
			def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
			
			def producten = Producten.createCriteria().list(max:maxRows, offset:rowOffset) {
				
							// first name case insensitive where the field begins with the search term
							if (params.naam)
								ilike('naam',params.naam + '%')
							
							if (params.omschrijving)
								ilike('omschrijving',params.omschrijving + '%')
								
							if (params.ras)
								ilike('ras',params.ras + '%')
								
							if (params.prijsExbtw)
								ilike('prijsExbtw',params.prijsExbtw + '%')
								
							if (params.prijs)
								ilike('prijs',params.prijs + '%')
								
							if (params.voorraad)
								ilike('voorraad',params.voorraad + '%')
							
							// set the order and direction
							order(sortIndex, sortOrder).ignoreCase()
					  }
			
			def totalRows = producten.totalCount
			def numberOfPages = Math.ceil(totalRows / maxRows)
	  
			def jsonCells = producten.collect {
				 [cell: [it.naam,
					 it.omschrijving,
					 it.ras,
					 it.prijsExbtw,
					 it.prijs,
					 it.voorraad
					], id: it.id]
			  }
			  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
			  render jsonData as JSON
	}
	
	def jq_edit_producten = {
		def producten = null
		def message = ""
		def state = "FAIL"
		def id
  
		// determine our action
		switch (params.oper) {
		  case 'add':
			// add instruction sent
			producten = new Producten(params)
			if (! producten.hasErrors() && producten.save()) {
			  message = "Product ${producten.naam} toegevoegd"
			  id = producten.id
			  state = "OK"
			} else {
			  message = "Kan product niet opslaan"
			}
  
			break;
		  case 'del':
			// check exists
			producten = Producten.get(params.id)
			if (producten) {
			  // delete producten
			  producten.delete()
			  message = "Product ${producten.naam} verwijderd"
			  state = "OK"
			}
			break;
		  default:
			// default edit action
			// first retrieve the producten by its ID
			producten = Producten.get(params.id)
			if (producten) {
			  // set the properties according to passed in parameters
			  producten.properties = params
			  if (! producten.hasErrors() && producten.save()) {
				message = "Product ${producten.naam} bijgewerkt"
				id = producten.id
				state = "OK"
			  } else {
				message = "Kan product niet bijwerken"
			  }
			}
			break;
		}
  
		def response = [message:message,state:state,id:id]
  
		render response as JSON
	  }

}
