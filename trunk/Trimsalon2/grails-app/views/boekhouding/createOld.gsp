<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'boekhouding.label', default: 'boekhouding')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${boekhoudingInstance}">
            <div class="errors">
                <g:renderErrors bean="${boekhoudingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="factuurnr"><g:message code="boekhouding.factuurnr.label" default="Factuurnummer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'factuurnr', 'errors')}">
                                    <g:textField name="factuurnr" value="${boekhoudingInstance?.factuurnr}" />
                                </td>
                            </tr>                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="boekingsdatum"><g:message code="boekhouding.boekingsdatum.label" default="Boekingsdatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'boekingsdatum', 'errors')}">
                                    <g:textField name="boekingsdatum" value="${boekhoudingInstance?.boekingsdatum}" />
                                </td>
                            </tr>
  							<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="factuurdatum"><g:message code="boekhouding.factuurdatum.label" default="Factuurdatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'factuurdatum', 'errors')}">
                                    <g:textField name="factuurdatum" value="${boekhoudingInstance?.factuurdatum}" />
                                </td>                           
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="prijsExbtw"><g:message code="boekhouding.prijsExbtw.label" default="Prijs exbtw" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'prijsExbtw', 'errors')}">
                                    <g:textField name="prijsExbtw" value="${boekhoudingInstance?.prijsExbtw}" />
                                </td>
                             </tr> 
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="btw"><g:message code="boekhouding.btw.label" default="Btw" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'btw', 'errors')}">
                                    <g:textField name="btw" value="${boekhoudingInstance?.btw}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="betaald"><g:message code="boekhouding.betaald.label" default="Betaald" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: boekhoudingInstance, field: 'betaald', 'errors')}">
                                    <g:textField name="betaald" value="${boekhoudingInstance?.betaald}" />
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
