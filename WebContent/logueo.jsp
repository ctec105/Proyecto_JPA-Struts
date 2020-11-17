<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>:: Sistema Maskiner ::</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/script.js">
		
	</script>
	<script type="text/javascript" src="js/livevalidation.js">
		
	</script>
</head>
<body>
	<div class="Main">
		<div class="Sheet">
			<div class="Sheet-tl"></div>
			<div class="Sheet-tr">
				<div></div>
			</div>
			<div class="Sheet-bl">
				<div></div>
			</div>
			<div class="Sheet-br">
				<div></div>
			</div>
			<div class="Sheet-tc">
				<div></div>
			</div>
			<div class="Sheet-bc">
				<div></div>
			</div>
			<div class="Sheet-cl">
				<div></div>
			</div>
			<div class="Sheet-cr">
				<div></div>
			</div>
			<div class="Sheet-cc"></div>
			<div class="Sheet-body">
				<div class="Header">
					<div class="Header-png"></div>
					<div class="Header-jpeg"></div>
					<div class="logo">
						<h1 id="name-text" class="logo-name"><!-- 2013 --></h1>
						<div id="slogan-text" class="logo-text"><!-- abc --></div>
					</div>
				</div>
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
							<div class="Post-inner" align="center">
								<div class="BlockHeader">
									<!--div class="header-tag-icon"-->
									<div class="BlockHeader-text">
										<center>
											<s:text name="logueo.inicio" />
										</center>
									</div>
									<!--/div-->
									<div class="l"></div>
									<div class="r">
										<div></div>
									</div>
								</div>
								<br>
								<br>
								<br>
								<s:form action="logueo">
									<table class="article" cellspacing="1" cellpadding="1">
										<tr>
											<td>
												<img src="css/images/llave.JPG" style="width: 100px" />
											</td>
											<th valign="middle" align="center">
												<div class="r">
													<table class="blank">
														<s:textfield id="txtUsuario" key="logueo.usuario" name="usuario.login" />
														<s:password id="txtContraseña" key="logueo.contraseña" name="usuario.password" />
														<script type="text/javascript">
															var login = new LiveValidation('txtUsuario');
																login.add(Validate.Presence);
															var pwd = new LiveValidation('txtContraseña');
																pwd.add(Validate.Presence);
														</script>
													</table>
												</div>
											</th>
										</tr>
									</table>
									<br>
									<table>
										<tr align="center">
											<td align="center">
												<input id="btnIngresar" type="submit" value="<s:text  name="logueo.ingresar" />" style="width: 100px; height: 33px; white-space: nowrap; float: left;" />
												<input id="btnLimpiar" type="reset" value="<s:text  name="logueo.Limpiar" />" style="width: 100px; height: 33px; white-space: nowrap; float: left;" />
											</td>
										</tr>
									</table>
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
								</s:form>
								<%-- <s:url id="localezhCN" namespace="/" action="locale">
									<s:param name="request_locale">zh</s:param>
								</s:url> --%>
								<br>
								<br>
								<br>
								<div class="cleared"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>