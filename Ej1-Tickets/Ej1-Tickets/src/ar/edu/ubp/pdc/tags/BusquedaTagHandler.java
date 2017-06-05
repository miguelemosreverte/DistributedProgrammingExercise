package ar.edu.ubp.pdc.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BusquedaTagHandler extends SimpleTagSupport {
    
    private String funcion;

    public BusquedaTagHandler() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        
        String var_function = (this.funcion == null ? "" : this.funcion);

        JspWriter out = this.getJspContext().getOut();
        
            
              out.println("<form  id =\"idformulario\" name =\"formulario\" action=\"javascript:void(null) \" >"
               +"Solicitante | Asunto | Texto<br>"
               +"<input type=\"text\"   id = \"idSAT\" name=\"SAT\">"
               +"<div>"
               +"<input type=\"radio\" name=\"ordenarpor\" value=\"S\" > Solicitante"
               +"<input type=\"radio\" name=\"ordenarpor\" value=\"F\" checked> Fecha"
               +"<input type=\"radio\" name=\"ordenarpor\" value=\"T\"> Nro. de Ticket<br>"
               +"<input type=\"submit\" id =\"bttsubmit\" name=\"botonbuscar\" value=\"Buscar\" "
               + "onclick =\" "+var_function+"\" >"
             +"<div>"
               +"</form> ");
    }
    
    public void setFuncion (String funcion) {
        this.funcion= funcion;
    }    
    

}