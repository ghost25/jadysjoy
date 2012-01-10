<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'poot.gif')}" type="image/x-icon" />
        <link rel="stylesheet" href="${resource(dir: 'css/custom', file: 'jquery-ui-1.8.16.custom.css')}"/>
        <link rel="stylesheet" href="${resource(dir:'css',file:'ui.jqgrid.css')}" />
		<g:layoutHead />
		<g:javascript src="jquery/jquery-1.6.4.min.js" />
		<g:javascript src="jquery/jquery-ui-1.8.16.custom.min.js" />
		<g:javascript src="d-trim.js" />
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