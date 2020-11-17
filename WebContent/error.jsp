<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page isErrorPage="true"%>
<html>
<head>
<title>Pagina de Error</title>
<link href="resources/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="titleDiv">Aplicacion Sistema Maskiner</div>
	<p>
		<font size=4 color=orange>Esta observando la pagina de error</font><br>
		<br> <a href="index.jsp">Regresar a la aplicacion</a><br>
		<br> Reportar el error al grupo de desarrollo. <br />
		<br /> La siguiente informacion puede ayudar a solucionar el error o a
		prevenir que vuelva a ocurrir en el futuro. <br />
		<%
			if (null == exception) {
				exception = (Throwable) request
						.getAttribute("org.apache.struts.action.EXCEPTION");
			}
		%>
	
	<pre style="font-size: 12px">
		<%
			if (null == exception) {
				out.write("Source of error is unknown.");
			} else {
				java.io.StringWriter sw = new java.io.StringWriter();
				java.io.PrintWriter pw = new java.io.PrintWriter(sw);

				exception.printStackTrace(pw);
				out.write(sw.getBuffer().toString());

			}
		%>
	</pre>
</body>
</html>
