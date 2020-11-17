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
	<title></title>
	<script type="text/javascript" src="js/datetimepicker.js">
		
	</script>
	<script type="text/javascript">
		window.name = 'principal';
	
		function f_buscarSolicitud(msg) {
			hija = window.open("popBuscarSolicitud.action", msg, "scrollbars=NO,location=0 ,width= 500, height=400");
			hija.focus();
			//document.forms[0].target = 'ventana';
		}
		function f_obtener() {
			//document.forms[0].action='solicitud.do';
			document.forms[0].action = 'ObtenerSolicitud';
			document.forms[0].submit();
		}
		function f_buscarPaquete(msg) {
			hija = window.open("popBuscarPaquete.action", msg, "scrollbars=NO,location=0 ,width= 500, height=400");
			hija.focus();
			//document.forms[0].target = 'ventana';
		}
		function f_buscarTecnico(msg) {
			hija = window.open("popBuscarTecnico.action", msg, "scrollbars=NO,location=0 ,width= 500, height=400");
			hija.focus();
			//document.forms[0].target = 'ventana';
		}
		
	</script>
	<script type="text/javascript">
		function before() {
			alert("before request");
		}
		function after() {
			alert("after request");
		}
		function handler(widget, node) {
			alert('I will handle this myself!');
			dojo.byId(widget.targetsArray[0]).innerHTML = "Done";
		}
	
		dojo.event.topic.subscribe("/alltopics", function(data, type, e) {
			alert('inside a topic event. type=' + type);
			//data : text returned
			//type : "before", "load" or "error"
			//e    : request object
		});
	</script>
</head>
<body>
<%-- 	<s:url var="paquete" value="/popBuscarPaquete.action"></s:url> --%>
	<s:url var="ajaxPaquete" value="/ObtenerPaquete.action" />
	<s:url var="ajaxTecnico" value="/ObtenerTecnico.action" />
	
	<s:form theme="simple">
		<h1>
			<s:text name="Orden.Title" />
		</h1>
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
		<table>
			<s:if test="trabajo.id!=0">
				<tr>
					<td align="left" width="20%"><s:text name="Codigo" /></td>
					<td align="left" colspan="3"><s:textfield name="trabajo.id" disabled="true"></s:textfield></td>
				</tr>
			</s:if>
			<tr>
				<th colspan="4" align="left">
					<s:text name="Orden.CodSolic" />
					<s:hidden name="trabajo.id"></s:hidden>
					<s:hidden name="trabajo.solicitud"></s:hidden>
					<s:hidden name="trabajo.idLiquidacion"></s:hidden>
					<s:textfield id="buscSolic" name="buscSolic"></s:textfield>
					<input type="button" value="<s:text name="Orden.btn.BusqSolic"/>" onclick="f_buscarSolicitud('mensaje');">
					<input type="button" value="<s:text name="Orden.btn.ObtenerDat"/>" onclick="f_obtener();">
				</th>
			</tr>
<!-- 			<tr> -->
<!-- 				<td colspan="4" align="left"> -->
					
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td colspan="4">
					<s:if test="solicitud!=null">
						<table class="article" width="90%">
							<tr>
								<th colspan="4">Solicitud de Servicio</th>
							</tr>
							<tr>
								<th width="100px">Codigo</th>
								<th width="100px">Fecha</th>
								<th width="100px">Representante</th>
								<th width="100px">Problema</th>
							</tr>
							<tr>
								<td><s:text name="solicitud.id"></s:text></td>
								<td><s:text name="solicitud.fecha"></s:text></td>
								<td><s:text name="solicitud.representante"></s:text></td>
								<td><s:text name="solicitud.desc"></s:text></td>
							</tr>
						</table>
					</s:if>
				</td>
			</tr>
			<tr>
				<th colspan="2" align="left"><s:text name="Orden.FechaIni" /></th>
				<th colspan="2" align="left"><s:text name="Orden.FechaFin" /></th>
			</tr>
			<tr>
				<td colspan="2" align="left">
					<sx:datetimepicker name="trabajo.fecha_inicio" type="date" displayFormat="dd/MM/yyy" />
				</td>
				<td colspan="2">
					<sx:datetimepicker name="trabajo.fecha_termino" type="date" displayFormat="dd/MM/yyy" />
				</td>
			</tr>
			<tr>
				<th colspan="4" align="left">
					<s:text name="Orden.IDPaquete" />
					<s:textfield id="buscPaq" name="buscPaq"></s:textfield>
					<input type="button" value="..." onclick="f_buscarPaquete('mensaje');">
					<!-- <input type="button" value="Agregar Paquete" onclick="f_obtenerPaquete();">  -->
					<sx:submit type="submit" value="Agregar Paquete" targets="t1" id="btnAjax" href="%{ajaxPaquete}" />
				</th>
			</tr>
			<tr>
				<td colspan="4">
					<div id="t1">
						<table class="article">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Duración</th>
							</tr>
							<s:iterator value="#session.trabajoPaquetes" status="status">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="nombre" /></td>
									<td><s:property value="duracion" /> dias</td>
									<td><img align="bottom" src="img/delete.png" title="Eliminar" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="4" align="left">
					Tecnicos: 
					<s:textfield id="busTec" name="busTec"></s:textfield>
					<input type="button" value="..." onclick="f_buscarTecnico('mensaje');">
					<!-- <input type="button" value="Agregar Tecnico" onclick="f_obtenerTecnico();">  -->
					<sx:submit type="submit" value="Agregar Tecnico" targets="t2" id="btnAjax" href="%{ajaxTecnico}" />
				</th>
			</tr>
			<tr>
				<td colspan="4">
					<div id="t2">
						<table class="article">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Especialidad</th>
							</tr>
							<s:iterator value="#session.trabajoTecnicos">
								<tr>
									<td><s:property value="id" /></td>
									<td><s:property value="nombre" /><s:property value="ape_pat" /></td>
									<td><s:property value="idEspecialidad" /></td>
									<td><img align="bottom" src="img/delete.png" title="Eliminar" /></td>
								</tr>
							</s:iterator>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<th colspan="4" align="left"><s:text name="Orden.Coment" /></th>
			</tr>
			<tr>
				<td colspan="4" align="left">
					<s:textarea name="trabajo.comentarios" cols="60" rows="4"></s:textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<s:submit action="InsertaTrabajo" value="Grabar" />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>