

<%@ page import="com.dabis.trimsalon.model.Opmerking" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'opmerking.label', default: 'Opmerking')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${opmerkingInstance}">
            <div class="errors">
                <g:renderErrors bean="${opmerkingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hond"><g:message code="opmerking.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'hond', 'errors')}">
                                    <g:select name="hond.id" from="${com.dabis.trimsalon.model.Hond.list()}" optionKey="id" value="${opmerkingInstance?.hond?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="advies"><g:message code="opmerking.advies.label" default="Advies" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'advies', 'errors')}">
                                    <g:textField name="advies" value="${opmerkingInstance?.advies}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="gedrag"><g:message code="opmerking.gedrag.label" default="Gedrag" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'gedrag', 'errors')}">
                                    <g:textField name="gedrag" value="${opmerkingInstance?.gedrag}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="medischeKenmerken"><g:message code="opmerking.medischeKenmerken.label" default="Medische Kenmerken" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'medischeKenmerken', 'errors')}">
                                    <g:textField name="medischeKenmerken" value="${opmerkingInstance?.medischeKenmerken}" />
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
