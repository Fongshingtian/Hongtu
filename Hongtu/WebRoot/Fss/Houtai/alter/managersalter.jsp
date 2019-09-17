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
					document.getElementById('imgs').src=this.result;
				};
		}
	</script>
	<div class="head">
	<span class="head_lf" style='text-indent: -10em;'><a href="javascript:history.back(-1)">返回</a></span>	
	<div style="text-indent: -17em">成员资料修改</div>
	<span class="head_rg"><a href="login.html">登录</a></span>

	</div>
	<form action='hongtu?method=managersalter' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text" >
        <span >昵称</span>
        <input type="hidden" name='id' value='${managersinfo.id }' >
        <input type="text" name='nickname'  class="input" value='${managersinfo.nickname }'>
    </div>
    <div class="text">
        <span>账号</span>
        <input type="text" name='account' class="input" value='${managersinfo.account }'> 
    </div>
    <div class="text">
        <span>密码</span>
        <input type="text" name='pwd' class="input" value='${managersinfo.pwd }'>
    </div>
    <div class="text" >
        <span >头像</span>
        <img  id='imgs' src="${managersinfo.face }" width="50px" height='50px' align="middle">
        <input type="file" id='file'  name='filename' placeholder="请选择头像" onchange="getface();">
        <input type='hidden' name='face' value='${managersinfo.face }'>
    </div>
	<div class="text">
        <span>性别</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" value='M'   name='sex' <c:if test='${managersinfo.sex=="M" }'>checked</c:if> />男
			&nbsp;&nbsp;&nbsp;
			<input type="radio" value='F'   name='sex' <c:if test='${managersinfo.sex=="F" }'>checked</c:if> />女
    </div>  
    <div class="btndl"><input type="submit" value="保存修改"></div>
	</div>
	</form>
<div style="text-align:center;"> 
</div>
</body>
</html>
