 <html>
 <head>
   <meta name="layout" content="main"></meta>
   <r:require module="full-calendar"/>
 </head>
 <body>
   <fullcal:calendar id="cal">
     header: { left: "", center: "", right: "prev, today, next" },
     columnFormat: { week: 'ddd d/M' },
     timeFormat: 'HH:mm{ - HH:mm}'
   </fullcal:calendar>
 </body>
 </html>