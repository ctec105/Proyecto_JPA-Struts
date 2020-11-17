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
</head>
<body>
	<h1><s:text name="musuario.titulo"/></h1>
	<s:form id="formMantUsuario" theme="simple">
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
			<s:if test="usuario.codUsuario!=0">
				<tr>
					<td align="left" width="20%"><s:text name="musuario.codigo_usuario"/></td>
					<td align="left" colspan="3">
						<s:hidden name="usuario.codUsuario"></s:hidden>
						<s:textfield name="usuario.codUsuario" disabled="true"></s:textfield>
					</td>
				</tr>
			</s:if>
			<tr>
				<td align="left"><s:text name="musuario.nombre"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtNombre" name="usuario.nombre"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtNombre');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="musuario.ape_paterno"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtApePat" name="usuario.ape_pat"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtApePat');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="musuario.ape_paterno"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtApeMat" name="usuario.ape_mat"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtApeMat');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="musuario.fecha_ingreso"/></td>
				<td colspan="3" align="left">
					<sx:datetimepicker id="txtFecha" name="usuario.ingreso" type="date" displayFormat="dd/MM/yyy" />
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="musuario.usuario"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtUsuario" name="usuario.login"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtUsuario');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="musuario.contraseña"/></td>
				<td colspan="3" align="left">
					<s:textfield id="txtContraseña" name="usuario.password"></s:textfield>
					<script type="text/javascript">
						var representante = new LiveValidation('txtContraseña');
						representante.add(Validate.Presence);
					</script>
				</td>
			</tr>
			<tr>
				<td align="left"><s:text name="musuario.area"/></td>
				<td colspan="3" align="left">
					<s:select id="cboArea" name="usuario.codArea" list="#session.areas" listKey="area" listValue="descripcion" />
					<%-- <td colspan="3" align="left">
						<s:textfield name="usuario.codArea"></s:textfield>
						<script type="text/javascript">
								var representante = new LiveValidation('usuario_usuario_codArea');
								representante.add(Validate.Presence);
						</script>
					</td> --%>
			</tr>
			<s:hidden id="rbEstado" name="usuario.estado"/>
			<tr>
				<td colspan="4" align="left">
					<s:submit id="btnGrabar" key="musuario.grabar" action="insertaUsuario"/>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>