<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
             <span class="menuButton"><g:link action="logout">Logout</g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${userInstance?.id}" />
                <g:hiddenField name="version" value="${userInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="datum"><g:message code="afspraak.datum.label" default="Datum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'datum', 'errors')}">
                                    <g:textField name="datum" value="${afspraakInstance?.datum}" />
                                </td>
                            </tr>                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="begintijd"><g:message code="afspraak.begintijd.label" default="Begintijd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'begintijd', 'errors')}">
                                    <g:textField name="begintijd" value="${afspraakInstance?.begintijd}" />
                                </td>
                            </tr>
  							<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="eindtijd"><g:message code="afspraak.eindtijd.label" default="Eindtijd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'eindtijd', 'errors')}">
                                    <g:textField name="eindtijd" value="${afspraakInstance?.eindtijd}" />
                                </td>                           
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="producten"><g:message code="afspraak.producten.label" default="Behandeling" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'producten', 'errors')}">
                                    <g:textField name="producten" value="${afspraakInstance?.producten}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hond"><g:message code="afspraak.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'hond', 'errors')}">
                                    <g:textField name="hond" value="${afspraakInstance?.hond}" />
                                </td>
                             </tr> 
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="klant"><g:message code="afspraak.klant.label" default="Klant" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'klant', 'errors')}">
                                    <g:textField name="klant" value="${afspraakInstance?.klant}" />
                                </td>
                             </tr>
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opmerkingen"><g:message code="afspraak.opmerkingen.label" default="Opmerking" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'opmerkingen', 'errors')}">
                                    <g:textField name="opmerkingen" value="${afspraakInstance?.opmerkingen}" />
                                </td>
                             </tr>
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ophalen"><g:message code="afspraak.ophalen.label" default="Ophalen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'ophalen', 'errors')}">
                                    <g:textField name="ophalen" value="${afspraakInstance?.ophalen}" />
                                </td>
                             </tr>
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="afgehandeld"><g:message code="afspraak.afgehandeld.label" default="Afgehandeld" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'afgehandeld', 'errors')}">
                                    <g:textField name="afgehandeld" value="${afspraakInstance?.afgehandeld}" />
                                </td>
                             </tr> 
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="afspraak.user.label" default="Door" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'user', 'errors')}">
                                    <g:textField name="user" value="${afspraakInstance?.afgehandeld}" />
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
