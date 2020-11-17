<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<s:head theme="xhtml" />
	<sx:head parseContent="true" />
	<title>Insert title here</title>
	<style type="text/css" media="all">
		@import url("css/screen.css");
	</style>
	<script type="text/javascript">
		window.name = 'principal';
	
		function f_abrirPop(msg) {
			var action = msg + '.action';
			hija = window.open(action, msg, "scrollbars=NO,location=0 ,width= 500, height=400");
			hija.focus();
			//document.forms[0].target = 'ventana';
		}
	</script>
</head>
<body>
	<h1>Registro de Orden de Liquidación</h1>
	<s:url var="ajaxOrdenes" value="/ObtenerDivOrdenes.action" />
	<s:form theme="simple">
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
		<table>
			<s:if test="liquidacion.id!=0">
				<tr>
					<td>Codigo:</td>
					<td><s:textfield name="liquidacion.id" /></td>
				</tr>
			</s:if>
			<tr>
				<td>Usuario:</td>
				<td><s:textfield name="liquidacion.usuario" requiredposition="left" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><s:textfield name="liquidacion.nombre" size="50" /></td>
			</tr>
			<tr>
				<td>Fecha:</td>
				<td><sx:datetimepicker name="liquidacion.fecha" type="date" displayFormat="dd/MM/yyy" /></td>
			</tr>
			<tr>
				<td>Cliente RUC:</td>
				<td>
					<s:textfield id="clienteBusc" name="liquidacion.cliente.id" />
					<input type="button" value="..." onclick="f_abrirPop('popBuscarCliente');">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<sx:submit type="submit" value="Obtener Ordenes de Trabajo" targets="divOrd" href="%{ajaxOrdenes}" align="left" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="divOrd"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<dt:table name="ordenes" id="bean" class="simple" requestURI="" pagesize="40" decorator="org.displaytag.decorator.TotalTableDecorator">
						<dt:column property="id" title="Idd" sortable="true"></dt:column>
						<dt:column property="fecha_inicio" title="Fecha de Inicio" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
						<dt:column property="fecha_termino" title="Fecha de Termino" sortable="true" decorator="proyecto.struts.util.DateColumnDecorator"></dt:column>
						<dt:column property="comentarios" title="Comentario" sortable="true"></dt:column>
						<dt:column property="solicitud" title="Id Solicitud" sortable="true"></dt:column>
					</dt:table>
				</td>
			</tr>
			<tr>
				<td><s:submit action="InsertaLiquidacion" value=":: grabar ::" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>