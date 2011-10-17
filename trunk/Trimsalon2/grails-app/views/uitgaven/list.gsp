
<%@ page import="com.dabis.trimsalon.model.Uitgaven" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'uitgaven.label', default: 'Uitgaven')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'uitgaven.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="omschrijving" title="${message(code: 'uitgaven.omschrijving.label', default: 'Omschrijving')}" />
                        
                            <g:sortableColumn property="prijsExbtw" title="${message(code: 'uitgaven.prijsExbtw.label', default: 'Prijs Exbtw')}" />
                            
                            <g:sortableColumn property="prijs" title="${message(code: 'uitgaven.prijs.label', default: 'Prijs')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${uitgavenInstanceList}" status="i" var="uitgavenInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${uitgavenInstance.id}">${fieldValue(bean: uitgavenInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: uitgavenInstance, field: "omschrijving")}</td>
                        
                            <td>€<g:formatNumber number="${uitgavenInstance?.prijsExbtw}" format="##0.00"/></td>
                            
                            <td>€<g:formatNumber number="${uitgavenInstance?.prijs}" format="##0.00"/></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${uitgavenInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
