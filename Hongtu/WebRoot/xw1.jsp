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
    <jsp:include page="toubu.jsp" />
    
    <br/><br/> 
	<table width="80%"   align="center">
		<tr>
			<td><div style="text-indent: -1em"><font face="微软雅黑" style='font-weight: 300;font-size: xx-large;color:black;margin: 15px;'>${news.title}</font></div><hr style='margin: 6px;' ><div style="text-indent: 4em">${news.ctime}</div></td>
		</tr>
		<tr>
			<td><hr style="border-color: black;margin: 8px auto;width: 100%">${news.contents }<br></td>
		</tr>
		<br>
		<tr>
			<td align="center"><font face="微软雅黑" size="4"></font></td>
		</tr>
	</table>
	
	<br><br>
    <jsp:include page="weibu.jsp" />
  </body>
</html>
