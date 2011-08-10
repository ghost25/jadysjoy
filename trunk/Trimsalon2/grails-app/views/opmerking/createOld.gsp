<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'opmerking.label', default: 'opmerking')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link action="logout">Logout</g:link></span>
        </div>
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
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hond"><g:message code="opmerking.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'hond', 'errors')}">
                                    <g:textField name="hond" value="${opmerkingInstance?.naam}" />
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
                                    <label for="medischeKenmerken"><g:message code="opmerking.medischeKenmerken.label" default="Medische kenmerken" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'medischeKenmerken', 'errors')}">
                                    <g:textField name="medischeKenmerken" value="${opmerkingInstance?.medischeKenmerken}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="opmerking.dateCreated.label" default="Toegevoegd op" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: opmerkingInstance, field: 'dateCreated', 'errors')}">
                                    <g:textField name="dateCreated" value="${opmerkingInstance?.dateCreated}" />
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
