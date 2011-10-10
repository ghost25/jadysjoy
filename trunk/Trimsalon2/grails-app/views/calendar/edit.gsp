

<%@ page import="com.dabis.trimsalon.model.Calendar" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'calendar.label', default: 'Calendar')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${calendarInstance}">
            <div class="errors">
                <g:renderErrors bean="${calendarInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${calendarInstance?.id}" />
                <g:hiddenField name="version" value="${calendarInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="calendar.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: calendarInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${calendarInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="color"><g:message code="calendar.color.label" default="Color" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: calendarInstance, field: 'color', 'errors')}">
                                    <g:textField name="color" value="${calendarInstance?.color}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="textColor"><g:message code="calendar.textColor.label" default="Text Color" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: calendarInstance, field: 'textColor', 'errors')}">
                                    <g:textField name="textColor" value="${calendarInstance?.textColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="afspraak"><g:message code="calendar.afspraak.label" default="Afspraak" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: calendarInstance, field: 'afspraak', 'errors')}">
                                    
<ul>
<g:each in="${calendarInstance?.afspraak?}" var="a">
    <li><g:link controller="afspraak" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="afspraak" action="create" params="['calendar.id': calendarInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'afspraak.label', default: 'Afspraak')])}</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Weet je zeker dat je dit wilt verwijderen?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
