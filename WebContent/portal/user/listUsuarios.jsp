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
			if (confirm("¿Desea Eliminar el Usuario Nro. " + id + "?")) {
				//alert('si');
				document.forms[0].action = 'eliminarUsuario';
				document.forms[0].submit();
			}
		}
	</script> --%>
</head>
<body>
	<h1><s:text name="lusuario.titulo"/></h1>
	<s:form action="usuarios" theme="simple">
		<table>
			<tr>
				<td>
					<font color="red">
						<s:fielderror />
						<s:actionerror />
						<s:actionmessage />
					</font>
				</td>
			</tr>
		</table>
		<a href='<s:url action="usuario.action" />'>
			<img align="top" src="img/table_add.png" alt="Registrar Nuevo Usuario"/>
			<s:text name="lusuario.registrar_nuevo_usuario"/>
		</a>
		<br>
		<!-- Para la internacionalización de las columnas del DisplayTag -->
		<c:set var="id"><s:text name="lusuario.id"/></c:set>
		<c:set var="usuario"><s:text name="lusuario.usuario"/></c:set>
		<c:set var="nombre"><s:text name="lusuario.nombre"/></c:set>
		<c:set var="ape_paterno"><s:text name="lusuario.ape_paterno"/></c:set>
		<c:set var="ape_materno"><s:text name="lusuario.ape_materno"/></c:set>
		<c:set var="editar"><s:text name="lusuario.editar"/></c:set>
		<c:set var="eliminar"><s:text name="lusuario.eliminar"/></c:set>
		<c:set var="bloquear"><s:text name="lusuario.bloquear"/></c:set>
		<c:set var="desbloquear"><s:text name="lusuario.desbloquear"/></c:set>
		
		<dt:table id="bean" name="usuarios" class="simple" requestURI="usuarios" pagesize="10">
			<dt:column property="codUsuario" title="${id}" sortable="true"></dt:column>
			<dt:column property="login" title="${usuario}" sortable="true"></dt:column>
			<dt:column property="nombre" title="${nombre}" sortable="true"></dt:column>
			<dt:column property="ape_pat" title="${ape_paterno}" sortable="true"></dt:column>
			<dt:column property="ape_mat" title="${ape_materno}" sortable="true"></dt:column>
			<dt:column title="">
				<s:url id="update" action="usuario">
					<s:param name="usuario.codUsuario" value="#attr.bean.codUsuario" />
				</s:url>
				<s:a href="%{update}">
					<img src="img/table_edit.png" title="${editar}" />
				</s:a>

				<s:url id="delete" action="eliminarUsuario">
					<s:param name="usuario.codUsuario" value="#attr.bean.codUsuario" />
				</s:url>
				<s:a href="%{delete}">
					<img src="img/delete.png" title="${eliminar}" />
				</s:a>

				<s:if test="#attr.bean.estado == 0">
					<s:url id="bloquear" action="bloquearUsuario">
						<s:param name="usuario.codUsuario" value="#attr.bean.codUsuario" />
					</s:url>
					<s:a href="%{bloquear}">
						<img src="img/status_online.png" title="${bloquear}" />
					</s:a>
				</s:if>
				<s:if test="#attr.bean.estado == 1">
					<s:url id="desBloquear" action="desBloquearUsuario">
						<s:param name="usuario.codUsuario" value="#attr.bean.codUsuario" />
					</s:url>
					<s:a href="%{desBloquear}">
						<img src="img/status_offline.png" title="${desbloquear}" />
					</s:a>
				</s:if>
			</dt:column>
		</dt:table>
	</s:form>
</body>
</html>