<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'afspraak.label', default: 'afspraak')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${afspraakInstance}">
            <div class="errors">
                <g:renderErrors bean="${afspraakInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="omschrijving"><g:message code="afspraak.omschrijving.label" default="Omschrijving" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'omschrijving', 'errors')}">
                                    <g:textField name="omschrijving" value="${afspraakInstance?.omschrijving}" />
                                </td>
                            </tr>                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="begintijd"><g:message code="afspraak.begintijd.label" default="Begintijd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'begintijd', 'errors')}">
                                <g:datePicker name="begindatum" value="${afspraakInstance?.begindatum}" ></g:datePicker>
                                </td>
                            </tr>
  							<tr class="prop">
                                <td valign="top" class="name">
                                    <label for="eindtijd"><g:message code="afspraak.eindtijd.label" default="Eindtijd" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'eindtijd', 'errors')}">
                                <g:datePicker name="einddatum" value="${afspraakInstance?.einddatum}" ></g:datePicker>
                                </td>                           
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="allday"><g:message code="afspraak.alldaylabel" default="Hele dag" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'allDay', 'errors')}">
                                <g:checkBox name="allDay" value="${afspraakInstance?.allDay}" />
                                </td>                           
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="producten"><g:message code="afspraak.producten.label" default="Behandeling" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'producten', 'errors')}">                                                                    
                                  <g:select name="producten" from="${product}" value="${afspraakInstance?.producten}" valueMessagePrefix="afspraak.producten" noSelection="${['null':'Select One...']}" />
                                </td>
                             </tr> 
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hond"><g:message code="afspraak.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'hond', 'errors')}">
			 					 <g:select name="hond" from="${honden}" value="${afspraakInstance?.hond}" valueMessagePrefix="afspraak.hond" noSelection="${['null':'Select One...']}" />
 							</td>
                             </tr>                           
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opmerkingen"><g:message code="afspraak.opmerkingen.label" default="Opmerking" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'opmerkingen', 'errors')}">
                                    <g:textField name="opmerkingen" value="${afspraakInstance?.opmerkingen}" />
                                </td>
                             </tr>
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ophalen"><g:message code="afspraak.ophalen.label" default="Ophalen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'ophalen', 'errors')}">
                                    <g:select name="ophalen" from="${afspraakInstance.constraints.ophalen.inList}" value="${afspraakInstance?.ophalen}" valueMessagePrefix="afspraak.ophalen" noSelection="${['null':'Select One...']}" />
                                </td>
                             </tr>
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="afgehandeld"><g:message code="afspraak.afgehandeld.label" default="Afgehandeld" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'afgehandeld', 'errors')}">                                    
                                    <g:checkBox name="afgehandeld" value="${afspraakInstance?.afgehandeld}" />
                                </td>
                             </tr> 
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="afspraak.user.label" default="Door" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'user', 'errors')}">
			 					 <g:select name="user" from="${users}" value="${afspraakInstance?.user}" valueMessagePrefix="afspraak.user" noSelection="${['null':'Select One...']}" />
                                </td>
                             </tr>
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="calendar"><g:message code="afspraak.user.label" default="Kalendar" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'calendar', 'errors')}">
			 					 <g:select name="calender" from="${kalender}" value="${afspraakInstance?.calendar}" valueMessagePrefix="afspraak.calendar" noSelection="${['null':'Select One...']}" />
                                </td>
                             </tr>        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
