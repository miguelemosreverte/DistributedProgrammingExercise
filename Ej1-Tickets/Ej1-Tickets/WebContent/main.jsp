<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList,ar.edu.ubp.pdc.beans.TipoTicketBean" %>
<%@taglib uri="/WEB-INF/tld/mycustoms" prefix="ct" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title></title>
   	<link type="text/css" rel="stylesheet" href="./css/style.css" />
   	<script type="text/javascript" src="./js/jquery.js"></script>
   	<script type="text/javascript" src="./js/utils.js"></script>
   	<script type="text/javascript" src="./js/TicketeraJs.js"></script>
</head>
<body>
	<div id="idcustomTag"> 
	<% String str_fun =(String)request.getAttribute("tag-function"); %>
	 
	<h3><ct:Ticket funcion="<%= str_fun %>"/></h3>
	
	</div>
	<div id="response"></div>
	
	
	
	
	<div id="main">
	<h3>Tipos de Documentos</h3>
	<table>
		<tr>
			<th>Ticket Nro</th>
			<th>Fecha</th>
			<th>Solicitante</th>
			<th>Asunto</th>
			<th>Texto</th>
			
		</tr>	
		<%
		LinkedList<TipoTicketBean> ListaTickets = (LinkedList<TipoTicketBean>)request.getAttribute("listadetickets");
		for(TipoTicketBean ttb : ListaTickets) {
		%>
		<tr>
			<td><%= ttb.getTicketNro() %></td>
			<td><%= ttb.getFecha() %></td>
			<td><%= ttb.getSolicitante() %></td>
			<td><%= ttb.getAsunto() %></td>
			<td><%= ttb.getTexto() %></td>
		</tr>
		<%	
		}
		%>	
	</table>
	</div>
</body>
</html>