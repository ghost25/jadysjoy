<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'producten.label', default: 'producten')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title> 
  </head> 
  <body> 
    <div class="nav">
        <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        <span class="menuButton"><g:link action="logout">Logout</g:link></span>	  
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'producten.id.label', default: 'Id')}" />
                            <g:sortableColumn property="naam" title="${message(code: 'producten.naam.label', default: 'Naam')}" />                        
                            <g:sortableColumn property="omschrijving" title="${message(code: 'producten.omschrijving.label', default: 'Omschrijving')}" />                        
                            <g:sortableColumn property="prijsExbtw" title="${message(code: 'producten.prijsExbtw.label', default: 'Prijs exbtw')}" />                            
                            <g:sortableColumn property="btw" title="${message(code: 'producten.postcode.label', default: 'Btw')}" />
                            <g:sortableColumn property="voorraad" title="${message(code: 'producten.voorraad.label', default: 'Voorraad')}" />
                            <g:sortableColumn property="drempel" title="${message(code: 'producten.drempel.label', default: 'Drempel')}" />                 
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${productenInstanceList}" status="i" var="productenInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${productenInstance.id}">${fieldValue(bean: productenInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: productenInstance, field: "naam")}</td>                        
                            <td>${fieldValue(bean: productenInstance, field: "omschrijving")}</td>                        
                            <td>€<g:formatNumber number="${productenInstance?.prijsExbtw}" format="##0.00"/></td>
                            <td>${fieldValue(bean: productenInstance, field: "btw")}%</td>
                            <td>${fieldValue(bean: productenInstance, field: "voorraad")}</td>
                            <td>${fieldValue(bean: productenInstance, field: "drempel")}</td>                                                   
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${productenInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
