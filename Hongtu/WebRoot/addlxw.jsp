<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'add.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
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
		<form action="ml?method=addlxw" method="post">

			内容：
			<textarea id="tt" name="nrjs" style="width: 700px; height: 300px;">
&lt;strong&gt;HTML内容&lt;/strong&gt;
</textarea>
			<br />
			验证码：
			<input type="text" name="yzm" />
			<a href="javascript:change()"><img
					src="${pageContext.request.contextPath }/yzm.jsp" id="yzm" />
				看不见，换一张</a>
			<br />
			<br />
			<input type="submit" value="添加" />
			<input type="button" value="返回" onclick="history.go(-1)" />
			${msg }
		</form>

		<script type="text/javascript">
			 function change(){
    	var src = document.getElementById("yzm").src;
    	document.getElementById("yzm").src = "${pageContext.request.contextPath }/yzm.jsp?"+Math.random();
    }
		</script>
	</body>
</html>
