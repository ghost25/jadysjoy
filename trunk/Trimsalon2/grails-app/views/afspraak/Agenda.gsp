<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->


<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agenda</title>
  <fullcal:resources/>
</head>
<body>
  <script>
	$(function() {
		$("#edit").click(function() { window.location="${createLink(controller:'afspraak',action:'edit', id:afspraakInstance?.id)}"; });
	});
	</script>

  <h1>${afspraakInstance?.hond} </h1><button class="ui-button ui-button-text-only ui-widget ui-state-default ui-corner-all" id="edit"><span class="ui-button-text"><g:message code="default.button.edit.label" default="Edit"/></span></button>
	<fullcal:calendar id="cal">
	  theme: true,
	  header: {
	  left: 'prev,next today',
	  center: 'title',
	  right: 'month,agendaWeek,agendaDay',
	  },
	  columnFormat: { week: 'ddd d/M' },
	  timeFormat: 'HH:mm{ - HH:mm}',
	  selectable: true,
	  selectHelper: true,
	  select: function(start, end, allDay) {
	  javascript:window.location="${createLink(controller:'event',action:'create', params:['afspraak.id':afspraakInstance?.id])}&allDay="+allDay+"&startDate_year="+start.getFullYear()+"&startDate_month="+(start.getMonth()+1)+"&startDate_day="+start.getDate()+"&startDate_hour="+start.getHours()+"&startDate_minute="+start.getMinutes()+"&endDate_year="+end.getFullYear()+"&endDate_month="+(end.getMonth()+1)+"&endDate_day="+end.getDate()+"&endDate_hour="+end.getHours()+"&endDate_minute="+end.getMinutes()
	  },
	  editable: true,
	
	  events:${include(controller:"afspraak", action:"json", id:afspraakInstance?.id)}
	</fullcal:calendar>
</body>
</html>