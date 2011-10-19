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
                            <g:sortableColumn property="id" title="${message(code: 'hond.id.label', default: 'Id')}" />
                            <g:sortableColumn property="naam" title="${message(code: 'hond.naam.label', default: 'Naam')}" />                        
                            <g:sortableColumn property="ras" title="${message(code: 'hond.ras.label', default: 'Ras')}" />                        
                            <g:sortableColumn property="geslacht" title="${message(code: 'hond.geslacht.label', default: 'Geslacht')}" />                            
                            <g:sortableColumn property="kleur" title="${message(code: 'hond.kleur.label', default: 'Kleur')}" />
                            <g:sortableColumn property="gecastreerd" title="${message(code: 'hond.gecastreerd.label', default: 'Gecastreerd')}" />
                            <g:sortableColumn property="leeftijd" title="${message(code: 'hond.leeftijd.label', default: 'Leeftijd')}" />
                            <g:sortableColumn property="klant" title="${message(code: 'hond.klant.label', default: 'Klant')}" />                  
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${hondInstanceList}" status="i" var="hondInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">                        
                            <td><g:link action="show" id="${hondInstance.id}">${fieldValue(bean: hondInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: hondInstance, field: "naam")}</td>                        
                            <td>${fieldValue(bean: hondInstance, field: "ras")}</td>                        
                            <td>${fieldValue(bean: hondInstance, field: "geslacht")}</td>
                            <td>${fieldValue(bean: hondInstance, field: "kleur")}</td>
                            <td>${fieldValue(bean: hondInstance, field: "gecastreerd")}</td>
                            <td>${fieldValue(bean: hondInstance, field: "leeftijd")}</td>
                            <td>${fieldValue(bean: hondInstance, field: "klant")}</td>                                                    
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
