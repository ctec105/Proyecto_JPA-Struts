<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<style type="text/css" media="all">
		@import url("css/screen.css");
	</style>
	<script type="text/javascript" src="js/script.js">
		
	</script>
	<script type="text/javascript">
		window.name = 'ventana';
		function enviaDatos() {
			try {
				var i;
				if (document.forms[0].cod.length == undefined) {
					opener.document.forms[0].buscSolic.value = document.forms[0].cod.value;
				} else {
					for (i = 0; i < document.forms[0].cod.length; i++) {
						if (document.forms[0].cod[i].checked)
							break;
					}
					opener.document.forms[0].buscSolic.value = document.forms[0].cod[i].value;
				}
				window.close();
			} catch (e) {
				alert("Debe selecionar una solicitud");
			}
		}
	</script>
</head>
<body>
	<div class="content">
		<div class="Post">
			<div class="Post-tl"></div>
			<div class="Post-tr">
				<div></div>
			</div>
			<div class="Post-bl">
				<div></div>
			</div>
			<div class="Post-br">
				<div></div>
			</div>
			<div class="Post-tc">
				<div></div>
			</div>
			<div class="Post-bc">
				<div></div>
			</div>
			<div class="Post-cl">
				<div></div>
			</div>
			<div class="Post-cr">
				<div></div>
			</div>
			<div class="Post-cc"></div>
			<div class="Post-body">
				<div class="Post-inner" style="height: 330px">
					<s:form theme="simple">
						<input type="hidden" name="metodo">
						<table>
							<tr>
								<td>Nombre Representante:</td>
								<td><s:textfield name="solicitud.representante" /></td>
							</tr>
							<tr>
								<td>Estado:</td>
								<td>
									<s:select name="solicitud.estado.idestado"
										list="#session.estados" listKey="idestado"
										listValue="descripcion" />
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<s:submit action="popBuscarSolicitud" value="Buscar" />
								</td>
							</tr>
						</table>
						<dt:table name="solicitudes" id="bean" class="simple" pagesize="5" requestURI="popBuscarSolicitud.action">
							<dt:column property="id" title="Id" sortable="true"></dt:column>
							<dt:column property="equipo.nrotarjeta" title="Nro. Tarjeta" sortable="true"></dt:column>
							<dt:column property="fecha" title="Fecha" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
							<dt:column property="representante" title="Representante" sortable="true"></dt:column>
							<dt:column property="estado.descripcion" title="Estado" sortable="true"></dt:column>
							<dt:column property="desc" title="Descripción" sortable="true"></dt:column>
							<dt:column title="Elejir">
								<input type="radio" name="cod" value="<s:property value="#attr.bean.id"/>">
							</dt:column>
						</dt:table>
						<table>
							<tr>
								<td colspan="2" align="center">
									<input type="button" value="Agregar" onClick="enviaDatos();" />
								</td>
							</tr>
						</table>
					</s:form>
					<div class="cleared"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>