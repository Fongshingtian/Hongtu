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
	<span class="head_lf"><a href="javascript:history.back(-1)">����</a></span>
	Ԥ�������޸�����
	</div>
	<form action='hongtu?method=plansignupalter' method='post' enctype="multipart/form-data">
	<div class="zhuce">
	<div class="text">
        <span>����</span>
        <input type="hidden" name='id' value='${plansignupinfo.id }'>
        <input type="text" name='title'  placeholder="���������" class="input" value='${plansignupinfo.title }'>
    </div>
    <div class="text" >
        <span >����</span>
        <img src="${ plansignupinfo.imgs }" id='imgs' width="50px" height='50px' align="middle">
        <input type="file" id='file' name="imgs" placeholder="��ѡ��ͼƬ" onchange="getface();">
        <input type='hidden' name='face' value='${plansignupinfo.imgs }'>
    </div>
    <div class="text">
        <span>�۸�</span>
        <input type="text" name='price'  placeholder="������۸�" class="input" value='${plansignupinfo.price }'>
    </div>
    <div class="text">
        <span>��ϸ����</span>
       <!-- <input type="text" name='detail' placeholder="��������ϸ����" class="input" value='${courseinfo.detail }'> -->
       <textarea name='contents' placeholder="��������ϸ����" style="height:70px;width:400px;">${plansignupinfo.contents }</textarea>
    </div>
    <div class="btndl"><input type="submit" value="�����޸�"></div>
	</div>
	</form>
<div style="text-align:center;"> 
</div>
</body>
</html>
