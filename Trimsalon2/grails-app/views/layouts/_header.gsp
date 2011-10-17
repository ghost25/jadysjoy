    <div id="page-wrap">
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="header">
        <g:render template="/layouts/search" />
        <div id="grailsLogo"><a href="http://www.jadysjoy.nl"><img src="${resource(dir:'images',file:'Logo.png')}" alt="Grails" border="0" /></a></div>
        <div id="loginBox" class="loginBox">
			<g:if test="${session?.user}">
				<div>				
				Welkom <span id="userNaam">${session?.user?.naam} </span>
				<g:link controller="user" action="logout">Logout</g:link>				
				</div>
			</g:if>
			<g:else>
			<div >				
				<g:link controller="user" action="login">Login</g:link>			
			</div>
			</g:else>
			</div>
			</div>