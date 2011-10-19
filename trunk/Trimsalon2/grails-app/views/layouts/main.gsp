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
    	<div>
    	<g:render template="/layouts/header" />
		<g:render template="/layouts/menu" />
		<g:layoutBody />
		<r:layoutResources/>
		<g:render template="/layouts/footer" />
		</div>
    </body>
</html>