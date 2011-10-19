<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <g:set var="entityName" value="${message(code: 'producten.label', default: 'producten')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'producten.id.label', default: 'Id')}" />
                            <g:sortableColumn property="naam" title="${message(code: 'producten.naam.label', default: 'Naam')}" />                        
                            <g:sortableColumn property="omschrijving" title="${message(code: 'producten.omschrijving.label', default: 'Omschrijving')}" />                        
                            <g:sortableColumn property="prijsExbtw" title="${message(code: 'producten.prijsExbtw.label', default: 'Prijs exbtw')}" />                            
                            <g:sortableColumn property="btw" title="${message(code: 'producten.prijs.label', default: 'Prijs')}" />
                            <g:sortableColumn property="voorraad" title="${message(code: 'producten.voorraad.label', default: 'Voorraad')}" />                 
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${productenInstanceList}" status="i" var="productenInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${id}">${fieldValue(bean: productenInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: productenInstance, field: "naam")}</td>                        
                            <td>${fieldValue(bean: productenInstance, field: "omschrijving")}</td>                        
                            <td>€<g:formatNumber number="${productenInstance?.prijsExbtw}" format="##0.00"/></td>
                            <td>€<g:formatNumber number="${productenInstance?.prijs}" format="##0.00"/></td>
                            <td>${fieldValue(bean: productenInstance, field: "voorraad")}</td>                                                   
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
