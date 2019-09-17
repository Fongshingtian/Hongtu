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
	<script type="text/javascript">
			if("${reply}"!=""){
				alert("${reply}");
			}
	</script>
	</head>

	<body>
		<jsp:include page="toubu.jsp" />
		<br/>
		<center><font face="幼圆" style='color: #5a524c;font-size: 30px;font-weight: 400'>预定报名</font></center>
		<hr  style='border: 0.1px solid gray;width: 94%'>
		<c:forEach items="${courselist}" var="c">
		<form action='hongtu?method=signupadd&id=${c.id }' method="post">
		<table border='0' align='center'>
			<tr>
				<td style='border: 1px solid;gray'><img src='${c.imgs }'></td>
				<td width='3%'></td>
				<td valign="top">
					<font style='font-size: x-large;color:#615f63;font-weight: 700'>${c.title }</font>
					<hr style='border-color:lightgray;width:105%'>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格：<font style='font-size: x-large;font-weight: 700;color:teal'>￥${c.price }</font><br><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述：<font style='font-weight: 400;color:#473636'>${c.contents }</font>
					<center>
					<br><br><br><br><br><br><br><br>
					<a style='border: 1px solid;' href='qt?method=tosignup&id=${c.id }'>立即报名</a>
					</center>
				</td>
			</tr>
		</table>
		</form>
		<hr>
		</c:forEach>
		<br/> 
		<jsp:include page="weibu.jsp"/>
	</body>
</html>

			