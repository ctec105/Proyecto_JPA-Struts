<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <TITLE><tiles:insertAttribute name="title"/> </TITLE>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="sdmenu/sdmenu.css" />
<script type="text/javascript" src="js/script.js"> </script>
<script type="text/javascript" src="js/metodos.js"> </script>
<script type="text/javascript" src="sdmenu/sdmenu.js"> </script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>

</head>
<body>
	<div class="Main">
        <div class="Sheet">
            <div class="Sheet-tl"></div>
            <div class="Sheet-tr"><div></div></div>
            <div class="Sheet-bl"><div></div></div>
            <div class="Sheet-br"><div></div></div>
            <div class="Sheet-tc"><div></div></div>
            <div class="Sheet-bc"><div></div></div>
            <div class="Sheet-cl"><div></div></div>
            <div class="Sheet-cr"><div></div></div>
            <div class="Sheet-cc"></div>
            <div class="Sheet-body">
            
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
			
			<table>
				<tr>
					<td colspan="3">
						<tiles:insertAttribute name="status"></tiles:insertAttribute>
					</td>
				</tr>
				<tr>
					<td align="left" style="width:50px;vertical-align: top" > 
						<tiles:insertAttribute name="menu"></tiles:insertAttribute>
					</td>
					<td align="left" colspan="2" style="width:740px;vertical-align:top">
						<div class="content">
						     <div class="Post">
						         <div class="Post-tl"></div>
						         <div class="Post-tr"><div></div></div>
						         <div class="Post-bl"><div></div></div>
						         <div class="Post-br"><div></div></div>
						         <div class="Post-tc"><div></div></div>
						         <div class="Post-bc"><div></div></div>
						         <div class="Post-cl"><div></div></div>
						         <div class="Post-cr"><div></div></div>
						         <div class="Post-cc"></div>
						         <div class="Post-body">
						     <div class="Post-inner">
						         <tiles:insertAttribute name="body"></tiles:insertAttribute>
						         <div class="cleared"></div>
						     </div>
						     
						         </div>
						     </div>
						 </div>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="3">
					<div class="cleared"></div><div class="Footer">
				       <div class="Footer-inner">
				           <a href="#" class="rss-tag-icon" title="RSS"></a>
				           		<div class="Footer-text">
									<tiles:insertAttribute name="footer"></tiles:insertAttribute>
								</div>
					       </div>
					       <div class="Footer-background"></div>
					    </div>
					</td>
				</tr>
			</table>
			<div class="cleared"></div>
	        <!-- If you'd like to support Artisteer, having the "created with" link somewhere on your blog is the best way; it's our only promotion or advertising. -->
	    </div>
	</div>
</div>  
</body>
</html>