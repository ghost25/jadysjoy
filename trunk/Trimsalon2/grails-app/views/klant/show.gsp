<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'klant.label', default: 'klant')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link action="logout">Logout</g:link></span>	  
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
                            <td valign="top" class="name"><g:message code="klant.naam.label" default="Naam" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "naam")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.adres.label" default="Adres" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "adres")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.huisnummer.label" default="Huisnummer" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "huisnummer")}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.postcode.label" default="Postcode" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "postcode")}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.woonplaats.label" default="Woonplaats" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "woonplaats")}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.telefoon.label" default="Telefoon" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "telefoon")}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.email.label" default="Email" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "email")}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.ophalen.label" default="Ophalen" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "ophalen")}</td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.opmerkingen.label" default="Opmerking" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: klantInstance, field: "opmerkingen")}</td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="klant.hond.label" default="Hond" /></td>
                            
                            <td valign="top" class="value"><ul><g:each in="${klantInstance}" var="klant"><li>${klant.hond.naam}</li></g:each></ul></td>
                            
                        </tr>
                        
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${klantInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
                </g:form>
            </div>
        </div>
        <table>        
    </body>
</html>
