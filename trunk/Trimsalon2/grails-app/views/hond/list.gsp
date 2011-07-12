<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hond.label', default: 'Hond')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="naam" title="${message(code: 'hond.naam.label', default: 'Naam')}" />
                        
                            <g:sortableColumn property="ras" title="${message(code: 'hond.ras.label', default: 'Ras')}" />
                        
                            <g:sortableColumn property="geboortedatum" title="${message(code: 'hond.geboortedatum.label', default: 'Geboortedatum')}" />
                        
                            <g:sortableColumn property="klant" title="${message(code: 'hond.klant.label', default: 'Klant')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${hondInstanceList}" status="i" var="hondInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${hondInstance.id}">${fieldValue(bean: hondInstance, field: "naam")}</g:link></td>
                        
                            <td>${fieldValue(bean: hondInstance, field: "ras")}</td>
                        
                            <td>${fieldValue(bean: hondInstance, field: "geboortedatum")}</td>
                        
                            <td>${fieldValue(bean: hondInstance, field: "klant")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${hondInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
