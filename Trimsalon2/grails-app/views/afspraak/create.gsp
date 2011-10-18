<%@ page import="com.dabis.trimsalon.model.Afspraak" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'afspraak.label', default: 'Afspraak')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <g:javascript library="application" />
		<modalbox:modalIncludes />
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${afspraakInstance}">
            <div class="errors">
                <g:renderErrors bean="${afspraakInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="omschrijving"><g:message code="afspraak.omschrijving.label" default="Omschrijving" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'omschrijving', 'errors')}">
                                    <g:textField name="omschrijving" value="${afspraakInstance?.omschrijving}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="begindatum"><g:message code="afspraak.begindatum.label" default="Begindatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'begindatum', 'errors')}">
                                    <g:datePicker name="begindatum" value="${afspraakInstance?.begindatum}" ></g:datePicker>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="einddatum"><g:message code="afspraak.einddatum.label" default="Einddatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'einddatum', 'errors')}">
                                    <g:datePicker name="einddatum" value="${afspraakInstance?.einddatum}" ></g:datePicker>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="allDay"><g:message code="afspraak.allDay.label" default="All Day" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'allDay', 'errors')}">
                                    <g:checkBox name="allDay" value="${afspraakInstance?.allDay}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="producten"><g:message code="afspraak.producten.label" default="Producten" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'producten', 'errors')}">
                                    <g:select name="producten.id" from="${com.dabis.trimsalon.model.Producten.list()}" optionKey="id" value="${afspraakInstance?.producten?.id}" noSelection="${['null':'Selecteer...']}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hond"><g:message code="afspraak.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'hond', 'errors')}">
                                    <g:select name="hond.id" from="${com.dabis.trimsalon.model.Hond.list()}" optionKey="id" value="${afspraakInstance?.hond?.id}" noSelection="${['null':'Selecteer...']}" />
                                </td>
                            </tr>
                            
                         	 <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ophalen"><g:message code="afspraak.ophalen.label" default="Ophalen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'ophalen', 'errors')}">
                                    <g:select name="ophalen" from="${afspraakInstance?.constraints?.ophalen?.inList}" value="${afspraakInstance?.ophalen}" valueMessagePrefix="afspraak.ophalen"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opmerkingen"><g:message code="afspraak.opmerkingen.label" default="Opmerkingen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'opmerkingen', 'errors')}">
                                    <g:textField name="opmerkingen" value="${afspraakInstance?.opmerkingen}" />
                                </td>
                            </tr>                     
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="afgehandeld"><g:message code="afspraak.afgehandeld.label" default="Afgehandeld" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'afgehandeld', 'errors')}">
                                    <g:checkBox name="afgehandeld" value="${afspraakInstance?.afgehandeld}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="afspraak.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.dabis.trimsalon.model.User.list()}" optionKey="id" value="${afspraakInstance?.user?.id}" noSelection="${['null':'Selecteer...']}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="calendar"><g:message code="afspraak.calendar.label" default="Calendar" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'calendar', 'errors')}">
                                    <g:select name="calendar.id" from="${com.dabis.trimsalon.model.Calendar.list()}" optionKey="id" value="${afspraakInstance?.calendar?.id}"  />
                                </td>
                            </tr>
                            
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="afspraak.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.dabis.trimsalon.model.User.list()}" optionKey="id" value="${afspraakInstance?.user?.id}" noSelection="${['null':'Selecteer...']}" />
                                	<modalbox:createLink controller="user" action="listPopup" id="${user}" title="Show user!" width="500">Users</modalbox:createLink>
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
                </g:form>
        </div>
    </body>
</html>