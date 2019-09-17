<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
    
    <br> 
    <table width='80%' align='center'>
    	<tr  >
    		<td>
	    		${AboutUs.title }
	    		<hr style='margin: 8px auto;border: 0.6px solid;gray'> 
    		</td>
    	</tr>
    	<tr>
    		<td >${AboutUs.contents }</td>
    	</tr>
    </table>
    <jsp:include page="weibu.jsp" />
  </body>
</html>
