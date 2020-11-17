<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax"%>
<html>
<head>
<title>Insert title here</title>
	<style type="text/css" media="all">
		@import url("css/screen.css");
	</style>
	<%-- <script type="text/javascript">
		function f_eliminar(id) {
			if (confirm("¿Desea Eliminar el Cliente Nro. " + id + "?")) {
				//alert('si');
				document.forms[0].action = 'eliminarCliente.action?cliente.id=' + id;
				document.forms[0].submit();
			}
		}
	</script> --%>
</head>
<body>
	<h1><s:text name="lcliente.titulo"/></h1>
	<s:form action="clientes" theme="simple">
		<a href='<s:url action="cliente.action" />'>
			<img align="top" src="img/table_add.png" alt="Imagen no disponible">
			<s:text name="lcliente.registrar_nuevo_cliente"/>
		</a>
		<br>
		<!-- Para la internacionalización de las columnas del DisplayTag -->
		<c:set var="codigo_cliente"><s:text name="lcliente.codigo_cliente"/></c:set>
		<c:set var="razon_social"><s:text name="lcliente.razon_social"/></c:set>
		<c:set var="direccion"><s:text name="lcliente.direccion"/></c:set>
		<c:set var="telefono"><s:text name="lcliente.telefono"/></c:set>
		<c:set var="editar"><s:text name="lcliente.editar"/></c:set>
		<c:set var="eliminar"><s:text name="lcliente.eliminar"/></c:set>
		
		<dt:table name="clientes" id="bean" class="simple" requestURI="clientes" pagesize="10">
			<dt:column property="id" title="${codigo_cliente}" sortable="true"></dt:column>
			<dt:column property="razonSoc" title="${razon_social}" sortable="true"></dt:column>
			<dt:column property="direccion" title="${direccion}" sortable="true"></dt:column>
			<dt:column property="telefono" title="${telefono}" sortable="true"></dt:column>
			<dt:column title="">
				<s:url id="update" action="cliente">
					<s:param name="cliente.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{update}">
					<img src="img/table_edit.png" title="${editar}" />
				</s:a>
				
				<s:url id="delete" action="eliminarCliente">
					<s:param name="cliente.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{delete}">
					<img src="img/delete.png" title="${eliminar}" />
				</s:a>
				
				<!-- Con JavaScript -->
				<%-- <input type="button" value="Eliminar" onclick="f_eliminar('<s:property value="#attr.bean.id"/>');" > --%>
			</dt:column>
		</dt:table>
	</s:form>
</body>
</html>