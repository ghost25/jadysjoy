<html>
    <head>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'ui.jqgrid.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/ui-lightness',file:'jquery-ui-1.7.2.custom.css')}" />
        <g:javascript library="/jquery/jquery-1.3.2.min"/>
        <g:javascript library="/jquery/jquery-ui-1.7.2.custom.min"/>
        <g:javascript library="/jquery/grid.locale-en"/>
        <g:javascript library="/jquery/jquery.jqGrid.min"/>
    </head>
    <body>
       <div class="body">
            <h1>Customer List</h1>

            <!-- table tag will hold our grid -->
            <table id="customer_list" class="scroll jqTable" cellpadding="0" cellspacing="0"></table>
            <!-- pager will hold our paginator -->
            <div id="customer_list_pager" class="scroll" style="text-align:center;"></div>

            <script type="text/javascript">
            /* when the page has finished loading.. execute the follow */
            $(document).ready(function () {
                jQuery("#customer_list").jqGrid({
                  url:'jq_customer_list',
                  datatype: "json",
                  colNames:['Id','Naam','Adres','Huisnummer','Postcode','Woonplaats','Telefoon','Email','Opmerkingen','Hond','Toegevoegd'],
                  colModel:[
                    {name:'id'},
                    {name:'naam'},
                    {name:'adres'},
                    {name:'huisnummer'},
                    {name:'postcode'},
                    {name:'woonplaats'},
                    {name:'telefoon'},
                    {name:'email'},
                    {name:'opmerkingen'},
                    {name:'hond'},
                    {name:'dateCreated'},
                    
                  ],
                  pager: jQuery('#klant_list_pager'),
                  viewrecords: true,
                  gridview: true
                });
            });
            </script>
      </div>
    </body>
</html>
