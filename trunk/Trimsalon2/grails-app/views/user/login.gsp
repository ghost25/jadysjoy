<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Login</title>
    </head>
    <body>
         <div class="nav">
 	        <span class="menuButton"><a class="home" href="${createLink(uri: '/home.gsp')}">Home</a></span>	    
        </div>
        <div class="body">
             <h1>Welkom bij D-Trim</h1>
            <p>Met dit programma snel en eenvoudig behandelingen invoeren
             en uw inkomsten per behandeling vastleggen.<br> 
            Zoeken naar een klant of hond is nog nooit zo makkelijk geweest en uw boekhouding
            blijft altijd op orde.</p><br> 
            <br>
            <h1>Login</h1>  
            <g:if test="${flash.message}">
              <div class="message">${flash.message}</div>
            </g:if>
            <g:form action="authenticate" method="post" >
                <div class="dialog">
                    <table style="width:270px">
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="login"><g:message code="user.login.label" default="Login:" /></label>
                                </td>
                                <td valign="top">
                                    <input type="text" id="login" name="login" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="user.password.label" default="Wachtwoord:" /></label>
                                </td>
                                <td valign="top" >
                                    <input type="password" id="password" name="password" />
                                    
                                </td>
                            </tr>
                        

                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons" style="width:270px">
                    <span class="button"><input type="submit" value="Login" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
