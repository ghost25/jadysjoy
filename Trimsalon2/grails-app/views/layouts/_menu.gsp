<div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
                    <h1>Menu</h1>
                    <div id="controllerList" class="dialog">
                	<ul>
                	<g:if test="${!session.user}">			
					<g:link controller="klant" action="list">
					Toon klanten
					</g:link></p>
					<g:link controller="hond" action="list">
					Toon honden
					</g:link></p>
					<g:link controller="producten" action="list">
					Toon Producten
					</g:link></p>
					</g:if>
					<g:else>
					<g:link controller="calendar" action="show" id="1">
					Kalender
					</g:link></p>
                    <g:link controller="klant" action="list">
					Toon klanten
					</g:link></p>
					<g:link controller="klant" action="create">
					Nieuwe klant
					</g:link></p>
					<g:link controller="hond" action="list">
					Toon honden
					</g:link></p>
					<g:link controller="hond" action="create">
					Nieuwe hond
					</g:link></p>
					<g:link controller="afspraak" action="list">
					Toon afspraken
					</g:link></p>
					<g:link controller="afspraak" action="create">
					Nieuwe afspraak
					</g:link></p>
					<g:link controller="producten" action="list">
					Toon producten
					</g:link></p>
					<g:link controller="producten" action="create">
					Nieuwe product
					</g:link></p>
					<g:link controller="inkomsten" action="list">
					Toon inkomsten
					</g:link></p>
					<g:link controller="uitgaven" action="list">
					Toon uitgaven
					</g:link></p>
					<g:if test="${session.user.role == 'admin'}">
					<g:link controller="user" action="list">
					Toon gebruikers
					</g:link></p>
					<g:link controller="user" action="create">
					Nieuwe gebruiker
					</g:link></p>
					<g:link controller="calendar" action="create">
					Nieuwe kalender
					</g:link></p>
					</g:if>
					</g:else>
                </ul>
            </div>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>