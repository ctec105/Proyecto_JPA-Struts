<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<sx:head parseContent="true" />
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
					opener.document.forms[0].buscPaq.value = document.forms[0].cod.value;
				} else {
					for (i = 0; i < document.forms[0].cod.length; i++) {
						if (document.forms[0].cod[i].checked)
							break;
					}
					opener.document.forms[0].buscPaq.value = document.forms[0].cod[i].value;
				}
				window.close();
			} catch (e) {
				alert("elejir un Paquete");
			}
		}
	</script>
	<script>
		function show_details() {
			dojo.event.topic.publish("show_detail");
		}
	</script>
</head>
<body>
	<s:url var="ajaxModelo" value="/ObtenerModelos.action" />

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
					<s:form theme="simple" id="busPaq" name="busPaq">
						<table>
							<tr>
								<td>Nombre Paquete</td>
								<td><s:textfield name="paquete.nombre" /></td>
							</tr>
							<tr>
								<td>Marca</td>
								<td>
									<s:select name="paquete.marca" list="#session.marcas"
										listKey="id" listValue="descripcion"
										onchange="javascript:show_details();return false;" />
								</td>
							</tr>
							<tr>
								<td>Modelo</td>
								<td>
									<sx:div id="details" href="%{ajaxModelo}"
										listenTopics="show_detail" formId="busPaq" autoStart="false"
										preload="false" showLoadingText="">
										<s:select name="paquete.modelo" list="#session.paqueteModelo"
											listKey="id" listValue="descripcion" />
									</sx:div>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<s:submit action="popBuscarPaquete" value="Buscar" />
								</td>
							</tr>
						</table>
						<dt:table name="paquetes" id="bean" class="simple" pagesize="5" requestURI="popBuscarPaquete">
							<dt:column property="id" title="Id" sortable="true"></dt:column>
							<dt:column property="nombre" title="Nombre" sortable="true"></dt:column>
							<dt:column property="duracion" title="Duracion" format="{0} dias" sortable="true"></dt:column>
							<dt:column property="precio" title="precio" format="$ {0,number, 000.00} "></dt:column>
							<dt:column title="Elejir">
								<input type="radio" name="cod" value="<s:property value="#attr.bean.id"/>">
							</dt:column>
						</dt:table>
						<table>
							<tr>
								<td colspan="2" align="center"><input type="button" value="Agregar" onClick="enviaDatos();" /></td>
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