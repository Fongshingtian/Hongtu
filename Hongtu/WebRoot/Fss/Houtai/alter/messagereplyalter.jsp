<%@ page language="java"   import="java.util.*" pageEncoding="utf-8"%>
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
	<span class="head_lf"><a href="javascript:history.back(-1)">返回</a></span>
	留言回复内容修改
	</div>
	<form action='hongtu?method=messagereplyalter' method='post'>
	<div class="zhuce">
	<div class="text">
        <span>昵称</span>
        <input type="hidden" name='id' value='${messagereplyinfo.id }'>
        <input type="text" name='nickname'  placeholder="请输入昵称" class="input" value='${messagereplyinfo.nickname }'>
    </div>
    <div class="text" >
        <span >所回复ID</span>
        <input type="text" name="rid" placeholder="请输入ID" class="input"  value='${messagereplyinfo.rid }'>
    </div>
    <div class="text" >
        <span >邮箱</span>
        <input type="text" name="email" placeholder="请输入邮箱" class="input"  value='${messagereplyinfo.email }'>
    </div>
    <div class="text">
        <span>内容</span>
       <input type="text" name='contents' placeholder="请输入内容" class="input" value='${messagereplyinfo.contents }'>
    </div>
     <div class="text">
        <span>创建时间</span>
       <input type="text" name='ctime' placeholder="请输入时间" class="input" value='${messagereplyinfo.ctime }'>
    </div>
     <div class="text">
        <span>电话</span>
       <input type="text" name='tel' placeholder="请输入号码" class="input" value='${messagereplyinfo.tel }'>
    </div>
    <div class="btndl"><input type="submit" value="保存修改"></div>
	</div>
	</form>
<div style="text-align:center;"> 
</div>
</body>
</html>
