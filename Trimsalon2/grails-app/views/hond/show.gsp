<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hond.label', default: 'hond')}" />
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
                            <td valign="top" class="name"><g:message code="hond.naam.label" default="Naam" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "naam")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.ras.label" default="Ras" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "ras")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.geslacht.label" default="Geslacht" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "geslacht")}</td>
                            
                        </tr>
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.kleur.label" default="Kleur" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "kleur")}</td>
                            
                        </tr>
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.gecastreerd.label" default="Gecastreerd" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "gecastreerd")}</td>
                            
                        </tr>
                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.leeftijd.label" default="Leeftijd" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "leeftijd")}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.klant.label" default="Klant" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "klant")}</td>
                            
                        </tr> 
                       	<tr class="prop">
                            <td valign="top" class="name"><g:message code="hond.postcode.label" default="Postcode" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: hondInstance, field: "klant.postcode")}</td>
                            
                        </tr>  						                                                                                                                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${hondInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
                </g:form>
            </div>
        </div>
        <table>        
    </body>
</html>
