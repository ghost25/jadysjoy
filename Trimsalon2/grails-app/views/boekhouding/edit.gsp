

<%@ page import="com.dabis.trimsalon.model.Boekhouding" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'boekhouding.label', default: 'Boekhouding')}" />
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
            <g:hasErrors bean="${boekhoudingInstance}">
            <div class="errors">
                <g:renderErrors bean="${boekhoudingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${boekhoudingInstance?.id}" />
                <g:hiddenField name="version" value="${boekhoudingInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="begindatum"><g:message code="boekhouding.begindatum.label" default="Begindatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'begindatum', 'errors')}">
                                    <g:select name="begindatum.id" from="${com.dabis.trimsalon.model.Afspraak.list()}" optionKey="id" value="${boekhoudingInstance?.begindatum?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="prijsExbtw"><g:message code="boekhouding.prijsExbtw.label" default="Prijs Exbtw" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'prijsExbtw', 'errors')}">
                                    <g:select name="prijsExbtw.id" from="${com.dabis.trimsalon.model.Producten.list()}" optionKey="id" value="${boekhoudingInstance?.prijsExbtw?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="prijs"><g:message code="boekhouding.prijs.label" default="Prijs" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'prijs', 'errors')}">
                                    <g:select name="prijs.id" from="${com.dabis.trimsalon.model.Producten.list()}" optionKey="id" value="${boekhoudingInstance?.prijs?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="hond"><g:message code="boekhouding.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'hond', 'errors')}">
                                    <g:select name="hond.id" from="${com.dabis.trimsalon.model.Afspraak.list()}" optionKey="id" value="${boekhoudingInstance?.hond?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="betaald"><g:message code="boekhouding.betaald.label" default="Betaald" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'betaald', 'errors')}">
                                    <g:checkBox name="betaald" value="${boekhoudingInstance?.betaald}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="afspraak"><g:message code="boekhouding.afspraak.label" default="Afspraak" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'afspraak', 'errors')}">
                                    <g:select name="afspraak.id" from="${com.dabis.trimsalon.model.Afspraak.list()}" optionKey="id" value="${boekhoudingInstance?.afspraak?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="producten"><g:message code="boekhouding.producten.label" default="Producten" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'producten', 'errors')}">
                                    <g:select name="producten.id" from="${com.dabis.trimsalon.model.Producten.list()}" optionKey="id" value="${boekhoudingInstance?.producten?.id}"  />
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
