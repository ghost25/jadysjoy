<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'afspraak.label', default: 'afspraak')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                	<table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.omschrijving.label" default="Omschrijving" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "omschrijving")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.begindatum.label" default="Begindatum" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "begindatum")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.einddatum.label" default="Einddatum" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "einddatum")}</td>
                            
                        </tr>
                        
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.producten.label" default="Producten" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "producten")}</td>
                            
                        </tr>
                        
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.hond.label" default="Hond" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "hond")}</td>
                            
                        </tr>
                        
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.klant.label" default="Klant" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "klant")}</td>
                            
                        </tr>
                        
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.opmerkingen.label" default="Opmerking" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "opmerkingen")}</td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.ophalen.label" default="Ophalen" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "ophalen")}</td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.afgehandeld.label" default="Afgehandeld" /></td>
                            
                            <td valign="top" class="value"> ${fieldValue(bean: afspraakInstance, field: "afgehandeld")}</td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="afspraak.user.label" default="User" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: afspraakInstance, field: "user")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${afspraakInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
					<g:if test="${afspraakInstance?.afgehandeld == 'Ja'}">
                    <span class="button"><g:actionSubmit class="cretae" controller="boekhouding" action="create" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                    </g:if>                
                </g:form>
            </div>
        </div>
        <table>        
    </body>
</html>
