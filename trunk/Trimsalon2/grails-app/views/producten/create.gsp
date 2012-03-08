

<%@ page import="com.dabis.trimsalon.model.Producten" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'producten.label', default: 'Producten')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productenInstance}">
            <div class="errors">
                <g:renderErrors bean="${productenInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="naam"><g:message code="producten.naam.label" default="Naam" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'naam', 'errors')}">
                                    <g:textField name="naam" value="${productenInstance?.naam}"  style='width: 500px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="omschrijving"><g:message code="producten.omschrijving.label" default="Omschrijving" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'omschrijving', 'errors')}">
                                    <g:textField name="omschrijving" value="${productenInstance?.omschrijving}"  style='width: 500px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ras"><g:message code="producten.ras.label" default="Ras" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'ras', 'errors')}">
                                    <g:textField name="ras" value="${productenInstance?.ras}"  style='width: 500px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="prijsExbtw"><g:message code="producten.prijsExbtw.label" default="Prijs Exbtw" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'prijsExbtw', 'errors')}">
                                    <g:textField name="prijsExbtw" value="${fieldValue(bean: productenInstance, field: 'prijsExbtw')}"  style='width: 100px;'/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="voorraad"><g:message code="producten.voorraad.label" default="Voorraad" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'voorraad', 'errors')}">
                                    <g:textField name="voorraad" value="${fieldValue(bean: productenInstance, field: 'voorraad')}"  style='width: 100px;'/>
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
