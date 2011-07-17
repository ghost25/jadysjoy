<html>
    <head>
        <title>Welkom bij D-Trim</title>
        <meta name="layout" content="main" />
        <style type="text/css" media="screen">

        #nav {
            margin-top:20px;
            margin-left:30px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            margin-top:15px;
            margin-bottom:15px;
            font-size:1.2em;
        }
        #pageBody {
            margin-left:280px;
            margin-right:20px;
        }
        </style>
    </head>
    <body>
        <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
                    <h1>Menu</h1>
                    <div id="controllerList" class="dialog">
                <ul>
                     <g:link controller="klant" action="list">
					Klanten
					</g:link></p>
					 <g:link controller="klant" action="create">
					Nieuwe klant
					</g:link></p>
					<g:link controller="hond" action="list">
					Honden
					</g:link></p>
					 <g:link controller="hond" action="create">
					Nieuwe hond
					</g:link></p>
					 <g:link controller="afspraak" action="list">
					Afspraken
					</g:link></p>
					<g:link controller="afspraak" action="create">
					Nieuwe Afspraak
					</g:link></p>
					<g:link controller="producten" action="list">
					Producten
					</g:link></p>
                    <g:link controller="user" action="create">
					Nieuwe gebruiker
					</g:link>
                </ul>
            </div>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/home.gsp')}">Home</a></span>
        </div>
        <div id="pageBody">
            <h1>Welkom bij D-Trim</h1>
            <p>Met dit programma snel en eenvoudig behandelingen invoeren
             en uw inkomsten per behandeling vastleggen.<br> 
            Zoeken naar een klant of hond is nog nooit zo makkelijk geweest en uw boekhouding
            blijft altijd op orde.</p><br> 
            <br>           		
			<div class="list">
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