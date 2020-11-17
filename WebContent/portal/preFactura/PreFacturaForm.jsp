<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="dt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="xhtml" />
<sx:head parseContent="true" />
<script type="text/javascript">
	window.name = 'principal';

	function f_abrirPop(msg) {
		var action = msg + '.action';
		hija = window.open(action, msg, "scrollbars=NO,location=0 ,width= 500, height=400");
		hija.focus();
		//document.forms[0].target = 'ventana';
	}
</script>
<title>Insert title here</title>
<style type="text/css" media="all">
@import url("css/screen.css");
</style>
</head>
<body>
	<h1>Generacion de Pre-Factura</h1>
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
			<s:if test="prefactura.id!=0">
				<tr>
					<th>Codigo:</th>
					<td><s:textfield name="prefactura.id" readonly="true" disabled="true" /></td>
				</tr>
			</s:if>
			<tr>
				<th>Usuario:</th>
				<td><s:textfield name="prefactura.usuario" readonly="true" requiredposition="left" /></td>
			</tr>
			<tr>
				<th>Fecha:</th>
				<td><sx:datetimepicker name="prefactura.fecha" type="date" displayFormat="dd/MM/yyy" /></td>
			</tr>
			<tr>
				<th>Orden de Liquidacion:</th>
				<td>
					<s:textfield id="buscOrden" name="prefactura.liquidacion.id" requiredposition="left" />
					<input type="button" value="..." onclick="f_abrirPop('popBuscarLiquidacion');">
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:submit action="CargaDatosLiq" value="Cargar Datos de la Orden de Liquidacion" /></td>
			</tr>
			<s:if test="prefactura.liquidacion.id!=0">
				<tr>
					<th>RUC:</th>
					<td><s:textfield name="prefactura.ruc" readonly="true" requiredposition="left" /></td>
				</tr>
				<tr>
					<th>Razon Social:</th>
					<td><s:textfield name="prefactura.cliente" readonly="true" requiredposition="left" /></td>
				</tr>
				<tr>
					<th>Dirección:</th>
					<td><s:textfield name="prefactura.direccion" readonly="true" requiredposition="left" /></td>
				</tr>
				<tr>
					<td colspan="4">
						<dt:table name="detalles" id="bean" class="simple" requestURI="CargaDatosLiq" pagesize="50">
							<dt:column property="id" title="Id Ord. Liq." sortable="true"></dt:column>
							<dt:column property="item" title="Id. Paq/Tec." sortable="true"></dt:column>
							<dt:column property="descripcion" title="Nom, Pa/Nom. Tec." sortable="true"></dt:column>
							<dt:column property="precio_unitario" title="Precio Uni." sortable="true"></dt:column>
							<dt:column property="cantidad" title="Cantidad/Horas" sortable="true"></dt:column>
							<dt:column property="subtotal" title="Subtotal" sortable="true"></dt:column>
						</dt:table>
					</td>
				</tr>
				<tr>
					<td align="center"><s:submit action="grabarPrefactura" value="Registrar Pre-Factura" align="center" /></td>
				</tr>
			</s:if>
		</table>
	</s:form>
</body>
</html>