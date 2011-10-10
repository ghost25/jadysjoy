
<%@ page import="com.dabis.trimsalon.model.Calendar" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'calendar.label', default: 'Calendar')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'calendar.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'calendar.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="color" title="${message(code: 'calendar.color.label', default: 'Color')}" />
                        
                            <g:sortableColumn property="textColor" title="${message(code: 'calendar.textColor.label', default: 'Text Color')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${calendarInstanceList}" status="i" var="calendarInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${calendarInstance.id}">${fieldValue(bean: calendarInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: calendarInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: calendarInstance, field: "color")}</td>
                        
                            <td>${fieldValue(bean: calendarInstance, field: "textColor")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${calendarInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
