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
  
  <body style='line-height: 1.4295'>
    <jsp:include page="toubu.jsp" />
    
    <br/>
    <center><font face="幼圆" style='color: #5a524c;font-size: 30px;font-weight: 400'>留言板</font></center>
		<hr  style='border: 0.1px solid gray;width: 94%'>
	<table width="63%" border="0" align="center">
		<tr valign="bottom">
			<td><font face="微软雅黑" size="5" color='black' style="font-weight: 200;">最新留言（${count }）</font></td>
			
		</tr>
		<tr valign="middle">
			<td><hr style="border-color:white;margin: 10px "><hr style="border-color:gray;margin: 1px ">
			<ul style='list-style: none;'>
			<c:forEach items='${message}' var='m'>
			<li>	
				<br>
				<table width='100%'   align='center' border='0' style='border-bottom: 1px solid gray;line-height: 25px'>	
					<tr height="35px" valign="top">
					<td rowspan="3" style='width:90px;height: 80px' ><img src='1.png' style='width:80px;height: 80px;border: 1px solid lightgray;' ></td>
						<td >
							<font  style='font-weight: 400;font-size: 24px;color: #3e3533;font-family: inherit' >${m.key.nickname }</font>
						</td>
					</tr>
					<tr>
						<td  valign="middle" height="30px">
							<img src='time.png' style='width: 14px;height: 14px;' align="middle"><font style='font-size: small;color: gray'>${m.key.ctime }</font>
						</td>
					</tr>
					<tr >
					<td>
						<font  color="black" style='font-family: "Helvetica Neue",Helvetica,Arial,sans-serif' >
							${m.key.contents }
							&nbsp;&nbsp; 
						</font>
						<br><br>
					</td>
					</tr>
			<c:forEach items="${m.value}" var='v'>
					<tr>
						<td></td>
						<td style='border-left: 2.5px solid lightgray;'> 
						<hr style='margin: 4px auto;border-color: white'>
							<font face="幼圆" style='color:#5a0b1e;font-weight: bolder;'>
								&nbsp;&nbsp; 管理员
							</font>
							<font style='color: #ec8428'>
								${v.nickname }
							</font>
							&nbsp; 回复：
							<font  color="black" style='font-family: "Helvetica Neue",Helvetica,Arial,sans-serif' >
							${v.contents }
							</font>
						</td>
					</tr>
					<tr>
						<td></td>
						<td height="30px" style='border-left: 2.5px solid lightgray;border-bottom:2px solid lightgray ;border-bottom-style: dashed; '>
							<font style='font-size: small;color: gray'>
							&nbsp;&nbsp;&nbsp;&nbsp;  ${v.ctime }
							</font>
						</td>
					</tr>
			</c:forEach>
			<tr><td colspan="2"><hr style='margin: 5px auto;border-color: white'></td></tr>
				</table>
			</li>
			</c:forEach>
			<li>
			</li>
			</ul>
			</td>
		</tr>
	</table><br>
	<hr style="border-color: lightgray;margin: 1px "> 
	<br>
    <jsp:include page="weibu.jsp" />
  </body>
</html>
