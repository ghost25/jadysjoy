<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->


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

  <h1>Agenda</h1>
  <button class="ui-button ui-button-text-only ui-widget ui-state-default ui-corner-all" id="edit"><span class="ui-button-text"><g:message code="default.button.edit.label" default="Edit"/></span></button>
	<fullcal:calendar id="afspraak">
	  theme: true,
	  header: {left: 'prev,next today',center: 'title', right: 'month,agendaWeek,agendaDay'},
	  columnFormat: { week: 'ddd d/M' },
	  timeFormat: 'HH:mm{ - HH:mm}',
	  selectable: true,
	  selectHelper: true,
	  select: function(start, end, allDay) {javascript:window.location="${createLink(controller:'afspraak',action:'create', params:['calendar.id':calendarInstance?.id])}&allDay="+allDay+"&begindatum_year="+start.getFullYear()+"&begindatum_month="+(start.getMonth()+1)+"&begindatum_day="+start.getDate()+"&begindatum_hour="+start.getHours()+"&begindatum_minute="+start.getMinutes()+"&einddatum_year="+end.getFullYear()+"&einddatum_month="+(end.getMonth()+1)+"&einddatum_day="+end.getDate()+"&einddatum_hour="+end.getHours()+"&einddatum_minute="+end.getMinutes()},
	  editable: true,	
	  events:${include(controller:"calendar", action:"json", id:calendarInstance?.id)}
	</fullcal:calendar>
</body>
</html>