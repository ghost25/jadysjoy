<div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
                    <h1>Menu</h1>
                    <div id="controllerList" class="dialog">
                	<ul>
                	<g:if test="${!session.user}">
					<g:link controller="user" action="login">
					Login
					</g:link></p>
					<g:link controller="afspraak" action="list">
					Toon afspraken
					</g:link></p>
					<g:link controller="klant" action="list">
					Toon klanten
					</g:link></p>
					<g:link controller="hond" action="list">
					Toon honden
					</g:link></p>
					</g:if>
					<g:else>
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
					Nieuwe Afspraak
					</g:link></p>
					<g:link controller="producten" action="list">
					Toon producten
					</g:link></p>
					<g:link controller="boekhouding" action="list">
					Toon boekhouding
					</g:link></p>
					<g:if test="${session.user.role == 'admin'}">
					<g:link controller="user" action="list">
					Toon gebruikers
					</g:link></p>
					<g:link controller="user" action="create">
					Nieuwe gebruiker
					</g:link></p>
					</g:if>
					</g:else>
                </ul>
            </div>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>