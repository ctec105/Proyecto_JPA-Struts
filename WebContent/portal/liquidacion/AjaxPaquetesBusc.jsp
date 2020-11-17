<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>
<%
	request.setAttribute("decorator", "none");
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<h2>Ordenes de Trabajo Pendientes</h2>
<dt:table name="ordenesxCli" id="bean" class="simple" requestURI="" pagesize="40">
	<dt:column property="id" title="Id" sortable="true"></dt:column>
	<dt:column property="fecha_inicio" title="Fecha de Inicio" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
	<dt:column property="fecha_termino" title="Fecha de Termino" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
	<dt:column property="comentarios" title="Comentario" sortable="true"></dt:column>
	<dt:column property="solicitud" title="Id Solicitud" sortable="true"></dt:column>
	<dt:column title="Selecionar">
		<input align="middle" type="checkbox" name="agregar" value="<s:property value="#attr.bean.id"/>">
	</dt:column>
</dt:table>
<s:submit action="agregarOrdenes" value="Agregar Ordenes Seleccionadass" align="left" />



