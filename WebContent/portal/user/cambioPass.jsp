<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script type="text/javascript" src="js/livevalidation.js">
		
	</script>
</head>
<body>
	<s:form>
		<font color="red">
			<s:fielderror />
			<s:actionerror />
			<s:actionmessage />
		</font>

		<s:textfield id="txtUsuario" key="cambioPass.usuario"  name="usuario.login" readonly="true" />
		
		<s:password id="txtContraseñaActual" name="usuario.password" key="cambioPass.contraseña_actual" />
		<script type="text/javascript">
			var pwd = new LiveValidation('txtContraseñaActual');
			pwd.add(Validate.Presence, {
				failureMessage : "¡Es Requerido!"
			});
		</script>
		
		<s:password id="txtContraseñaNueva" name="newPass" key="cambioPass.contraseña_nueva" />
		<script type="text/javascript">
			var newPwd = new LiveValidation('txtContraseñaNueva');
			newPwd.add(Validate.Presence, {
				failureMessage : "¡Es Requerido!"
			});
		</script>
		
		<s:password id="txtConfirmarContraseñaNueva" name="confPass" key="cambioPass.repetir_contraseña" />
		<script type="text/javascript">
			var confPwd = new LiveValidation('txtConfirmarContraseñaNueva');
			confPwd.add(Validate.Presence, {
				failureMessage : "¡Es Requerido!"
			});
			confPwd.add(Validate.Confirmation, {
				match : 'txtContraseñaNueva'
			});
		</script>
		
		<s:submit id="btnCambiarContraseña" key="cambioPass.cambiar_contraseña" action="cambiaPwd" />
	</s:form>
</body>
</html>