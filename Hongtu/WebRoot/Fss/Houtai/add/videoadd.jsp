<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>
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
	</head>

	<body>
	<div class="head">
	<span class="head_lf"><a href="javascript:history.back(-1);">返回</a></span>
	在线视频新增
	</div>	<form action='hongtu?method=videoadd' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text">
        <span>标题</span>
        <input type="text" name='title' placeholder="请输入标题" class="input">
    </div>
    <div class="text">
        <span>视频</span>
        <input type="file" name="video" placeholder="请选择视频" >
    </div>
    <div class="btndl"><input type="submit" value="添加"></div>
	</div>
	</form>
</body>
</html>

