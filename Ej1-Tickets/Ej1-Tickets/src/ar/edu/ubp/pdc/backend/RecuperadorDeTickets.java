package ar.edu.ubp.pdc.backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;


import ar.edu.ubp.pdc.beans.TipoTicketBean;

public final class RecuperadorDeTickets {
	
	
	
	public LinkedList<TipoTicketBean> getAll(){
		  try {
	        	Connection conn;
	            PreparedStatement st;
	            ResultSet result;
	            
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            conn = DriverManager.getConnection("jdbc:sqlserver://localhost", "sa", "1234");            
	            conn.setAutoCommit(true);
	        	System.out.println("PrimerTry del recuperador de tickets");
	        	try {
	        		LinkedList<TipoTicketBean> TipoTicketBeanList = new LinkedList<TipoTicketBean>();
		        	TipoTicketBean ttb;
		 
		  
		        	st = conn.prepareStatement("select ticket        = convert(varchar(4), t.anio_ticket) + '-' + replicate('0', 5 - len(convert(varchar(5), t.nro_ticket))) + convert(varchar(5), t.nro_ticket), "
		        		      + "fecha_ticket  = convert(varchar(10), t.fecha_ticket, 103) + ' ' + convert(varchar(5), t.fecha_ticket, 108), " 
		        			  +" solicitante   = s.nom_solicitante, "
		        			  + "asunto_ticket = t.asunto_ticket, "
		        			  + "texto_ticket  = t.texto_ticket "
		        		  +" from pdc2.dbo.tickets t (nolock) "
		        		  +" join pdc2.dbo.solicitantes s (nolock) "
		        		  +"	     on t.nro_solicitante = s.nro_solicitante "
		        		  +" where (t.asunto_ticket   like '%' + isnull(ltrim(rtrim(?)), '') + '%' "
		        		  +" or  t.texto_ticket    like '%' + isnull(ltrim(rtrim(?)), '') + '%' "
		        		  +" or  s.nom_solicitante like '%' + isnull(ltrim(rtrim(?)), '') + '%') "
		        		  +" order by case 'F' "
		        		               +" when 'F' "
		        					   +" then convert(varchar(10), t.fecha_ticket, 112) + ' ' + convert(varchar(5), t.fecha_ticket, 108) "
		        					   +" when 'S' "
		        					   +" then s.nom_solicitante "
		        					   +" when 'T' " +
		        					   " then convert(varchar(4), t.anio_ticket) + '-' + replicate('0', 5 - len(convert(varchar(5), t.nro_ticket))) + convert(varchar(5), t.nro_ticket) end;",  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		    
		            st.setNull(1, Types.VARCHAR);
				    st.setNull(2, Types.VARCHAR);
				    st.setNull(3, Types.VARCHAR);
				    //st.setString(4, "F");
				    
				  
		
		            result = st.executeQuery();
		        	
		            while(result.next()) {
		            	System.out.println("data");
		            	ttb = new TipoTicketBean();
						ttb.setTicketNro(result.getString("ticket"));
						ttb.setFecha(result.getString("fecha_ticket"));
						ttb.setSolicitante(result.getString("solicitante"));
						ttb.setAsunto(result.getString("asunto_ticket"));
					    ttb.setTexto(result.getString("texto_ticket"));
					    TipoTicketBeanList.add(ttb);
		            }
		            st.close();
		            return TipoTicketBeanList;
		            

	        	}
	    		catch(SQLException ex) {
	    			System.out.println(ex.getMessage().toString());
	    		}
	    		finally {
	    			conn.close();
	    		}
	        }
	        
	        catch(InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
	      
	        	
	        	System.out.println(ex.getMessage().toString());
	        	
	        
	        }
		return null;	
}
}



