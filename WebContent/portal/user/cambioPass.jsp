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
		
		<s:password id="txtContrase�aActual" name="usuario.password" key="cambioPass.contrase�a_actual" />
		<script type="text/javascript">
			var pwd = new LiveValidation('txtContrase�aActual');
			pwd.add(Validate.Presence, {
				failureMessage : "�Es Requerido!"
			});
		</script>
		
		<s:password id="txtContrase�aNueva" name="newPass" key="cambioPass.contrase�a_nueva" />
		<script type="text/javascript">
			var newPwd = new LiveValidation('txtContrase�aNueva');
			newPwd.add(Validate.Presence, {
				failureMessage : "�Es Requerido!"
			});
		</script>
		
		<s:password id="txtConfirmarContrase�aNueva" name="confPass" key="cambioPass.repetir_contrase�a" />
		<script type="text/javascript">
			var confPwd = new LiveValidation('txtConfirmarContrase�aNueva');
			confPwd.add(Validate.Presence, {
				failureMessage : "�Es Requerido!"
			});
			confPwd.add(Validate.Confirmation, {
				match : 'txtContrase�aNueva'
			});
		</script>
		
		<s:submit id="btnCambiarContrase�a" key="cambioPass.cambiar_contrase�a" action="cambiaPwd" />
	</s:form>
</body>
</html>