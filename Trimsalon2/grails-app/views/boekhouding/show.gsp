<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    	<meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'boekhouding.label', default: 'boekhouding')}" />
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
                            <td valign="top" class="name"><g:message code="boekhouding.factuurnr.label" default="Factuurnummer" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: boekhoudingInstance, field: "factuurnr")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="boekhouding.boekingsdatum.label" default="Boekingsdatum" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${boekhoudingInstance?.boekingsdatum}" format="dd-MMM-yyyy"/></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="boekhouding.factuurdatum.label" default="Factuurdatum" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${boekhoudingInstance?.factuurdatum}" format="dd-MMM-yyyy"/></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="boekhouding.prijsExbtw.label" default="Prijs exbtw" /></td>
                            
                            <td valign="top" class="value">€<g:formatNumber number="${boekhoudingInstance?.prijsExbtw}" format="##0.00"/></td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="boekhouding.btw.label" default="Btw" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: boekhoudingInstance, field: "btw")}%</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="boekhouding.betaald.label" default="Betaald" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: boekhoudingInstance, field: "betaald")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${boekhoudingInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
                </g:form>
            </div>
        </div>
        <table>        
    </body>
</html>
