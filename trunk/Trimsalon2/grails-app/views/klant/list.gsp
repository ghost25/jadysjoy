<%@ page import="com.dabis.trimsalon.model.Klant" %>
<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'klant.label', default: 'Klant')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
        <g:javascript library="jquery/jquery-1.6.4.min"/>
        <g:javascript library="jquery/jquery-ui-1.8.16.custom.min"/>
        <g:javascript library="jquery/grid.locale-en"/>
        <g:javascript library="jquery/jquery.jqGrid.min"/>
  </head> 
  <body> 
    <div class="nav">
        <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        <span class="menuButton"><g:link class="list" action="mailKlant">Mail</g:link></span>
    </div>
		<div id="top5Panel" class="top5Panel">
		<h2>Laatste klant</h2>
		<div id="klant" class="top5Item">
		<g:render template="/klant/klant5"
		model="[klant: top5Klant]"/>
		</div>
		<h2>Laatste hond</h2>
		<div id="hond" class="top5Item">
		<g:render template="/hond/hond5"
		model="[hond: top5Hond]"/>
		</div>
		<h2>Laatste afspraak</h2>
		<div id="afspraak" class="top5Item">
		<g:render template="/afspraak/afspraak5"
		model="[afspraak: top5Afspraak]"/>
		</div>
		</div>
    <div class="body"> 
     <h1><g:message code="default.list.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}"> 
        <div class="message">${flash.message}</div> 
      </g:if> 
		 <div class="list">
            <!-- table tag will hold our grid -->
            <table id="klant_list" class="scroll jqTable" cellpadding="0" cellspacing="0"></table>
            <!-- pager will hold our paginator -->
            <div id="klant_list_pager" class="scroll" style="text-align:center;"></div>

            <script type="text/javascript">
            var lastSelectedId;
            
            /* when the page has finished loading.. execute the following */
            $(document).ready(function () {

                // set on click events for non toolbar buttons
                $("#btnAdd").click(function(){
                  $("#klant_list").jqGrid("editGridRow","new",
                     {addCaption:'Creeer nieuwe klant',
                     afterSubmit:afterSubmitEvent,
                     savekey:[true,13]});
                });

                $("#btnEdit").click(function(){
                   var gr = $("#klant_list").jqGrid('getGridParam','selrow');
                   if( gr != null )
                     $("#klant_list").jqGrid('editGridRow',gr,
                     {closeAfterEdit:true,
                      afterSubmit:afterSubmitEvent
                     });
                   else
                     alert("Selecteer een regel voorbewerken");
                });

                $("#btnDelete").click(function(){
                  var gr = $("#klant_list").jqGrid('getGridParam','selrow');
                  if( gr != null )
                    $("#klant_list").jqGrid('delGridRow',gr,
                     {afterSubmit:afterSubmitEvent});
                  else
                    alert("Selecteer regel voor verwijderen!");
                });
                

                $("#klant_list").jqGrid({
                  url:'jq_klant_list',
                  editurl:'jq_edit_klant',
                  datatype: "json",
                  colNames:['Naam','Adres','Huisnr','Postcode','Woonplaats','Telefoon','Email','Omerkingen','Id'],
                  colModel:[
                    {name:'naam',
                     editable:true,
                     editrules:{required:true},
                     cellurl:'jq_edit_klant'
                    },
                    {name:'adres',
                        editable:true,
                        editrules:{required:true}
                    },
                    {name:'huisnummer',
                        editable:true,
                        editoptions:{size:4},
                        editrules:{required:true,integer:true}
                     }, 
                     {name:'postcode',
                         editable:true,
                         editrules:{required:true}
                     }, 
                    {name:'woonplaats',
                     editable:true,
                     editrules:{required:true}
                    },
                    {name:'telefoon',
                      editable:true,
                      editoptions:{size:10},
                      editrules:{required:true,integer:true}
                    },
                    {name:'email',                    
                     editable:true,
                     editoptions:{size:30},
                     editrules:{required:true,email:true}
                    },
                    {name:'opmerkingen',
                        editable:true,
                        editrules:{required:true}
                    },
                    {name:'id',hidden:true}
                  ],
                  rowNum:2,
                  rowList:[1,2,3,4,5,6,7,8,9],
                  pager:'#klant_list_pager',
                  viewrecords: true,
                  gridview: true

                }).navGrid('#klant_list_pager',
                    {add:false,edit:true,del:true,search:false,refresh:true},      // which buttons to show?
                    {closeAfterEdit:true,
                     afterSubmit:afterSubmitEvent
                    },                                   // edit options
                    {addCaption:'Creeer nieuwe klant',
                     afterSubmit:afterSubmitEvent,
                     savekey:[true,13]},            // add options
                    {afterSubmit:afterSubmitEvent}  // delete options
                );


                $("#klant_list").jqGrid('filterToolbar',{autosearch:true});
            });

            function afterSubmitEvent(response, postdata) {
                var success = true;
                console.log ('here')
                var json = eval('(' + response.responseText + ')');
                var message = json.message;

                if(json.state == 'FAIL') {
                    success = false;
                } else {
                  $('#message').html(message);
                  $('#message').show().fadeOut(10000);  // 10 second fade
                }

                var new_id = json.id
                return [success,message,new_id];
            }
            </script>
           </div>
      </div>
    </body>
</html>
