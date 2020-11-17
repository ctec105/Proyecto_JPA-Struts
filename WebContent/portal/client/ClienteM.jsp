<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<s:head theme="xhtml" />
	<sx:head parseContent="true" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/datetimepicker.js">
		
	</script>
	<script type="text/javascript" src="js/livevalidation.js">
		
	</script>
	<%-- <script type="text/javascript">
		window.name = 'principal';
	
		function f_registrar() {
			//document.forms[0].action='solicitud.do';
			document.forms[0].metodo.value = 'registrar';
			document.forms[0].submit();
		}
		function mostrarFecha() {
			var obDat = new Date();
			var dia = obDat.getDate();
			var mes = obDat.getMonth() + 1;
			var anho = obDat.getFullYear();
			if (dia < 10)
				dia = "0" + dia;
			if (mes < 10)
				mes = "0" + mes;
			document.forms[0].txtFecha.value = dia + "/" + mes + "/" + anho;
		}
	</script> --%>
</head>
<body>
	<h1><s:text name="mcliente.titulo"/></h1>
	<s:form theme="simple">
		<table align="center">
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
		<table width="50%">
			<s:if test="cliente.id!='0'">
				<td align="left"><s:text name="mcliente.codigo_cliente"/></td>
				<td colspan="3" align="left">
					<s:if test="cliente.id!=0">
						<s:hidden name="cliente.id"></s:hidden>
						<s:textfield id="txtIdCliente" name="cliente.id" disabled="true"></s:textfield>
					</s:if>
					<s:else>
						<s:textfield id="txtIdCliente" name="cliente.id"></s:textfield>
						<script type="text/javascript">
							var representante = new LiveValidation('txtIdCliente');
							representante.add(Validate.Presence);
					</script>
					</s:else>
				</td>
			</s:if>
			<tr>
				<td align="left"><s:text name="mcliente.razon_social"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtRazonSocial" name="cliente.razonSoc"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtRazonSocial');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="mcliente.direccion"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtDireccion" name="cliente.direccion"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtDireccion');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="mcliente.telefono"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtTelefono" name="cliente.telefono"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtTelefono');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<%-- <tr>
				<td align="left"><s:text name="mcliente.fecha"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtFecha"></s:textfield>
					<a href="#" onclick="mostrarFecha();"><s:text name="mcliente.mostrar_fecha"/></a>
				</td>
			</tr> --%>
			<tr>
				<td colspan="4" align="left">
					<s:submit id="btnGrabar" key="mcliente.grabar" action="insertaCliente"  />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>