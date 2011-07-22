<html>
    <head>
        <title>Welkom bij D-Trim</title>
        <meta name="layout" content="main" />
         <g:set var="entityName" value="${message(code: 'afspraak.label', default: 'Afspraak')}"/>
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style type="text/css" media="screen">
        </style>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        </div>
        <div id="pageBody">
            <h1>Welkom bij D-Trim</h1>
            <p>Met dit programma snel en eenvoudig behandelingen invoeren
             en uw inkomsten per behandeling vastleggen.<br> 
            Zoeken naar een klant of hond is nog nooit zo makkelijk geweest en uw boekhouding
            blijft altijd op orde.</p><br> 
            <br>
			<div class="dialog">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="datum" title="${message(code: 'afspraak.datum.label', default: 'Datum')}" />
                        
                            <g:sortableColumn property="hond" title="${message(code: 'afspraak.hond.label', default: 'Hond')}" />
                        
                            <g:sortableColumn property="klant" title="${message(code: 'afspraak.klant.label', default: 'Klant')}" />
                        
                            <g:sortableColumn property="ophalen" title="${message(code: 'afspraak.ophalen.label', default: 'Ophalen')}" />
                            
                            <g:sortableColumn property="afgehandeld" title="${message(code: 'afspraak.afgehandeld.label', default: 'Afgehandeld')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${afspraakInstanceList}" status="i" var="afspraakInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${afspraakInstance.id}">${fieldValue(bean: afspraakInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: afspraakInstance, field: "datum")}</td>
                        
                            <td>${fieldValue(bean: afspraakInstance, field: "hond")}</td>
                        
                            <td>${fieldValue(bean: afspraakInstance, field: "klant")}</td>
                            
                            <td>${fieldValue(bean: afspraakInstance, field: "ophalen")}</td>
                            
                            <td>${fieldValue(bean: afspraakInstance, field: "afgehandeld")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
