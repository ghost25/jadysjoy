<html>
  <head>
    <meta name="layout" content="main"></meta>
    <title>Agenda</title>
    <r:require module="full-calendar"/>
</head>
<body>
  <script>
	$(function() {
		$("#edit").click(function() { window.location="${createLink(controller:'calendar',action:'edit', id:calendarInstance?.id)}"; });
	});
	</script>
  <div id='createAfspraak'>
  	<h1>Maak afspraak</h1>
	            <g:hasErrors bean="${afspraakInstance}">
            <div class="errors">
                <g:renderErrors bean="${afspraakInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="saveAfspraak" controller="afspraak">
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
                                    <label for="begindatum"><g:message code="afspraak.begindatum.label" default="Begindatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'begindatum', 'errors')}">
                                    <g:datePicker name="begindatum" value="${afspraakInstance?.begindatum}" ></g:datePicker>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="einddatum"><g:message code="afspraak.einddatum.label" default="Einddatum" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'einddatum', 'errors')}">
                                    <g:datePicker name="einddatum" value="${afspraakInstance?.einddatum}" ></g:datePicker>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="allDay"><g:message code="afspraak.allDay.label" default="All Day" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'allDay', 'errors')}">
                                    <g:checkBox name="allDay" value="${afspraakInstance?.allDay}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="producten"><g:message code="afspraak.producten.label" default="Producten" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'producten', 'errors')}">
                                    <g:select name="producten.id" from="${com.dabis.trimsalon.model.Producten.list()}" optionKey="id" value="${afspraakInstance?.producten?.id}"  noSelection="${['null':'Selecteer...']}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hond"><g:message code="afspraak.hond.label" default="Hond" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'hond', 'errors')}">
                                    <g:select name="hond.id" from="${com.dabis.trimsalon.model.Hond.list()}" optionKey="id" value="${afspraakInstance?.hond?.id}"  noSelection="${['null':'Selecteer...']}" />
                                </td>
                            </tr>
                           
                             <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ophalen"><g:message code="afspraak.ophalen.label" default="Ophalen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'ophalen', 'errors')}">
                                    <g:select name="ophalen" from="${com.dabis.trimsalon.model.Afspraak.constraints.ophalen.inList}" value="${afspraakInstance?.ophalen}" valueMessagePrefix="afspraak.ophalen"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="opmerkingen"><g:message code="afspraak.opmerkingen.label" default="Opmerkingen" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'opmerkingen', 'errors')}">
                                    <g:textField name="opmerkingen" value="${afspraakInstance?.opmerkingen}" />
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
                                    <label for="user"><g:message code="afspraak.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.dabis.trimsalon.model.User.list()}" optionKey="id" value="${afspraakInstance?.user?.id}"  noSelection="${['null':'Selecteer...']}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="calendar"><g:message code="afspraak.calendar.label" default="Calendar" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: afspraakInstance, field: 'calendar', 'errors')}">
                                    <g:select name="calendar.id" from="${com.dabis.trimsalon.model.Calendar.list()}" optionKey="id" value="${afspraakInstance?.calendar?.id}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="saveAfspraak" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
                </g:form>
	</div>
  <div id='calendar'>
  <h1>Agenda</h1>
  <g:if test="${session.user.role == 'admin'}">
  <button class="ui-button ui-button-text-only ui-widget ui-state-default ui-corner-all" id="edit"><span class="ui-button-text"><g:message code="default.button.edit.label" default="Edit"/></span></button>
	</g:if>
	<fullcal:calendar id="afspraak">
	  theme: true,
	  header: {left: 'prev,next today',center: 'title', right: 'month,agendaWeek,agendaDay'},
	  columnFormat: { week: 'ddd d/M' },
	  timeFormat: 'HH:mm{ - HH:mm}',
	  selectable: true,
	  selectHelper: true,
	  select: function(start, end, allDay) {javascript:window.location="${createLink(controller:'afspraak',action:'create', params:['calendar.id':calendarInstance?.id])}&allDay="+allDay+"&begindatum_year="+start.getFullYear()+"&begindatum_month="+(start.getMonth()+1)+"&begindatum_day="+start.getDate()+"&begindatum_hour="+start.getHours()+"&begindatum_minute="+start.getMinutes()+"&einddatum_year="+end.getFullYear()+"&einddatum_month="+(end.getMonth()+1)+"&einddatum_day="+end.getDate()+"&einddatum_hour="+end.getHours()+"&einddatum_minute="+end.getMinutes()},
	  editable: true,
	  eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
		       jQuery.ajax({type:'POST',data:{'dayDelta': dayDelta,'minuteDelta': minuteDelta}, url:'${createLink(controller:'afspraak', action:'updateEndDate')}'+'/'+event.afspraakid,success:function(data,textStatus){},error:function(XMLHttpRequest,textStatus,errorThrown){revertFunc()}});
		  },
		  eventDrop: function(event,dayDelta,minuteDelta,allDay,revertFunc) {
		   jQuery.ajax({type:'POST',data:{'allDay': allDay, 'dayDelta': dayDelta,'minuteDelta': minuteDelta}, url:'${createLink(controller:'afspraak', action:'updateMoveDate')}'+'/'+event.afspraakid,success:function(data,textStatus){},error:function(XMLHttpRequest,textStatus,errorThrown){revertFunc()}});
		  },
		  loading: function(bool) {
		if (bool) $('#loading').show();
		else {
		$('#loading').hide();
		$('#cal').fullCalendar( 'rerenderEvents' );
		}
		  },	
	  events:${include(controller:"calendar", action:"json", id:calendarInstance?.id)}
	</fullcal:calendar>
	</div>	
</body>
</html>