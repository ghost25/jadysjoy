package com.dabis.trimsalon.controller

import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import com.dabis.trimsalon.model.Opmerking
import grails.converters.JSON

class OpmerkingController {

    def scaffold = com.dabis.trimsalon.model.Opmerking
	
	def logout = {
		flash.message = "Prettige dag, ${session.opmerking.login}"
		session.opmerking = null
		redirect(controller:"opmerking", action:"login")
	  }
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	
		def opmerkingList = Opmerking.withCriteria {
		projections {
		distinct "hond"
			}
		}
		[opmerkingInstanceList: Opmerking.list(params), opmerkingInstanceTotal: Opmerking.count(), top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
	}
	
	// return JSON list of opmerking
	def jq_opmerking_list = {
			def sortIndex = params.sidx ?: 'hond'
			def sortOrder  = params.sord ?: 'asc'
	  
			def maxRows = Integer.valueOf(params.rows)
			def currentPage = Integer.valueOf(params.page) ?: 1
	  
			def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
			
			def opmerking = Opmerking.createCriteria().list(max:maxRows, offset:rowOffset) {
				
							// first name case insensitive where the field begins with the search term
							if (params.hond)
								ilike('hond',params.hond + '%')
							
							if (params.advies)
								ilike('advies',params.advies + '%')
								
							if (params.gedrag)
								ilike('gedrag',params.gedrag + '%')
								
							if (params.medischeKenmerken)
								ilike('medischeKenmerken',params.medischeKenmerken + '%')
							
							if (params.dateCreated)
								ilike('dateCreated',params.dateCreated + '%')
							
							// set the order and direction
							order(sortIndex, sortOrder).ignoreCase()
					  }
			
			def totalRows = opmerking.totalCount
			def numberOfPages = Math.ceil(totalRows / maxRows)
	  
			def jsonCells = opmerking.collect {
				 [cell: [it.hond,
					 it.advies,
					 it.gedrag,
					 it.medischeKenmerken,
					 it.dateCreated
					], id: it.id]
			  }
			  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
			  render jsonData as JSON
	}
	
	def jq_edit_opmerking = {
		def opmerking = null
		def message = ""
		def state = "FAIL"
		def id
  
		// determine our action
		switch (params.oper) {
		  case 'add':
			// add instruction sent
			opmerking = new Opmerking(params)
			if (! opmerking.hasErrors() && opmerking.save()) {
			  message = "Opmerking ${opmerking.hond} toegevoegd"
			  id = opmerking.id
			  state = "OK"
			} else {
			  message = "Kan opmerking niet opslaan"
			}
  
			break;
		  case 'del':
			// check exists
			opmerking = Opmerking.get(params.id)
			if (opmerking) {
			  // delete opmerking
			  opmerking.delete()
			  message = "Opmerking ${opmerking.hond} verwijderd"
			  state = "OK"
			}
			break;
		  default:
			// default edit action
			// first retrieve the opmerking by its ID
			opmerking = Opmerking.get(params.id)
			if (opmerking) {
			  // set the properties according to passed in parameters
			  opmerking.properties = params
			  if (! opmerking.hasErrors() && opmerking.save()) {
				message = "Opmerking ${opmerking.hond} bijgewerkt"
				id = opmerking.id
				state = "OK"
			  } else {
				message = "Kan de opmerking niet bijwerken"
			  }
			}
			break;
		}
  
		def response = [message:message,state:state,id:id]
  
		render response as JSON
	  }
}
