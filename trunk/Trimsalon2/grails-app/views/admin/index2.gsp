<html>
    <head>
        <title>Welkom bij D-BIS</title>
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
					 <g:link controller="hond" action="list">
					Honden
					</g:link></p>
					 <g:link controller="afspraak" action="list">
					Afspraken
					</g:link></p>
                     <g:link controller="factuur" action="list">
					Facturen
					</g:link></p>
					<g:link controller="behandeling" action="list">
					Behandelingen
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
        <div id="pageBody">
            <h1>Welkom bij D-BIS</h1>
            <p>Dit is een registratiesysteem voor een Hondentrimsalon. Hierbinnen kunt u zowel klanten als honden en afspraken registreren.</p>

        </div>
    </body>
</html>
