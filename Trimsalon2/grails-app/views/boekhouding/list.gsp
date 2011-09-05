<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'boekhouding.label', default: 'boekhouding')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title> 
  </head> 
  <body> 
    <div class="nav">
        <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        <span class="menuButton"><g:link action="logout">Logout</g:link></span>	  
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'boekhouding.id.label', default: 'Id')}" />
                            <g:sortableColumn property="factuurnr" title="${message(code: 'boekhouding.factuurnr.label', default: 'Factuurnummer')}" />                        
                            <g:sortableColumn property="boekingsdatum" title="${message(code: 'boekhouding.boekingsdatum.label', default: 'Boekingsdatum')}" />                        
                            <g:sortableColumn property="factuurdatum" title="${message(code: 'boekhouding.factuurdatum.label', default: 'Factuurdatum')}" />                            
                            <g:sortableColumn property="prijsExbtw" title="${message(code: 'boekhouding.prijsExbtw.label', default: 'Prijs exbtw')}" />
                            <g:sortableColumn property="btw" title="${message(code: 'boekhouding.btw.label', default: 'Btw')}" />
                            <g:sortableColumn property="betaald" title="${message(code: 'boekhouding.betaald.label', default: 'Betaald')}" />               
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${boekhoudingInstanceList}" status="i" var="boekhoudingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${boekhoudingInstance.id}">${fieldValue(bean: boekhoudingInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: boekhoudingInstance, field: "factuurnr")}</td>                        
                            <td><g:formatDate date="${boekhoudingInstance?.boekingsdatum}" format="dd-MMM-yyyy"/></td>                        
                            <td><g:formatDate date="${boekhoudingInstance?.factuurdatum}" format="dd-MMM-yyyy"/></td>
                            <td>€<g:formatNumber number="${boekhoudingInstance?.prijsExbtw}" format="##0.00"/></td>
                            <td>${fieldValue(bean: boekhoudingInstance, field: "btw")}%</td>
                            <td>${fieldValue(bean: boekhoudingInstance, field: "betaald")}</td>                                                 
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${boekhoudingInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
