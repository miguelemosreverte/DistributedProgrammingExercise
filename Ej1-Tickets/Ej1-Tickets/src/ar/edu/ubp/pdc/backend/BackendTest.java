package ar.edu.ubp.pdc.backend;
import java.util.LinkedList;

import ar.edu.ubp.pdc.beans.*;

public class BackendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RecuperadorDeTickets rec = new RecuperadorDeTickets ();
		LinkedList <TipoTicketBean> myresult = rec.getAll();
		if (myresult == null)
			System.out.println("error!!");
	
		for(TipoTicketBean ttb : myresult) {

			System.out.println(ttb.getTicketNro());
			System.out.println(ttb.getFecha() );
			System.out.println(ttb.getSolicitante());
			System.out.println(ttb.getAsunto());
			System.out.println(ttb.getTexto() );
	
		}
		
		
		
		BuscadorDeTickets bus = new BuscadorDeTickets ();
		bus.setBusqueda("SOLICITANTE 2");
		bus.setOrdenarPor("T");
		LinkedList <TipoTicketBean> myresult2 = bus.getAll();
		if (myresult2 == null)
			System.out.println("Algun error en la conexion");
	
		for(TipoTicketBean ttb : myresult2) {

			System.out.println(ttb.getTicketNro());
			System.out.println(ttb.getFecha() );
			System.out.println(ttb.getSolicitante());
			System.out.println(ttb.getAsunto());
			System.out.println(ttb.getTexto() );
	
		}
		return;
	}

}
