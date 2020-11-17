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
	<script type="text/javascript">
		window.name = 'principal';
	
		function f_buscarEquipo(msg) {
			hija = window.open("popBuscarEquipos.action", msg, "scrollbars=NO, width= 500, height=400");
			hija.focus();
			//document.forms[0].target = 'ventana';
		}
		function f_obtener() {
			//document.forms[0].action='solicitud.do';
			//mostrarFecha();
			document.forms[0].action = 'obtenerEquipo';
			document.forms[0].submit();
		}
		/* function f_registrar() {
			//document.forms[0].action='solicitud.do';
			document.forms[0].metodo.value = 'registrar';
			document.forms[0].submit();
		} */
		function mostrarFecha() {
			var obDat = new Date();
			var dia = obDat.getDate();
			var mes = obDat.getMonth() + 1;
			var anho = obDat.getFullYear();
			if (dia < 10)
				dia = "0" + dia;
			if (mes < 10)
				mes = "0" + mes;
			document.forms[0].fecha.value = dia + "/" + mes + "/" + anho;
		}
	</script>
</head>
<body>
	<h1>
		<s:text name="Solicitud.Title" />
	</h1>
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
			<s:if test="solicitud.id!=0">
				<tr>
					<td align="left"><s:text name="Solicitud.Cod" /></td>
					<td align="left" colspan="3">
						<s:hidden name="solicitud.id"></s:hidden>
						<s:hidden name="solicitud.estado.idestado"></s:hidden>
						<s:textfield name="solicitud.id" disabled="true"></s:textfield>
					</td>
				</tr>
			</s:if>
			<tr>
				<td align="left"><s:text name="Solicitud.NumTarj" /></td>
				<td align="left" colspan="3">
					<s:textfield id="buscTarjeta" name="buscTarjeta"></s:textfield>
					<input type="button" value="<s:text name="Solicitud.btn.BusqTarj"/>" onclick="f_buscarEquipo('mensaje');"> 
					<input type="button" value="<s:text name="Solicitud.btn.ObtenerDat"/>" onclick="f_obtener();">
					<!-- <s:submit action="obtenerEquipo" value="Obtener Datos"/> -->
				</td>
			</tr>
			<s:if test="solicitud.equipo!=null">
				<tr>
					<td colspan="4">
						<table class="article">
							<tr>
								<th colspan="5">Datos de Equipo</th>
							</tr>
							<tr>
								<td>Nro. Tarjeta</td>
								<td>Nro. Serie</td>
								<td>Clase</td>
								<td>Modelo</td>
							</tr>
							<tr>
								<td>
									<s:textfield name="equipo.nrotarjeta" disabled="true"></s:textfield>
									<s:hidden name="equipo.nrotarjeta"></s:hidden>
								</td>
								<td><s:textfield name="equipo.nroserie" disabled="true"></s:textfield></td>
								<td><s:textfield name="equipo.claseEquipo" disabled="true"></s:textfield></td>
								<td><s:textfield name="equipo.modelo" disabled="true"></s:textfield></td>
							</tr>
							<tr>
								<th colspan="5">Datos de Cliente</th>
							</tr>
							<tr>
								<td>RUC</td>
								<td>Razon Social</td>
								<td>Dirección</td>
								<td>Telefono</td>
							</tr>
							<tr>
								<td>
									<s:textfield name="cliente.id" disabled="true">
										<s:hidden name="cliente.id" />
									</s:textfield>
								</td>
								<td><s:textfield name="cliente.razonSoc" disabled="true"></s:textfield></td>
								<td><s:textfield name="cliente.direccion" disabled="true"></s:textfield></td>
								<td><s:textfield name="cliente.telefono" disabled="true"></s:textfield></td>
							</tr>
						</table>
					</td>
				</tr>
			</s:if>
			<tr>
				<td align="left"><s:text name="Solicitud.Fecha" /></td>
				<td colspan="3" align="left">
					<sx:datetimepicker id="fecha" name="solicitud.fecha" type="date" displayFormat="dd/MM/yyy" />
					<script type="text/javascript">
						var fecha = new LiveValidation('fecha');
						fecha.add(Validate.Presence, {
							failureMessage : "¡Es Requerido!"
						});
					</script> 
					<!--
					<a href="javascript:NewCal('solicitud_solicitud_fecha','ddmmyyyy')"><img src="img/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
					 -->
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="Solicitud.HorometroAct" /></td>
				<td colspan="3" align="left">
					<s:textfield id="horometro" name="solicitud.horometro" maxlength="11"></s:textfield>
					<script type="text/javascript">
						var horometro = new LiveValidation('horometro');
						horometro.add(Validate.Presence, {
							failureMessage : "¡Es Requerido!"
						});
						horometro.add(Validate.Numericality, {
							failureMessage : "¡Solo Contenido Numerico!"
						});
						horometro.add(Validate.Length, {
							maximum : 11
						});
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="Solicitud.Repre" /></td>
				<td colspan="3" align="left">
					<s:textfield id="representante" name="solicitud.representante" maxlength="99"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('representante');
						representante.add(Validate.Presence, {
							failureMessage : "¡Es Requerido!"
						});
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="Solicitud.Telef" /></td>
				<td colspan="3" align="left">
					<s:textfield id="telefono" name="solicitud.telefono" maxlength="11"></s:textfield>
					<script type="text/javascript">
						var fono = new LiveValidation('telefono');
						fono.add(Validate.Presence, {
							failureMessage : "¡Es Requerido!"
						});
						fono.add(Validate.Numericality, {
							failureMessage : "¡Ingresar numero telefonico correcto!"
						});
						fono.add(Validate.Length, {
							maximum : 11
						});
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="Solicitud.Coment" /></td>
				<td colspan="3" align="left">
					<s:textarea id="desc" name="solicitud.desc" cols="50"></s:textarea>
					<script type="text/javascript">
						var desc = new LiveValidation('desc');
						desc.add(Validate.Presence, {
							failureMessage : "Ingresar la descripcion del problema!"
						});
					</script>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="left">
					<s:submit action="insertaSolicitud" value="Grabar" />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>