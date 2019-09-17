<%@ page language="java"  import="java.util.*" pageEncoding="utf-8"%>
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
		<link rel="stylesheet"
			href="${pageContext.request.contextPath }/kindeditor-4.1.10/themes/default/default.css" />
		<script charset="utf-8"
			src="${pageContext.request.contextPath }/kindeditor-4.1.10/kindeditor-min.js"></script>
		<script>
		KindEditor.ready(function(K) {
			K.create('#tt', {
				allowFileManager : true
			});
		});
		
		</script>

		<!-- 导入文件 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/houtai/lxw/My97DatePicker/WdatePicker.js">
		</script>
	</head>

	<body>

	<div class="head">
	<span class="head_lf"><a href="javascript:history.back(-1);" ><h4 style="text-indent:-7em">返回</h4></a></span> 
	<h3 style="text-indent:-17em;">联系我们</h3>  
	</div>	
	<form action='hongtu?method=contactusalter&id=${contactusinfo.id }' method='post'>
		<div class="zhuce">
		<div class="text">
	        <span>地图</span>
	        <br>
	    <textarea id="tt" name="map" style="width: 90%;height:750px;margin: 0 auto;" >
		${contactusinfo.map }		
		</textarea>
	    </div>
			<div style="width:90%;margin:0 auto" id='editor'>
			<p>${contactusinfo.contents }</p>
			</div>
			<input type="hidden" id='contents' name='contents'>
	    <div class="btndl"><input type="submit" value="保存修改" onclick="getcontents();"></div>
		</div>
		</form>
	<div style="text-align:center;"> 
	</div>
	<script type="text/javascript" charset="utf-8">
		function getcontents(){
		var txt=editor.txt.html();
			document.getElementById("contents").value=txt;
		}
	</script>
	<script type="text/javascript">
		var E =window.wangEditor;
		var editor=new E('#editor');
		//让文本编译器能上传图片
		editor.customConfig.uploadImgShowBase64 =true;
		editor.create();
	</script>
</body>
</html>
