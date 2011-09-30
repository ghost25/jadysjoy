<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'poot.gif')}" type="image/x-icon" />
        <g:layoutHead />
        <r:layoutResources/>
        <g:javascript library="application" />
    </head>
    <body>
    <div id="page-wrap">
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="grailsLogo"><a href="http://www.jadysjoy.nl"><img src="${resource(dir:'images',file:'Logo.png')}" alt="Grails" border="0" /></a></div>
        <div id="loginBox" class="loginBox">
			<g:if test="${session?.user}">
				<div style="margin-top:20px">
					<div style="float:right;">
						<g:link controller="user" action="logout">Logout</g:link>
					</div>
				Welkom <span id="userNaam">${session?.user?.naam}!</span>				
				</div>
			</g:if>
			<g:else>
			<div style="margin-top:20px">
					<div style="float:right;">
						<g:link controller="user" action="login">Login</g:link>
					</div>				
				</div>
			</g:else>
			</div>
		<g:render template="/layouts/header" />
		<g:layoutBody />
		<r:layoutResources/>
		<g:render template="/layouts/footer" />
		</div>
    </body>
</html>