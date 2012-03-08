

<%@ page import="com.dabis.trimsalon.model.Klant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'klant.label', default: 'Klant')}" />
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
            <g:hasErrors bean="${klantInstance}">
            <div class="errors">
                <g:renderErrors bean="${klantInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${klantInstance?.id}" />
                <g:hiddenField name="version" value="${klantInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="naam"><g:message code="klant.naam.label" default="Naam" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'naam', 'errors')}">
                                    <g:textField name="naam" value="${klantInstance?.naam}" style='width: 500px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="adres"><g:message code="klant.adres.label" default="Adres" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'adres', 'errors')}">
                                    <g:textField name="adres" value="${klantInstance?.adres}" style='width: 500px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="huisnummer"><g:message code="klant.huisnummer.label" default="Huisnummer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'huisnummer', 'errors')}">
                                    <g:textField name="huisnummer" value="${klantInstance?.huisnummer}" style='width: 100px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="postcode"><g:message code="klant.postcode.label" default="Postcode" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'postcode', 'errors')}">
                                    <g:textField name="postcode" value="${klantInstance?.postcode}"  style='width: 100px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="woonplaats"><g:message code="klant.woonplaats.label" default="Woonplaats" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'woonplaats', 'errors')}">
                                    <g:textField name="woonplaats" value="${klantInstance?.woonplaats}"  style='width: 500px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="telefoon"><g:message code="klant.telefoon.label" default="Telefoon" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'telefoon', 'errors')}">
                                    <g:textField name="telefoon" value="${fieldValue(bean: klantInstance, field: 'telefoon')}" style='width: 100px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="klant.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${klantInstance?.email}"  style='width: 500px;'/>
                                </td>
                            </tr>                    
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="opmerkingen"><g:message code="klant.opmerkingen.label" default="Opmerkingen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'opmerkingen', 'errors')}">
                                    <g:textField name="opmerkingen" value="${klantInstance?.opmerkingen}"  style='width: 500px;'/>
                                </td>
                            </tr>
                                                                           
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="hond"><g:message code="klant.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'hond', 'errors')}">
                                    
								<ul>
								<g:each in="${klantInstance?.hond?}" var="h">
								    <li><g:link controller="hond" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></li>
								</g:each>
								</ul>
								<g:link controller="hond" action="create" params="['klant.id': klantInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'hond.label', default: 'Hond')])}</g:link>

                                </td>
                            </tr>
                            
                             <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="afspraken"><g:message code="klant.afspraken.label" default="Afspraken" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: klantInstance, field: 'afspraken', 'errors')}">
								<ul>
								<g:each in="${klantInstance?.hond?.afspraken?}" var="h">
								    <li><g:link controller="afspraak" action="show" id="${h.id}">${h?.encodeAsHTML()}</g:link></li>
								</g:each>
								</ul>
								<g:link controller="afspraak" action="create" params="['klant.id': klantInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'afspraak.label', default: 'Afspraak')])}</g:link>
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
