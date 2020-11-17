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
	<title>Insert title here</title>
</head>
<body>
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
		<sx:tabbedpanel id="tagContainer">
			<sx:div label="Facturación de clientes por fechas"
				labelposition="top" cssStyle="height:100px;margin:10%;">
				<h2 align="center">
					<s:text name="Facturación de clientes por fechas"></s:text>
				</h2>
				<table align="center">
					<tr>
						<th><s:text name="Desde:" /></th>
						<td><sx:datetimepicker name="fecInicio" /></td>
					</tr>
					<tr>
						<th><s:text name="Hasta:"></s:text></th>
						<td><sx:datetimepicker name="fecFin" /></td>
					</tr>
					<tr>
						<td colspan="2">
						<br />
						<br />
						<s:submit value="Generar Reporte" action="reporte1" /></td>
					</tr>
				</table>
			</sx:div>
			<sx:div label="Solicitudes Pendientes">
				<h2 align="center">
					<s:text name="Solicitudes Pendientes "></s:text>
				</h2>
				<table align="center">
					<tr>
						<td colspan="2"><s:submit value="Generar Reporte" action="reporte2" /></td>
					</tr>
				</table>
				<br />
				<br />
				<br />
			</sx:div>
		</sx:tabbedpanel>
	</s:form>
</body>
</html>