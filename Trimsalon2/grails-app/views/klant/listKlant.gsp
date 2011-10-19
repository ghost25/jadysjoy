<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <g:set var="entityName" value="${message(code: 'hond.label', default: 'hond')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'klant.id.label', default: 'Id')}" />
                            <g:sortableColumn property="naam" title="${message(code: 'klant.naam.label', default: 'Naam')}" />                                                   
                            <g:sortableColumn property="woonplaats" title="${message(code: 'klant.woonplaats.label', default: 'Woonplaats')}" />
                            <g:sortableColumn property="telefoon" title="${message(code: 'klant.telefoon.label', default: 'Telefoon')}" />
                            <g:sortableColumn property="email" title="${message(code: 'klant.email.label', default: 'Email')}" />                                            
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${klantInstanceList}" status="i" var="klantInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${klantInstance.id}">${fieldValue(bean: klantInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: klantInstance, field: "naam")}</td>                        
                            <td>${fieldValue(bean: klantInstance, field: "woonplaats")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "telefoon")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "email")}</td>                                                                               
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
