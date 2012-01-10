/**
 * Spinner activation
 */
var Ajax;
if (Ajax && (Ajax != null)) {
	Ajax.Responders.register({
	  onCreate: function() {
        if($('spinner') && Ajax.activeRequestCount>0)
          Effect.Appear('spinner',{duration:0.5,queue:'end'});
	  },
	  onComplete: function() {
        if($('spinner') && Ajax.activeRequestCount==0)
          Effect.Fade('spinner',{duration:0.5,queue:'end'});
	  }
	});
}

/**
 * JQuery Datepicker
 */
$(function() {
	$(".jqdatepicker" ).datepicker({ dateFormat: 'dd-mm-yy' });
});

/**
 * Hover state for static <g:link>
*/
$(function() {
	$(".glink").hover(
			function() { $(this).addClass("ui-state-hover"); }, 
			function() { $(this).removeClass("ui-state-hover"); }
	);
});

$(function() {
	$( "input:submit, a, button", ".mainnav" ).button();
	$( "input:submit, a, button", ".buttons" ).button();
});
