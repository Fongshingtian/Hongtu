<%@ page language="java"   import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
	<link rel="stylesheet" href="hcss/gongyong.css">
	<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
	
    <script type="text/javascript" src='js/jquery-1.10.2.min.js'></script>
    <script type="text/javascript" src='bootstrap-3.3.0/js/bootstrap.min.js'></script>
    <script type="text/javascript" src='//unpkg.com/wangeditor/release/wangEditor.min.js'></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/wangEditor-3.1.1//release//wangEditor.js"> </script>
	</head>

	<body>
	<div class="head">
	<span class="head_lf"><a href="javascript:history.back(-1);" ><h4 style="text-indent:-7em">返回</h4></a></span> 
	<h3 style="text-indent:-17em;">留言回复</h3>  
	</div>	
	<form action='hongtu?method=messagereplyadded&rid=${rid }' method='post'>
		<div class="zhuce">
		<div class="text">
	        <span>内容</span>
	        <input type="text" name='contents' placeholder="请输入内容" class="input">
	    </div>
	    <div class="btndl"><input type="submit" value="回复"></div>
		</div>
		</form>
</body>
</html>