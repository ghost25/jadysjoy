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
		$("#edit").click(function() { window.location="${createLink(controller:'afspraak',action:'edit', id:afspraakInstance?.id)}"; });
	});
	</script>

  <h1>Agenda</h1><button class="ui-button ui-button-text-only ui-widget ui-state-default ui-corner-all" id="edit"><span class="ui-button-text"><g:message code="default.button.edit.label" default="Edit"/></span></button>
	<fullcal:calendar id="afspraak">
	  theme: true,
	  header: {left: 'prev,next today',center: 'title', right: 'month,ageinddatumaWeek,ageinddatumaDay', },
	  columnFormat: { week: 'ddd d/M' },
	  timeFormat: 'HH:mm{ - HH:mm}',
	  selectable: true,
	  selectHelper: true,
	  select: function(begindatum, einddatum, allDay) {javascript:window.location="${createLink(controller:'event',action:'create', params:['afspraak.id':afspraakInstance?.id])}&allDay="+allDay+"&begindatum_year="+begindatum.getFullYear()+"&begindatum_month="+(begindatum.getMonth()+1)+"&begindatum_day="+begindatum.getDate()+"&begindatum_hour="+begindatum.getHours()+"&begindatum_minute="+begindatum.getMinutes()+"&begindatum_year="+einddatum.getFullYear()+"&einddatum_month="+(einddatum.getMonth()+1)+"&einddatum_day="+einddatum.getDate()+"&einddatum_hour="+einddatum.getHours()+"&einddatum_minute="+einddatum.getMinutes()},
	  editable: true,	
	  events:${include(controller:"afspraak", action:"json", id:afspraakInstance?.id)}
	</fullcal:calendar>
</body>
</html>