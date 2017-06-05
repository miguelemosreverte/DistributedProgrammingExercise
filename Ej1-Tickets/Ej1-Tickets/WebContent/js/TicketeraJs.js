$(document).ready(function() {

   
    
    
    
    
});


var jTicket = {        
        add: function() {
            var busqueda = $('#idSAT').val();
            var filtro = $('input[name=ordenarpor]:checked', '#idformulario').val()
            $.ajax({
                type :"POST",
                data :{busqueda:busqueda},
                url : './index.jsp',
                success : function(result){ $('#main').html(result); }
            });
            
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