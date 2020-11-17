<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../sdmenu/sdmenu.css" />
<script type="text/javascript" src="../sdmenu/sdmenu.js">
	</script>
	<script type="text/javascript">
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
</script>
</head>
<body>
	<div style="float: left" id="my_menu" class="sdmenu">
		<div>
			<s:if test="#session.menu!=null">
				<s:iterator value="#session.menu" status="mn">
					<s:if test="menu.nivel.length()==1">
						<s:if test="menu.nivel!=1">
							</div><!-- Cierre -->
						</s:if>
		 <!-- Inicio --><div><!-- Titulo -->
							<span><s:property value="menu.titulo" /></span>
					</s:if>
					<s:else><!-- Subtitulo -->
						<a href="<s:property value="menu.action"/>">
							<s:property value="menu.titulo" />
						</a>
					</s:else>
				</s:iterator>
			</s:if>
		</div>
	</div>
</body>
</html>