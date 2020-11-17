<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"
	prefix="ajax"%>
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
	<h1>Ordenes de Liquidacion</h1>
	<s:form theme="simple">
		<a href='<s:url action="AddorUpdateLiquidacion.action" />'>
			<img align="top" src="img/table_add.png" alt="Registrar Nueva Orden de Liquidación">
			Registrar nueva Orden de Liquidación
		</a>
		<br>
		<dt:table name="liquidaciones" id="bean" class="simple" requestURI="liquidaciones" pagesize="10">
			<dt:column property="id" title="Id" sortable="true"></dt:column>
			<dt:column property="fecha" title="Fecha" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
			<dt:column property="cliente.id" title="RUC" sortable="true"></dt:column>
			<dt:column property="usuario" title="Usuario" sortable="true"></dt:column>
			<dt:column title="">
				<%-- <s:url id="update" action="AddorUpdateLiquidacion.action">
					<s:param name="paquete.id" value="#attr.bean.id"/>
			    </s:url>
			    <s:a href="%{update}"><img src="img/table_edit.png" title="Editar"  /></s:a> --%>
		   
				<s:if test="#attr.bean.estado==0">
					<s:url id="delete" action="eliminarLiquidacion"><!-- Falta implementar el método eliminar liquidación -->
						<s:param name="paquete.id" value="#attr.bean.id" />
					</s:url>
					<s:a href="%{delete}">
						<img src="img/delete.png" title="Eliminar" />
					</s:a>
				</s:if>
			</dt:column>
		</dt:table>
	</s:form>
</body>
</html>