<%@ taglib prefix="s" uri="/struts-tags"%>
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
			if (confirm("Desea Eliminar la Solicitud Nro. " + id + "?")) {
				//alert('si');
				document.forms[0].action = 'eliminarSolicitud';
				document.forms[0].submit();
			}
		}
	</script> --%>
</head>
<body>
	<h1>
		<s:text name="Solicitud.List.Title" />
	</h1>
	<s:form action="solicitudes" theme="simple">
		<a href='<s:url action="solicitud.action" />'>
			<img align="top" src="img/table_add.png" alt="<s:text name="Solicitud.List.LinkNew" />">
			<s:text name="Solicitud.List.LinkNew" />
		</a>
		<br>
		<dt:table name="solicitudes" id="bean" class="simple" requestURI="solicitudes" pagesize="10">
			<dt:column property="id" title="Id" sortable="true"></dt:column>
			<dt:column property="equipo.nrotarjeta" title="Nro. Tarjeta" sortable="true"></dt:column>
			<dt:column property="fecha" title="Fecha" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
			<dt:column property="representante" title="Representante" sortable="true"></dt:column>
			<dt:column property="estado.descripcion" title="Estado" sortable="true"></dt:column>
			<dt:column property="desc" title="Descripción" sortable="true"></dt:column>
			<dt:column title="">
				<s:url id="update" action="solicitud">
					<s:param name="solicitud.id" value="#attr.bean.id" />
				</s:url>
				<s:a href="%{update}">
					<img src="img/table_edit.png" title="Editar" />
				</s:a>
				
				<s:if test="#attr.bean.estado.idestado == 1 ">
					<s:url id="delete" action="eliminarSolicitud">
						<s:param name="solicitud.id" value="#attr.bean.id" />
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