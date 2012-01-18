package com.dabis.trimsalon.controller
import com.dabis.trimsalon.model.Uitgaven
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Afspraak
import grails.converters.JSON

class UitgavenController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [uitgavenInstanceList: Uitgaven.list(params), uitgavenInstanceTotal: Uitgaven.count(),top5Klant: Klant.list(max:5, sort:"dateCreated", order:"desc"),
			top5Hond: Hond.list(max:5, sort:"naam", order:"desc"),
			top5Afspraak: Afspraak.list(max:5, sort:"begindatum", order:"desc"),]
    }

    def create = {
        def uitgavenInstance = new Uitgaven()
        uitgavenInstance.properties = params
        return [uitgavenInstance: uitgavenInstance]
    }

    def save = {
        def uitgavenInstance = new Uitgaven(params)
        if (uitgavenInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), uitgavenInstance.id])}"
            redirect(action: "show", id: uitgavenInstance.id)
        }
        else {
            render(view: "create", model: [uitgavenInstance: uitgavenInstance])
        }
    }

    def show = {
        def uitgavenInstance = Uitgaven.get(params.id)
        if (!uitgavenInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), params.id])}"
            redirect(action: "list")
        }
        else {
            [uitgavenInstance: uitgavenInstance]
        }
    }

    def edit = {
        def uitgavenInstance = Uitgaven.get(params.id)
        if (!uitgavenInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [uitgavenInstance: uitgavenInstance]
        }
    }

    def update = {
        def uitgavenInstance = Uitgaven.get(params.id)
        if (uitgavenInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (uitgavenInstance.version > version) {
                    
                    uitgavenInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'uitgaven.label', default: 'Uitgaven')] as Object[], "Another user has updated this Uitgaven while you were editing")
                    render(view: "edit", model: [uitgavenInstance: uitgavenInstance])
                    return
                }
            }
            uitgavenInstance.properties = params
            if (!uitgavenInstance.hasErrors() && uitgavenInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), uitgavenInstance.id])}"
                redirect(action: "show", id: uitgavenInstance.id)
            }
            else {
                render(view: "edit", model: [uitgavenInstance: uitgavenInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def uitgavenInstance = Uitgaven.get(params.id)
        if (uitgavenInstance) {
            try {
                uitgavenInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'uitgaven.label', default: 'Uitgaven'), params.id])}"
            redirect(action: "list")
        }
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
	
	// return JSON list of uitgaven
	def jq_uitgaven_list = {
			def sortIndex = params.sidx ?: 'omschrijving'
			def sortOrder  = params.sord ?: 'asc'
	  
			def maxRows = Integer.valueOf(params.rows)
			def currentPage = Integer.valueOf(params.page) ?: 1
	  
			def rowOffset = currentPage == 1 ? 0 : (currentPage - 1) * maxRows
			
			def uitgaven = Uitgaven.createCriteria().list(max:maxRows, offset:rowOffset) {
				
							// first name case insensitive where the field begins with the search term
							if (params.omschrijving)
								ilike('omschrijving',params.omschrijving + '%')
							
							if (params.prijsExbtw)
								ilike('prijsExbtw',params.prijsExbtw + '%')
								
							if (params.prijs)
								ilike('prijs',params.prijs + '%')									
							
							// set the order and direction
							order(sortIndex, sortOrder).ignoreCase()
					  }
			
			def totalRows = uitgaven.totalCount
			def numberOfPages = Math.ceil(totalRows / maxRows)
	  
			def jsonCells = uitgaven.collect {
				 [cell: [it.omschrijving,
					 it.prijsExbtw,
					 it.prijs					 
					], id: it.id]
			  }
			  def jsonData= [rows: jsonCells,page:currentPage,records:totalRows,total:numberOfPages]
			  render jsonData as JSON
	}
	
	def jq_edit_uitgaven = {
		def uitgaven = null
		def message = ""
		def state = "FAIL"
		def id
  
		// determine our action
		switch (params.oper) {
		  case 'add':
			// add instruction sent
			uitgaven = new Uitgaven(params)
			if (! uitgaven.hasErrors() && uitgaven.save()) {
			  message = "uitgaven ${uitgaven.omschrijving} toegevoegd"
			  id = uitgaven.id
			  state = "OK"
			} else {
			  message = "Kan uitgaven niet opslaan"
			}
  
			break;
		  case 'del':
			// check uitgaven exists
			uitgaven = Uitgaven.get(params.id)
			if (uitgaven) {
			  // delete uitgaven
			  uitgaven.delete()
			  message = "Uitgaven ${uitgaven.omschrijving} verwijderd"
			  state = "OK"
			}
			break;
		  default:
			// default edit action
			// first retrieve the uitgaven by its ID
			uitgaven = Uitgaven.get(params.id)
			if (uitgaven) {
			  // set the properties according to passed in parameters
			  uitgaven.properties = params
			  if (! uitgaven.hasErrors() && uitgaven.save()) {
				message = "Uitgaven ${uitgaven.omschrijving} bijgewerkt"
				id = uitgaven.id
				state = "OK"
			  } else {
				message = "Kan de uitgaven niet bijwerken"
			  }
			}
			break;
		}
  
		def response = [message:message,state:state,id:id]
  
		render response as JSON
	  }
}
