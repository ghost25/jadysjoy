<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'afspraak.label', default: 'afspraak')}" />
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
                            <g:sortableColumn property="id" title="${message(code: 'afspraak.id.label', default: 'Id')}" />
                            <g:sortableColumn property="datum" title="${message(code: 'afspraak.datum.label', default: 'Datum')}" />                        
                            <g:sortableColumn property="begintijd" title="${message(code: 'afspraak.begintijd.label', default: 'Begintijd')}" />                        
                            <g:sortableColumn property="eindtijd" title="${message(code: 'afspraak.eindtijd.label', default: 'Eindtijd')}" />                            
                            <g:sortableColumn property="producten" title="${message(code: 'afspraak.producten.label', default: 'Behandeling')}" />
                            <g:sortableColumn property="hond" title="${message(code: 'afspraak.hond.label', default: 'Hond')}" />
                            <g:sortableColumn property="klant" title="${message(code: 'afspraak.klant.label', default: 'Klant')}" />
                            <g:sortableColumn property="opmerkingen" title="${message(code: 'afspraak.opmerkingen.label', default: 'Opmerking')}" />
                            <g:sortableColumn property="ophalen" title="${message(code: 'afspraak.ophalen.label', default: 'Ophalen')}" />
                            <g:sortableColumn property="afgehandeld" title="${message(code: 'afspraak.afgehandeld.label', default: 'Afgehandeld')}" />
                            <g:sortableColumn property="user" title="${message(code: 'afspraak.user.label', default: 'Door')}" />               
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${afspraakInstanceList}" status="i" var="afspraakInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${afspraakInstance.id}">${fieldValue(bean: afspraakInstance, field: "id")}</g:link></td>                        
                            <td><g:formatDate date="${afspraakInstance?.datum}" format="dd-MMM-yyyy"/></td>                        
                            <td>${fieldValue(bean: afspraakInstance, field: "begintijd")}</td>                        
                            <td>${fieldValue(bean: afspraakInstance, field: "eindtijd")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "producten")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "hond")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "klant")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "opmerkingen")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "ophalen")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "afgehandeld")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "user")}</td>                                                   
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${afspraakInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
