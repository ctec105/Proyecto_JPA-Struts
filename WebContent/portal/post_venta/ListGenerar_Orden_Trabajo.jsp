<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css" media="all">
		@import url("css/screen.css");
	</style>
</head>
<body>
	<h1>
		<s:text name="Orden.List.Title" />
	</h1>
	<s:form action="trabajos" theme="simple">
		<a href='<s:url action="trabajo.action" />'>
			<img align="top" src="img/table_add.png" alt="<s:text name="Orden.List.LinkNew"/>">
			<s:text name="Orden.List.LinkNew" />
		</a>
		<br>
		<dt:table name="trabajos" id="bean" class="simple" requestURI="trabajos" pagesize="10"><!-- requestURI="redireccion.do?metodo=trabajo" -->
			<dt:column property="id" title="Id" sortable="true"></dt:column>
			<dt:column property="fecha_inicio" title="Fecha de Inicio" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
			<dt:column property="fecha_termino" title="Fecha de Termino" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
			<dt:column property="comentarios" title="Comentario" sortable="true"></dt:column>
			<dt:column property="solicitud" title="Id Solicitud" sortable="true"></dt:column>
			<dt:column property="idLiquidacion" title="Id Liquidacion" sortable="true"></dt:column>
			<dt:column title="">
				<s:url id="update" action="trabajo">
					<s:param name="trabajo.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{update}">
					<img src="img/table_edit.png" title="Editar" />
				</s:a>
				
				<s:url id="delete" action="eliminarTrabajo"><!-- Falta implementar el action -->
					<s:param name="trabajo.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{delete}">
					<img src="img/delete.png" title="Eliminar" />
				</s:a>
			</dt:column>
		</dt:table>
	</s:form>
</body>
</html>