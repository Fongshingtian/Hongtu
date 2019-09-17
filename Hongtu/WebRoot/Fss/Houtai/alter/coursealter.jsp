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
	<span class="head_lf" style="text-indent: -10em"><a href="javascript:history.back(-1)">·µ»Ø</a></span>
	<div style="text-indent: -17em">¿Î³Ì½éÉÜ±à¼­</div>
	<span class="head_rg"><a href="login.html">µÇÂ¼</a></span>

	</div>
	<form action='hongtu?method=coursealter' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text">
        <span>¿Î³ÌÃû×Ö</span>
        <input type="hidden" name='id' value='${courseinfo.id }'>
        <input type="text" name='course'  placeholder="ÇëÊäÈëÃû×Ö" class="input" value='${courseinfo.course }'>
   		<input type='hidden' name='face' value='${courseinfo.imgs }'>
    </div>
    <div class="text" >
        <span >·âÃæ</span>
        <img src="${ courseinfo.imgs }" id='imgs' width="50px" height='50px' align="middle">
        <input type="file" name="filename" id='file' placeholder="ÇëÑ¡ÔñÍ·Ïñ" onchange="getface();" >
    </div>
    <div class="text">
        <span>ÏêÏ¸½éÉÜ</span>
       <!-- <input type="text" name='detail' placeholder="ÇëÊäÈëÏêÏ¸½éÉÜ" class="input" value='${courseinfo.detail }'> -->
       <textarea name='detail' placeholder="ÇëÊäÈëÏêÏ¸½éÉÜ" style="height:70px;width:400px;">${courseinfo.detail }</textarea>
    </div>
    <div class="btndl"><input type="submit" value="±£´æÐÞ¸Ä"></div>
	</div>
	</form>
<div style="text-align:center;"> 
</div>
</body>
</html>
