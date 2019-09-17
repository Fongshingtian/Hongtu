<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
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
		<br>
		<table width='80%' align='center'>
			<tr>
				<td >
					联系我们
					<hr style='margin: 8px auto;border: 0.6px solid;gray'>
				</td>
			</tr>
			<tr>
				<td>
					${list.map }
				</td>
			</tr>
			<tr>
				<td >
					${list.contents }
				</td>
			</tr>
		</table>
    <jsp:include page="weibu.jsp" />
  </body>
</html>
