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
	<script type="text/javascript" src="js/livevalidation.js">
		
	</script>
	<script type="text/javascript">
		window.name = 'ventana';
		/* function buscar() {
			document.forms[0].action = 'equipos.do';
			document.forms[0].metodo.value = 'buscarEquipo';
			document.forms[0].submit();
		} */
		function enviaDatos() {
			try {
				var i;
				if (document.forms[0].cod.length == undefined) {
					opener.document.forms[0].buscTarjeta.value = document.forms[0].cod.value;
				} else {
					for (i = 0; i < document.forms[0].cod.length; i++) {
						if (document.forms[0].cod[i].checked)
							break;
					}
					opener.document.forms[0].buscTarjeta.value = document.forms[0].cod[i].value;
				}
				window.close();
			} catch (e) {
				alert(e.value);
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
								<td>Nro. Tarjeta</td>
								<td><s:textfield id="nroTarjeta" name="equipo.nrotarjeta" maxlength="11" /></td>
							</tr>
							<tr>
								<td>Clase de Equipo</td>
								<td>
									<s:select name="equipo.claseEquipo"
										list="#session.clasesEquipos" listKey="id" listValue="desc" />
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<s:submit action="popBuscarEquipos" value="Buscar" />
								</td>
							</tr>
						</table>
						<dt:table name="equipos" id="bean" class="simple" pagesize="5" requestURI="popBuscarEquipos"><!-- requestURI=equipos.do?metodo=buscarEquipo -->
							<dt:column sortable="true" property="nrotarjeta" title="Nro. Tarjeta"></dt:column>
							<dt:column sortable="true" property="nroserie" title="Nro. Serie"></dt:column>
							<dt:column sortable="true" property="claseEquipo" title="Clase"></dt:column>
							<dt:column sortable="true" property="cliente" title="Modelo"></dt:column>
							<dt:column sortable="true" property="modelo" title="Cliente"></dt:column>
							<dt:column title="Elejir">
								<input type="radio" name="cod" value="<s:property value="#attr.bean.nrotarjeta"/>">
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