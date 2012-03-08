<%@ page import="com.dabis.trimsalon.model.User" %>
<html> 
  <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

  </head> 
  <body> 
    <div class="nav">
        <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
        <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
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
            <table id="user_list" class="scroll jqTable" cellpadding="0" cellspacing="0"></table>
            <!-- pager will hold our paginator -->
            <div id="user_list_pager" class="scroll" style="text-align:center;"></div>

            <script type="text/javascript">
            var lastSelectedId;
            
            /* when the page has finished loading.. execute the following */
            $(document).ready(function () {

                // set on click events for non toolbar buttons
                $("#btnAdd").click(function(){
                  $("#user_list").jqGrid("editGridRow","new",
                     {addCaption:'Creeer nieuwe user',
                     afterSubmit:afterSubmitEvent,
                     savekey:[true,13]});
                });

                $("#btnEdit").click(function(){
                   var gr = $("#user_list").jqGrid('getGridParam','selrow');
                   if( gr != null )
                     $("#user_list").jqGrid('editGridRow',gr,
                     {closeAfterEdit:true,
                      afterSubmit:afterSubmitEvent
                     });
                   else
                     alert("Selecteer een regel voorbewerken");
                });

                $("#btnDelete").click(function(){
                  var gr = $("#user_list").jqGrid('getGridParam','selrow');
                  if( gr != null )
                    $("#user_list").jqGrid('delGridRow',gr,
                     {afterSubmit:afterSubmitEvent});
                  else
                    alert("Selecteer regel voor verwijderen!");
                });
                

                $("#user_list").jqGrid({
                  url:'jq_user_list',
                  editurl:'jq_edit_user',
                  datatype: "json",
                  colNames:['Loginnaam','Wachtwoord','Naam','Rol','Id'],
                  colModel:[
                    {name:'login',
                     editable:true,
                     editrules:{required:true},
                     cellurl:'jq_edit_user',
                     width: 150
                    },
                    {name:'password',
                        editable:true,
                        editrules:{required:true},
                        width: 150
                    },
                    {name:'naam',
                        editable:true,
                        editrules:{required:true},
                        width: 300
                     }, 
                     {name:'role',
                         editable:true,
                         editrules:{required:true},
                         width: 150
                     }, 
                    {name:'id',hidden:true}
                  ],
                  rowNum:2,
                  rowList:[1,2,3,4],
                  pager:'#user_list_pager',
                  viewrecords: true,
                  gridview: true

                }).navGrid('#user_list_pager',
                    {add:true,edit:true,del:true,search:false,refresh:true},      // which buttons to show?
                    {closeAfterEdit:true,
                     afterSubmit:afterSubmitEvent
                    },                                   // edit options
                    {addCaption:'Creeer nieuwe user',
                     afterSubmit:afterSubmitEvent,
                     savekey:[true,13]},            // add options
                    {afterSubmit:afterSubmitEvent}  // delete options
                );


                $("#user_list").jqGrid('filterToolbar',{autosearch:true});
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
