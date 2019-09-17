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
		<br/><br/><br/>
		<h1 align="center"><font face="微软雅黑">师资力量</font></h1>
		<br/><br/><br/>
		<table border="0" width="90%" align="center"><tr> 

			<td>
				<ul style="list-style: none;">
					<br>
					<c:forEach items="${courselist}" var="c">
					<li style="float: left;width: 50%;">
						<table style="border: 0px solid #3586f2;width: 550px;margin: 0 auto;height: 520px">
							<tr valign="top" style='text-align: left;margin: 0px;"'>
								<td><font face="微软雅黑">${c.name}</font></td>
							</tr>
							<tr>
								<td><img src="${c.imgs}" style='width: 550px;height:366;'></td>
							</tr>
							<tr height="121px" valign="top">
								<td><font face="微软雅黑" size="2">${c.detail}</font></td>
							</tr>
						</table>
						<br><br><br>
					</li>
					</c:forEach>
				</ul>
			</td>
			
		</tr></table>
		
		<br/><br/><br/>
		<jsp:include page="weibu.jsp" />
	</body>
</html>
				