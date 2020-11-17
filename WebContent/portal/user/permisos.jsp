<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="xhtml" />
<sx:head parseContent="true" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style type="text/css" media="all">
@import url("css/screen.css");
</style>
<script type="text/javascript">
	function permisosArea(id) {
		id = document.forms[0].tipo.value;
		if (id != '') {
			alert(id);
			document.forms[0].action = 'usuarios.do';
			document.forms[0].metodo.value = 'permisos';
			document.forms[0].id.value = id;
			document.forms[0].submit();
		}
	}
	function actualizar() {
		document.forms[0].action = 'usuarios.do';
		document.forms[0].metodo.value = 'permisosUpdate';
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<s:form theme="simple">
		<table width="97%">
			<tr>
				<th align="right">Area:</th>
				<th align="left">
					<s:select name="area.area" list="#session.areas" listKey="area" listValue="descripcion" />
				</th>
			</tr>
			<tr>
				<td colspan="3">
					<s:submit action="permisosList" value="Mostrar Permisos" />
				</td>
			</tr>
		</table>

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

		<table class="article">
			<tr>
				<th>Id Menu</th>
				<th width="190px">titulo</th>
				<th>Permitido?</th>
			</tr>
			<s:iterator value="listMenu" status="status">
				<tr>
					<td><s:property value="menu.id" /></td>
					<s:if test="menu.nivel.length()==1">
						<th><s:property value="menu.titulo" /></th>
					</s:if>
					<s:else>
						<td>---<s:property value="menu.titulo" /></td>
					</s:else>
					<td>
						<%-- <s:property value="ver"/> --%> 
						<%-- <s:set var="ver" value="'S'"/>
				    	<s:if test="%{#ver.equals('S')}"> --%>
				    	<%-- <s:if test='ver=="S"'> --%>
						<s:if test='ver.trim().equals("S")'>
							<div align="center">
								<input type="checkbox" name="activar" checked="checked"
									value=" <s:property value="menu.id"/>">
							</div>
						</s:if> <s:else>
							<div align="center">
								<input type="checkbox" name="activar"
									value="<s:property value="menu.id"/>">
							</div>
						</s:else>
					</td>
				</tr>
			</s:iterator>
		</table>

		<input type="button" value="Modificar" onclick="actualizar();">
	</s:form>

</body>
</html>
