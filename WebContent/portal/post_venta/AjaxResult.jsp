<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
    request.setAttribute("decorator", "none");
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<table class="article">
  	
<tr>
	<th>Id</th>
	<th>Nombre</th>
	<th>Duración</th>
</tr>
<s:actionmessage/>
	<s:iterator value="#session.trabajoPaquetes" >
	
		<tr>
			<td><s:property   value="id"/></td>
			<td><s:property   value="nombre"/></td>
			<td><s:property   value="duracion"/> dias</td>
			<td> <img align="bottom" src="img/delete.png" title="Eliminar" /> </td>
		</tr>
	
</s:iterator>
		
</table>



