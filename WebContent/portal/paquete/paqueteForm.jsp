<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<s:head theme="xhtml" />
	<sx:head parseContent="true" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js/livevalidation.js">
		
	</script>
	<script type="text/javascript">
		window.name = 'principal';
	
		function f_abrirPop(msg) {
			var action = msg + '.action';
			hija = window.open(action, msg, "scrollbars=NO, location=0, width=500, height=400");
			hija.focus();
			//document.forms[0].target = 'ventana';
		}
	</script>
</head>
<script>
	function show_details() {
		dojo.event.topic.publish("show_detail");
	}
</script>
<body>
	<s:url var="ajaxModelo" value="/ObtenerModelos.action" />
	<s:url var="ajaxHerramienta" value="/ObtenerHerramienta.action" />
	<s:url var="ajaxMaterial" value="/ObtenerMaterial.action" />
	<s:url var="ajaxActividad" value="/ObtenerActividad.action" />
	<s:url var="ajaxCalcular" value="/CalcularPrecio.action" />
	
	<s:form theme="simple" id="formPaq" name="formPaq">
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
		<h1>Registro de Paquetes de Servicio</h1>
		<table>
			<s:if test="paquete.id!=0">
				<tr>
					<td align="left" width="20%">Código de Paquete:</td>
					<td align="left" colspan="3">
						<s:hidden name="paquete.id"></s:hidden>
						<s:textfield name="paquete.id" disabled="true"></s:textfield>
					</td>
				</tr>
			</s:if>
			<tr>
				<td align="left">Nombre:</td>
				<td align="left" colspan="3">
					<s:textfield id="nombre" name="paquete.nombre" maxlength="99" />
					<script type="text/javascript">
						var nombre = new LiveValidation('nombre');
						nombre.add(Validate.Presence, {
							failureMessage : "¡Es Requerido!"
						});
					</script>
				</td>
			</tr>
			<tr>	
				<td align="left">Marca:</td>
				<td align="left" colspan="3">
					<s:select id="cboPaquete" name="paquete.marca"
						list="#session.paqueteMarca" listKey="id" listValue="descripcion"
						onchange="javascript:show_details();return false;">
					</s:select>
				</td>
			</tr>
			<tr>
				<td align="left">Modelo:</td>
				<td align="left" colspan="3">
					<sx:div id="details" href="%{ajaxModelo}"
						listenTopics="show_detail" formId="formPaq" autoStart="false"
						preload="false" showLoadingText="">
						<s:select name="paquete.modelo" list="#session.paqueteModelo" listKey="id" listValue="descripcion" />
					</sx:div>
				</td>
			</tr>
			<tr>
				<td align="left">Duración:</td>
				<td align="left" colspan="3">
					<s:textfield id="duracion" name="paquete.duracion" /> 
					<script type="text/javascript">
						var duracion = new LiveValidation('duracion');
						duracion.add(Validate.Presence, {
							failureMessage : "¡Es Requerido!"
						});
						duracion.add(Validate.Numericality, {
							minimum : 1,
							failureMessage : "¡Solo Contenido Numerico!"
						});
					</script>
				</td>
			</tr>
			<tr>
				<th>Código Herramienta:</th>
				<td>
					<s:textfield id="buscHer" name="buscHer" />
					<input type="button" value="..." onclick="f_abrirPop('popBuscarHerramienta');">
					<sx:submit type="submit" value="Agregar Herramienta" targets="divHer" href="%{ajaxHerramienta}" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="divHer">
						<table class="article">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Precio</th>
							</tr>
							<s:iterator value="#session.paqHerramientas">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="descripcion" /></td>
									<td><s:property value="precio" /></td>
									<td><s:a><img align="top" src="img/delete.png" title="Eliminar" /></s:a></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th>Código de Material:</th>
				<td>
					<s:textfield id="buscMat" name="buscMat" /> 
					<input type="button" value="..." onclick="f_abrirPop('popBuscarMaterial');"> 
					<sx:submit type="submit" value="Agregar Material" targets="divMat" href="%{ajaxMaterial}" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="divMat">
						<table class="article">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Precio</th>
							</tr>
							<s:iterator value="#session.paqMateriales">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="descripcion" /></td>
									<td><s:property value="precio" /></td>
									<td><img align="bottom" src="img/delete.png" title="Eliminar" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th>Código de Actividad:</th>
				<td>
					<s:textfield id="buscAct" name="buscAct" />
					<input type="button" value="..." onclick="f_abrirPop('popBuscarActividad');">
					<sx:submit type="submit" value="Agregar Actividad" targets="divAct" href="%{ajaxActividad}" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="divAct">
						<table class="article">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Precio</th>
							</tr>
							<s:iterator value="#session.paqActividades">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="descripcion" /></td>
									<td><s:property value="precio" /></td>
									<td><img align="bottom" src="img/delete.png"title="Eliminar" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th>Precio: <sx:submit type="image" src="img/calculator.png"
						label="Calcular" href="%{ajaxCalcular}" align="right"
						targets="divPrecio" />
				</th>
				<td>
					<div id="divPrecio">
						<s:textfield id="precio" name="paquete.precio" />
					</div>
					<script type="text/javascript">
						var precio = new LiveValidation('precio');
						precio.add(Validate.Numericality, {
							failureMessage : "¡Solo Contenido Numerico!"
						});
					</script>
				</td>
			</tr>
			<tr>
				<td><s:submit action="insertarPaquete" value="::: Grabar :::" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>