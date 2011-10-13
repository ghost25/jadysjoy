
<%@ page import="com.dabis.trimsalon.model.Boekhouding" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'boekhouding.label', default: 'Boekhouding')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="user" action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'boekhouding.id.label', default: 'Id')}" />
                        
                            <th><g:message code="boekhouding.afspraak.label" default="Afspraak" /></th>
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'boekhouding.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="betaald" title="${message(code: 'boekhouding.betaald.label', default: 'Betaald')}" />
                            
                            <g:sortableColumn property="prijsExbtw" title="${message(code: 'boekhouding.prijsExbtw.label', default: 'Prijs exbtw')}" />
                            
                            <g:sortableColumn property="prijs" title="${message(code: 'boekhouding.prijs.label', default: 'Prijs')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${boekhoudingInstanceList}" status="i" var="boekhoudingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${boekhoudingInstance.id}">${fieldValue(bean: boekhoudingInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: boekhoudingInstance, field: "afspraak")}</td>
                        
                            <td><g:formatDate date="${boekhoudingInstance.dateCreated}" /></td>
                        
                            <td><g:formatBoolean boolean="${boekhoudingInstance.betaald}" /></td>
                        	
                        	<td>€<g:formatNumber number="${boekhoudingInstance?.afspraak?.producten?.prijsExbtw}" format="##0.00"/></td>               	                                                    	
                        	
                        	<td>€<g:formatNumber number="${boekhoudingInstance?.afspraak?.producten.prijs}" format="##0.00"/></td>
                        	
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${boekhoudingInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
