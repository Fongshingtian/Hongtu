<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<link rel="icon" href="images/logo.ico" type="images/x-ico" />

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<jsp:include page="toubu.jsp" />
		<br/>
	<center><font face="幼圆" style='color: #5a524c;font-size: 30px;font-weight: 400'>师资力量</font></center>
		<hr  style='border: 0.4px solid gray;width: 94%'>		
	<table  style='width: 83%;border: 0px solid red;' align="center">
		<tr align="center">
			<td align="center">
				<ul style='list-style: none;'>
					<c:forEach items='${courselist}' var='s'>
						<li style='float: left;width: 50%;height: 600px' >
							<table align="center"  style='width: 521px;line-height: 23px'>
								<tr><td  align="center"><font style='font-size: 20px;color: #473d36'>${s.name }</font>
									 <hr style='border: 0.6px solid #d0bfbc;black;width: 100%;margin: 15px auto'> 
								</td></tr>
								<tr ><td style="height: 370px" align="center"><img src='${s.imgs}' style='border: 0px solid;' ></td></tr>
								<tr><td height="5px"></td></tr>
								<tr><td><font face="幼圆" style='font-size: 13px'>${s.detail }</font></td></tr>
							</table>
							<br><br><br>
						</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
		<jsp:include page="weibu.jsp" />
	</body>
</html>
				