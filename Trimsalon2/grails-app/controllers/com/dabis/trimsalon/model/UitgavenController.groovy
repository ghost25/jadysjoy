package com.dabis.trimsalon.model

class UitgavenController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [uitgavenInstanceList: Uitgaven.list(params), uitgavenInstanceTotal: Uitgaven.count()]
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
}
