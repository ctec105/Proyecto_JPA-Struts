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
	<h1>Mantenimiento de Paquetes</h1>
	<s:form theme="simple">
		<a href='<s:url action="paquete.action" />'> <img
			align="top" src="img/table_add.png" alt="Registrar Nueva Solicitud">
			Registrar nuevo Paquete
		</a>
		<br>
		<dt:table name="paquetes" id="bean" class="simple" requestURI="paquetes" pagesize="10">
			<dt:column property="id" title="Id" sortable="true"></dt:column>
			<dt:column property="nombre" title="Nombre" sortable="true"></dt:column>
			<dt:column property="duracion" title="Duracion" format="{0} dias" sortable="true"> dias</dt:column>
			<dt:column property="precio" title="precio" format="$ {0,number, 000.00} "></dt:column>
			<dt:column title="">
				<s:url id="update" action="paquete">
					<s:param name="paquete.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{update}">
					<img src="img/table_edit.png" title="Editar" />
				</s:a>
				
				<s:url id="delete" action="eliminarPaquete">
					<s:param name="paquete.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{delete}">
					<img src="img/delete.png" title="Eliminar" />
				</s:a>
			</dt:column>
		</dt:table>
	</s:form>
</body>
</html>