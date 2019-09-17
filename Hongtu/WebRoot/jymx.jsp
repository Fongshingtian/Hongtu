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
 		<br>
 		<center><font style='color: #5a524c;font-size: 30px;font-weight: 300'>就业明星</font></center>
<hr  style='border: 0.4px solid gray;width: 94%'>
 		<table  style='width: 83%;border: 0px solid red;' align="center">
		<tr align="center">
			<td align="center">
				<ul style='list-style: none;'>
					<c:forEach items='${courselist}' var='s'>
						<li style='float: left;width: 25%' >
							<hr style='width: 88%;border-color: #d0bfbc'>
							<table align="center" style="border: 0px solid;line-height: 24px">
								<tr ><td  colspan="2" align="center"><img src='${s.imgs}' style='border: 1px solid;' ></td></tr>
								<tr><td height="7px"></td></tr>
								<tr><td ><font style='font-size: 19px;font-weight: 500'> ${s.name }</font></td><td align="right"><font style='color:  #6193d7;font-size: 16px;font-weight: 600'>月薪: </font><font style='font-size: 16px'> ${s.salary }</font> &nbsp;&nbsp;</td></tr>
								<tr><td colspan="2"><font face="幼圆" style='color: #6193d7;font-size: 16px;font-weight: 500'>就职: </font> <font style='font-size: 16px'>  ${s.takeoffice }</font></td></tr>
								<tr><td colspan="2"><font style='color: #6193d7;font-size: 16px;font-weight: 500'>毕业: </font><font style='font-size: 16px'>  ${s.graduation}</font></td></tr>
								<tr><td colspan="2"><font style='color: #6193d7;font-size: 16px;font-weight: 500'>住址: </font><font style='font-size: 16px'>  ${s.home }</font></td></tr>
							</table>
						</li>
					</c:forEach>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
				</ul>
			</td>
		</tr>
	</table>
 		<br/><br/><br/>
 		<jsp:include page="weibu.jsp"/>
  </body>
</html>