<%@ page language="java"   import="java.util.*" pageEncoding="gbk"%>
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
	 <script type="text/javascript">
	 	function getface(){
			var fr= new FileReader();
			var file=document.getElementById('file').files[0];
			fr.readAsDataURL(file);
				fr.onload=function (e){
					document.getElementById('imgs').src=this.result;;
				};
		}
	 </script>
	<div class="head">
	<span class="head_lf" style='text-indent: -10em;'><a href="javascript:history.back(-1);">返回</a></span>
	<div style="text-indent: -17em">后台用户添加</div>
	</div>
	<form action='hongtu?method=managersadd' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text">
        <span>昵称</span>
        <input type="text" name='nickname' placeholder="请输入昵称" class="input">
    </div>
    <div class="text">
        <span>账号</span>
        <input type="text" name='account' placeholder="请输入账号" class="input"> 
    </div>
    <div class="text">
        <span>密码</span>
        <input type="text" name='pwd' placeholder="请输入密码" class="input">
    </div>
    <div class="text">
        <span>头像</span>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <img  id='imgs' src="" width="50px" height='50px' align="middle">
        <input type="file"  placeholder="请选择头像" id='file' name='filename'  onchange="getface();" >
    </div>
	<div class="text">
        <span>性别</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" value='M'   name='sex' checked/>男
			&nbsp;&nbsp;&nbsp;
			<input type="radio" value='F'   name='sex' />女
    </div>  
    <div class="btndl"><input type="submit" value="添加"></div>
	</div>
	</form>
</body>
</html>
