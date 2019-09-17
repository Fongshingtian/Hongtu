<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta charset="utf-8" />
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
    <title>My JSP 'managers.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="hcss/amazeui.min.css" />
	<link rel="stylesheet" href="hcss/admin.css" />
	<script type="text/javascript"   src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<script type="text/javascript"   src="smallarAlert.js"></script>

  </head>
  
 	<body>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">联系我们</strong><small></small></div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-3">
				</div>
			</div>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form  class="am-form">
						<table   width='100%' >
							<tbody>
								<tr>
									<td><h3 style='color: teal;'>地图：</h3>${contactuslist.map}</td>
								</tr>
								<tr><td><hr color='white'></td></tr>
								<tr>
									<td><h3 style='color: teal;'>内容：</h3>
										<table border='1' bordercolor='lightgray' width='100%'>
										<tr><td><div style='text-indent: 1em;'>${contactuslist.contents }</div></td></tr>
										</table>
									<td>
								</tr> 
							</tbody>
						</table>
						<hr><center><button type="button"  class="am-btn am-btn-default" style="background:teal; "><a href='hongtu?method=getcontactusinfo&id=${contactuslist.id }'><font size="5" color='lightyellow'>  编辑</font></a></button></center>
					</form>
				</div>
			</div>
		</div>	 
	</body>
</html>
