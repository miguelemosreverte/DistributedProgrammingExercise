package ar.edu.ubp.pdc.servlets;


import javax.servlet.RequestDispatcher;
import ar.edu.ubp.pdc.backend.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Types;
import java.util.LinkedList;
import ar.edu.ubp.pdc.beans.*;


@WebServlet("/index.jsp")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
    public AjaxController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ESTOY EN EL GET");
	
		response.setContentType("text/html;charset=ISO-8859-1");
		String fun  = ("jTicket.add()"); 
	    PrintWriter out = response.getWriter();
	    RecuperadorDeTickets rdt = new RecuperadorDeTickets();
	    LinkedList <TipoTicketBean> TipoTicketBeanList = rdt.getAll();
		request.setAttribute("listadetickets", TipoTicketBeanList);
		request.setAttribute("tag-function", fun);
		this.gotoPage("/main.jsp", request, response);
	  
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ESTOY EN EL POST");
		response.setContentType("text/html;charset=ISO-8859-1");
	    String busqueda = request.getParameter("busqueda");
	    PrintWriter out = response.getWriter();
	           
	    out.println("Tu Busqueda :"+ busqueda);
	           
	            
	          /*String  filtro = String.valueOf(request.getParameter("ordenarpor"));
	          
	          System.out.println(busqueda);
	          System.out.println (filtro);

	        
	        String fun  = ("jTicket.add()"); 

	        BuscadorDeTickets bdt = new BuscadorDeTickets();
	        bdt.setBusqueda(busqueda);
	        bdt.setOrdenarPor(filtro);
	        LinkedList <TipoTicketBean> TipoTicketBeanList = bdt.getAll();
	        request.setAttribute("listadetickets", TipoTicketBeanList);
	        request.setAttribute("tag-function", fun);
	        this.gotoPage("/main.jsp", request, response);
	*/

	}
	
	
	
	
	@SuppressWarnings("unused")
	private void printError(String error, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", error);
		this.gotoPage("/error.jsp", request, response);
	}

	private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(address);
		                  dispatcher.forward(request, response);
	}

}
