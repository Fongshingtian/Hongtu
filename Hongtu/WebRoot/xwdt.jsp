<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		function doover(id,id2){
			document.getElementById(id).style="background:lightgray;"
			document.getElementById(id2).style="color:black;"
		}
		function doout(id,id2){
			document.getElementById(id).style="background:white;"
			document.getElementById(id2).style="color:gray;"
		}
	</script>
  </head>
  
  <body>
    <jsp:include page="toubu.jsp" />
    
    <br/>
		<center><font face="幼圆" style='color: #5a524c;font-size: 30px;font-weight: 400'>新闻动态</font></center>
		<hr  style='border: 0.1px solid gray;width: 94%'>
	<table width="70%" align="center">
		<tr>
			<td><b><font face="微软雅黑" size="5" style='font-weight: 400'>文章列表</font></b></td> 
		</tr>
		
		<tr>
			<td><hr style="border-color: gray;width: 100%;margin:12px auto; "> </td>
		</tr>
		<tr>
			<td>
			<ul style='list-style: none;'>
			<c:forEach items="${courselist}" var="c">
				<a  id='${ c.id+1111}'  onmouseover="doover(${c.id },${c.id+1111})" onmouseout="doout(${c.id },${c.id+1111});" href='qt?method=czxw&id=${c.id }' style='color:gray;'>
						<li id="${c.id }" style='vertical-align: middle'>
						 <font face="微软雅黑">${c.title }</font><font size="2" style="float: right">${c.ctime }</font>
						<hr style='margin: 7px auto;border-color: gray;width: 100%;border-style: dashed;'>
					</li>
				<a>
			</c:forEach>
			</ul>
		</td>
		</tr>
		
	</table>
	<br><br>
    <jsp:include page="weibu.jsp" />
  </body>
</html>
