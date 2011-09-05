<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'producten.label', default: 'producten')}" />
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
                            <td valign="top" class="name"><g:message code="producten.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: productenInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="producten.naam.label" default="Naam" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: productenInstance, field: "naam")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="producten.omschrijving.label" default="Omschrijving" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: productenInstance, field: "omschrijving")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="producten.prijsExbtw.label" default="Prijs exbtw" /></td>
                            
                            <td valign="top" class="value">€<g:formatNumber number="${productenInstance?.prijsExbtw}" format="##0.00"/></td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="producten.prijs.label" default="Prijs" /></td>
                            
                            <td valign="top" class="value">€<g:formatNumber number="${productenInstance?.prijs}" format="##0.00"/></td>
                            
                        </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="producten.voorraad.label" default="Voorraad" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: productenInstance, field: "voorraad")}</td>
                            
                        </tr>
                                             
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${productenInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
                </g:form>
            </div>
        </div>
        <table>        
    </body>
</html>
