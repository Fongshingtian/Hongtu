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

  </head>
  
  <body>
 		<jsp:include page="toubu.jsp"/>
 		<br/><br/><br/>
 		<h1 align="center"><font face="微软雅黑">就业明星</font></h1>
 		<br/><br/><br/>
 		<table style="border: 1px solid #3586f2;width: 90%;margin: 0 auto;">
		<tr style='background:#3586f2;height: 40px;color:white;'> 
			<td style='vertical-align:middle'><font face="微软雅黑"> &nbsp;&nbsp;2013年之前毕业生</font></td>
		</tr>
		<tr>
			<td>
			<ul style="list-style: none;">
				<br>
				<c:forEach items="${courselist}" var="c">
				<li style="float: left;width: 25%;">
					<table style="border: 0px solid #3586f2;width: 90%;margin: 0 auto;">
					<tr style='text-align: center;'>
						<td><br><img src="${c.imgs}" style='width: 300px;height:300;'></td>
					</tr>
					</table>
					<br>
				</li>
				</c:forEach>
			</ul>
			</td>
		</tr>
		</table>
 		<br/><br/><br/>
 		<jsp:include page="weibu.jsp"/>
  </body>
</html>