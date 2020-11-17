<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<title></title>
</head>
<body>
<table class="article" width="845px" align="left">
	<tr>
		<th width="645px" style="text-align:rigth;"><s:text name="status.usuario" /> :&nbsp;<%=session.getAttribute("nombre") %> </th>
		<th width="200px" style="text-align:center;"><s:text name="status.area"/> :&nbsp;<%=session.getAttribute("area") %></th>
	</tr>
</table>
</body>
</html>