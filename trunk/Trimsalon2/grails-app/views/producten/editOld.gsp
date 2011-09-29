<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'producten.label', default: 'producten')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productenInstance}">
            <div class="errors">
                <g:renderErrors bean="${productenInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${productenInstance?.id}" />
                <g:hiddenField name="version" value="${productenInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="naam"><g:message code="producten.naam.label" default="Naam" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'naam', 'errors')}">
                                    <g:textField name="naam" value="${productenInstance?.naam}" />
                                </td>
                            </tr>                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="omschrijving"><g:message code="producten.omschrijving.label" default="Omschrijving" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'omschrijving', 'errors')}">
                                    <g:textField name="omschrijving" value="${productenInstance?.omschrijving}" />
                                </td>
                            </tr>
  							<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="prijsExbtw"><g:message code="producten.prijsExbtw.label" default="Prijs exbtw" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'prijsExbtw', 'errors')}">
                                    <g:textField name="prijsExbtw" value="${productenInstance?.prijsExbtw}" />
                                </td>                           
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="btw"><g:message code="producten.btw.label" default="Btw" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'btw', 'errors')}">
                                    <g:textField name="btw" value="${productenInstance?.btw}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="voorraad"><g:message code="producten.voorraad.label" default="Voorraad" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'voorraad', 'errors')}">
                                    <g:textField name="voorraad" value="${productenInstance?.voorraad}" />
                                </td>
                             </tr> 
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="drempel"><g:message code="producten.drempel.label" default="Drempel voorraad" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: productenInstance, field: 'drempel', 'errors')}">
                                    <g:textField name="drempel" value="${productenInstance?.drempel}" />
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
