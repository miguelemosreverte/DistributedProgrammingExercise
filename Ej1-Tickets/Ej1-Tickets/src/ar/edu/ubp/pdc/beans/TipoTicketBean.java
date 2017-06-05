package ar.edu.ubp.pdc.beans;

public class TipoTicketBean {
	
	
	private String ticketNro;
	public String getTicketNro() {
		return ticketNro;
	}
	public void setTicketNro(String ticketNro) {
		this.ticketNro = ticketNro;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getSolicitante() {
		return Solicitante;
	}
	public void setSolicitante(String solicitante) {
		Solicitante = solicitante;
	}
	public String getAsunto() {
		return Asunto;
	}
	public void setAsunto(String asunto) {
		Asunto = asunto;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
	private String fecha;
	private String Solicitante;
	private String Asunto;
	private String Texto;

}
