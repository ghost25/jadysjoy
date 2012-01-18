<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'poot.gif')}" type="image/x-icon" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'ui.jqgrid.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'ui.jqgrid.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/ui-lightness',file:'jquery-ui-1.8.16.custom.css')}" />
        <g:javascript library="jquery/jquery-1.6.4.min"/>
        <g:javascript library="jquery/jquery-ui-1.8.16.custom.min"/>
        <g:javascript library="jquery/grid.locale-en"/>
        <g:javascript library="jquery/jquery.jqGrid.min"/>
		<g:layoutHead />
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