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
	<h1>Pre Facturas</h1>
	<s:form action="trabajos" theme="simple">
		<a href='<s:url action="AddorUpdatePreFactura.action" />'>
			<img align="top" src="img/table_add.png" alt="Generar Prefactura">
			Generar Prefactura
		</a>
		<br>
		<dt:table name="prefacturas" id="bean" class="simple" requestURI="prefacturas" pagesize="10"><!-- redireccion.do?metodo=trabajo -->
			<dt:column property="id" title="Codigo" sortable="true"></dt:column>
			<dt:column property="fecha" title="Fecha" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
			<dt:column property="ruc" title="RUC" sortable="true"></dt:column>
			<dt:column property="cliente" title="Razon Social" sortable="true"></dt:column>
			<dt:column property="liquidacion.id" title="Id Orden Liq." sortable="true"></dt:column>
			<dt:column title="">
				<s:url id="update" action="AddorUpdatePreFactura">
					<s:param name="trabajo.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{update}">
					<img src="img/table_edit.png" title="Editar" />
				</s:a>

				<%-- <s:url id="delete" action="eliminarSolicitud">
					<s:param name="trabajo.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{delete}">
					<img src="img/delete.png" title="Eliminar" />
				</s:a> --%>
			</dt:column>
		</dt:table>
	</s:form>
</body>
</html>