<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'opmerking.label', default: 'opmerking')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'opmerking.id.label', default: 'Id')}" />
                            <g:sortableColumn property="hond" title="${message(code: 'opmerking.hond.label', default: 'Hond')}" />                        
                            <g:sortableColumn property="advies" title="${message(code: 'opmerking.advies.label', default: 'Advies')}" />                        
                            <g:sortableColumn property="gedrag" title="${message(code: 'opmerking.gedrag.label', default: 'Gedrag')}" />                            
                            <g:sortableColumn property="medischeKenmerken" title="${message(code: 'opmerking.medischeKenmerken.label', default: 'Medische kenmerken')}" />
                            <g:sortableColumn property="dateCreated" title="${message(code: 'opmerking.dateCreated.label', default: 'Toegevoegd op')}" />             
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${opmerkingInstanceList}" status="i" var="opmerkingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${opmerkingInstance.id}">${fieldValue(bean: opmerkingInstance, field: "id")}</g:link></td>                        
                            <td>${fieldValue(bean: opmerkingInstance, field: "hond")}</td>                        
                            <td>${fieldValue(bean: opmerkingInstance, field: "advies")}</td>                        
                            <td>${fieldValue(bean: opmerkingInstance, field: "gedrag")}</td>
                            <td>${fieldValue(bean: opmerkingInstance, field: "medischeKenmerken")}</td>
                            <td><g:formatDate date="${opmerkingInsctance?.dateCreated}" format="yyyy-MMM-dd"/></td>                                                                      
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${opmerkingInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
