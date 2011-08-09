<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'klant.label', default: 'Klant')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'klant.id.label', default: 'Id')}" />
                            <g:sortableColumn property="naam" title="${message(code: 'klant.naam.label', default: 'Naam')}" />                        
                            <g:sortableColumn property="adres" title="${message(code: 'klant.adres.label', default: 'Adres')}" />                        
                            <g:sortableColumn property="huisnummer" title="${message(code: 'klant.huisnummer.label', default: 'Huisnummer')}" />                            
                            <g:sortableColumn property="postcode" title="${message(code: 'klant.postcode.label', default: 'Postcode')}" />
                            <g:sortableColumn property="woonplaats" title="${message(code: 'klant.woonplaats.label', default: 'Woonplaats')}" />
                            <g:sortableColumn property="telefoon" title="${message(code: 'klant.telefoon.label', default: 'Telefoon')}" />
                            <g:sortableColumn property="telefoon2" title="${message(code: 'klant.telefoon2.label', default: 'Mobiel')}" />
                            <g:sortableColumn property="email" title="${message(code: 'klant.email.label', default: 'Email')}" />
                            <g:sortableColumn property="ophalen" title="${message(code: 'klant.ophalen.label', default: 'Ophalen')}" />
                            <g:sortableColumn property="opmerkingen" title="${message(code: 'klant.opmerkingen.label', default: 'Opmerking')}" />
                            <g:sortableColumn property="dateCreated" title="${message(code: 'klant.dateCreated.label', default: 'Toegevoegd')}" />                  
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${klantInstanceList}" status="i" var="klantInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${klantInstance.id}">${fieldValue(bean: klantInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: klantInstance, field: "naam")}</td>                        
                            <td>${fieldValue(bean: klantInstance, field: "adres")}</td>                        
                            <td>${fieldValue(bean: klantInstance, field: "huisnummer")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "postcode")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "woonplaats")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "telefoon")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "telefoon2")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "email")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "ophalen")}</td>
                            <td>${fieldValue(bean: klantInstance, field: "opmerkingen")}</td>
                            <td><g:formatDate date="${klantInsctance?.dateCreated}" format="yyyy-MMM-dd"/></td>                                                    
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${klantInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
