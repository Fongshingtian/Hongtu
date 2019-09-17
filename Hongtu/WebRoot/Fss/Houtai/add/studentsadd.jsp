<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta />
    <base href="<%=basePath%>">
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
	<span class="head_lf"><a href="javascript:history.back(-1);">返回</a></span>
	就业明星
	</div>	
	<form action='hongtu?method=studentsadd' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text">
        <span>姓名</span>
        <input type="text" name="name" placeholder="请输入姓名"  class="input">
    </div>
    <div class="text">
        <span>图片</span>
         &nbsp;&nbsp;&nbsp;&nbsp;
        <img  id='imgs' src="" width="50px" height='50px' align="middle">
        <input type="file" id='file' name="imgs" placeholder="请选择图片" onchange="getface();">
    </div>
    <div class="text">
        <span>就职公司</span>
        <input type="text" name="takeoffice" placeholder="请输入公司" class="input">
    </div>
     <div class="text">
        <span>月薪</span>
        <input type="text" name="salary" placeholder="请输入月薪" class="input">
    </div>
      <div class="text">
        <span>住址</span>
        <input type="text" name="home" placeholder="请输入住址" class="input" >
    </div>
      <div class="text">
        <span>毕业学校</span>
        <input type="text" name="graduation" placeholder="请输入学校" class="input" >
    </div>
    <div class="btndl"><input type="submit" value="添加"></div>
	</div>
	</form>
</body>
</html>

