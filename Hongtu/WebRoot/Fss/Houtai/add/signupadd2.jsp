<%@ page language="java" import="java.util.*" pageEncoding="gbk%>
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
		<br/><br/>
		<h1 align="center"><font face="微软雅黑" color="black" style='font-weight: 300'>预定报名</font></h1>
		<hr style='border: 0.5px solid gray;'>
		<form    action='hongtu?method=signupadd&id=${c.id }' method="post">
		<table border='0' align='center'>
			<tr>
				<td style='border: 1px solid;gray'><img src='${c.imgs }'></td>
				<td width='3%'></td>
				<td valign="top">
					<font style='font-size: x-large;color:#615f63;font-weight: 700'>${c.title }</font>
					<hr style='border-color:lightgray;width:105%'>
					 价格：<font style='font-size: x-large;font-weight: 700;color:teal'>￥${c.price }</font><br><br>
					 描述：<font style='font-weight: 400;color:#473636'>${c.contents }</font>
					<hr style='border-color:lightgray;width:105%;margin: 25px auto'>
					 填写资料：
					<center>
					姓名 <input name='name' id='name${c.id}'  type='text'><br>
					电话 <input name='tel'  id='tel${c.id}' type='text'><br><br>
					<input type='button' value='返 回'>
					<input type='submit' value='提 交'>
					</center>
				</td>
			</tr>
		</table>
		</form>
		<hr>
		<br/> 
		<jsp:include page="weibu.jsp"/>
	</body>
</html>
