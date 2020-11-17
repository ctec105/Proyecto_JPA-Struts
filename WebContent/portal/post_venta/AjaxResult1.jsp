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
	<th>Especialidad</th>
</tr>
<s:actionmessage/>
<s:iterator value="#session.trabajoTecnicos" >
		<tr>
			<td><s:property   value="id"/></td>
			<td><s:property   value="nombre"/> <s:property   value="ape_pat"/></td>
			<td><s:property   value="idEspecialidad"/> </td>
			<td> <img align="bottom" src="img/delete.png" title="Eliminar" /> </td>
		</tr>
	
</s:iterator>
		
</table>



