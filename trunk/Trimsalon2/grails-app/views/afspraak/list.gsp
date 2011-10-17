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
    </div>
    <div id="top5Panel" class="top5Panel">
		<h2>Laatste klant</h2>
		<div id="klant" class="top5Item">
		<g:render template="/klant/klant5"
		model="[klant: top5Klant]"/>
		</div>
		<h2>Laatste hond</h2>
		<div id="hond" class="top5Item">
		<g:render template="/hond/hond5"
		model="[hond: top5Hond]"/>
		</div>
		<h2>Laatste afspraak</h2>
		<div id="afspraak" class="top5Item">
		<g:render template="/afspraak/afspraak5"
		model="[afspraak: top5Afspraak]"/>
		</div>
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
                            <g:sortableColumn property="omschrijving" title="${message(code: 'afspraak.omschrijving.label', default: 'Omschrijving')}" />                        
                            <g:sortableColumn property="begintijd" title="${message(code: 'afspraak.begindatum.label', default: 'Begindatum')}" />                        
                            <g:sortableColumn property="eindtijd" title="${message(code: 'afspraak.einddatum.label', default: 'Einddatum')}" /> 
                            <g:sortableColumn property="allDay" title="${message(code: 'afspraak.allDay.label', default: 'Hele dag')}" />                          
                            <g:sortableColumn property="producten" title="${message(code: 'afspraak.producten.label', default: 'Product')}" />
                            <g:sortableColumn property="prijs" title="${message(code: 'afspraak.prijs.label', default: 'Prijs')}" />
                            <g:sortableColumn property="hond" title="${message(code: 'afspraak.hond.label', default: 'Hond')}" />
 							<g:sortableColumn property="ophalen" title="${message(code: 'afspraak.ophalen.label', default: 'Ophalen')}" />
                            <g:sortableColumn property="opmerkingen" title="${message(code: 'afspraak.opmerkingen.label', default: 'Opmerking')}" />
                            <g:sortableColumn property="afgehandeld" title="${message(code: 'afspraak.afgehandeld.label', default: 'Afgehandeld')}" />
                            <g:sortableColumn property="user" title="${message(code: 'afspraak.user.label', default: 'Door')}" />               
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${afspraakInstanceList}" status="i" var="afspraakInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${afspraakInstance.id}">${fieldValue(bean: afspraakInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: afspraakInstance, field: "omschrijving")}</td>                        
                            <td>${fieldValue(bean: afspraakInstance, field: "begindatum")}</td>                        
                            <td>${fieldValue(bean: afspraakInstance, field: "einddatum")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "allDay")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "producten")}</td>
                            <td>€<g:formatNumber number="${afspraakInstance?.producten.prijs}" format="##0.00"/></td>
                            <td>${fieldValue(bean: afspraakInstance, field: "hond")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "ophalen")}</td>
                            <td>${fieldValue(bean: afspraakInstance, field: "opmerkingen")}</td>
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
