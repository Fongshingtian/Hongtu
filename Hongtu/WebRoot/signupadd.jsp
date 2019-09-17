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
		<center><font face="幼圆" style='color: #5a524c;font-size: 30px;font-weight: 400'>预定报名</font></center>
		<hr  style='border: 0.1px solid gray;width: 94%'>
		<form  id='fo'  action='hongtu?method=signupadd&id=${c.id }' method="post">
		<table border='0' align='center'>
			<tr>
				<td style='border: 1px solid;gray'><img src='${c.imgs }'></td>
				<td width='3%'></td>
				<td valign="top">
					<font style='font-size: x-large;color:#615f63;font-weight: 700'>${c.title }</font>
					<hr style='border-color:lightgray;width:105%;margin: 15px auto'>
					 价格：<font style='font-size: x-large;font-weight: 700;color:teal'>￥${c.price }</font><br><br>
					 描述：<font style='font-weight: 400;color:#473636'>${c.contents }</font>
					<hr style='border-color:lightgray;width:105%;margin: 15px auto'>
					 填写资料：
					<center>
					<div style='margin: 10px auto'>姓名 <input name='name' id='name'  type='text'></div> 
					电话 <input name='tel'  id='tel' type='text'><br><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a style='border: 1px solid;cursor: pointer;j' onclick="history.back(-1);" >返  回</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a style='border: 1px solid;cursor: pointer;' onclick="return dosubmit();" >提  交</a>
					</center> 
				</td>
			</tr>
		</table>
		</form>
		<hr>
		<br/> 
		<jsp:include page="weibu.jsp"/>
		<script type="text/javascript">
			function dosubmit(){
				var name=document.getElementById('name').value;
				var tel=document.getElementById('tel').value;
				if(name==""){
					alert("请输入姓名！");
					return false;
				}
				if(tel==""){
					alert("请输入电话！");
					return false;
				}
				document.getElementById('fo').submit();
			}
		</script>
	</body>
</html>
