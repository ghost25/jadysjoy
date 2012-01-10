<%@ page import="com.dabis.trimsalon.model.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>	  
        </div>
        <div id="top5Panel" class="top5Panel">
		<h2>Laatste klant</h2>
		<div id="klant" class="top5Item">
		<g:render template="/klant/klant5"
		model="[klant: top5Klant]"/>
		</div>
		<h2>Laatste hond</h2>
		<div id="hond" class="top5Item">
		<g:render template="/hond/hond5"
		model="[hond: top5Hond]"/>
		</div>
		<h2>Laatste afspraak</h2>
		<div id="afspraak" class="top5Item">
		<g:render template="/afspraak/afspraak5"
		model="[afspraak: top5Afspraak]"/>
		</div>
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
                            <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'Id')}" />
                            <g:sortableColumn property="login" title="${message(code: 'user.login.label', default: 'Login')}" />                        
                            <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />                        
                        	<g:sortableColumn property="naam" title="${message(code: 'user.naam.label', default: 'Naam')}" />                    	
                            <g:sortableColumn property="role" title="${message(code: 'user.role.label', default: 'Role')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">                        
                            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: userInstance, field: "login")}</td>                        
                            <td>********</td>                            
                            <td>${fieldValue(bean: userInstance, field: "naam")}</td>                        
                            <td>${fieldValue(bean: userInstance, field: "role")}</td>                        
                        </tr>
                    </g:each>               
                    </tbody>
                </table>
            </div>
            <div> 
            <g:jasperReport jasper="test" format="PDF" name="All user" />
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
