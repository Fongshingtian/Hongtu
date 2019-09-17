<%@ page language="java"  import="java.util.*" pageEncoding="gbk"%>
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
	<span class="head_lf"><a href="javascript:history.back(-1)">·µ»Ø</a></span>
	Ê¦×ÊÁ¦Á¿ÐÞ¸Ä
	</div>
	<form action='hongtu?method=teachersalter' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text">
        <span>ÐÕÃû</span>
        <input type="hidden" name='id' value='${teachersinfo.id }'>
        <input type="text" name='name'  placeholder="ÇëÊäÈëÐÕÃû" class="input" value='${teachersinfo.name }'>
    </div>
    <div class="text" >
        <span >Í¼Æ¬</span>
        <img src="${teachersinfo.imgs }"id='imgs'  width="425px" height='284px' align="middle">
        <input type='hidden'  name='face' value='${teachersinfo.imgs }' >
        <input type="file" id='file' name="filename" placeholder="ÇëÑ¡ÔñÍ¼Æ¬" onchange="getface();">
    </div>
    <div class="text">
        <span>ÏêÏ¸½éÉÜ</span>
       <!-- <input type="text" name='detail' placeholder="ÇëÊäÈëÏêÏ¸½éÉÜ" class="input" value='${courseinfo.detail }'> -->
       <textarea name='detail' placeholder="ÇëÊäÈëÏêÏ¸½éÉÜ" style="height:100px;width:600px;">${teachersinfo.detail }</textarea>
    </div>
    <div class="btndl"><input type="submit" value="±£´æÐÞ¸Ä"></div>
	</div>
	</form>
</body>
</html>
