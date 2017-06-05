

$(document).ready(function() {


	
});


		

var jTicket = {		
		add: function() {

			if($.trim($("input[name=SAT]").val()) == "") {
	    		$("input[name=SAT]").focus();

	    	}
			else {
	    
	        jUtils.executing("main");
	        $.ajax({
	            url: "./index.jsp",
	            type: "post",
	            dataType: "html",
	            data: $.param($("input[type=text,name=SAT],input[name=ordenarpor ,type=radio]:checked", $("#idformulario"))),
	            error: function(hr){
	                jUtils.hiding("main");
	                jUtils.showing("message", hr.responseText);
	            },
	            success: function(html) {
	                jUtils.showing("main", html);
	            }
	        });		
		}
		},
		};


var jUtils = {

	    executing: function(divId) {
	        $('#' + divId).html("<p>Procesando...</p>").show();
	    },

	    showing: function(divId, html) {
	        $('#' + divId).html(html !== null ? html : '').show();
	    },

	    hiding: function(divId, clean) {
	        clean = (clean === false ? false : true);
	        $('#' + divId).hide();
	        if(clean) {
	            $('#' + divId).html('&nbsp;');
	        }
	    }

	};




	    



















