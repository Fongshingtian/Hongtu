<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宏图后台管理</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<meta http-equiv="Pragma" content="no-cache"> 
	<meta http-equiv="Cache-Control" content="no-cache"> 
	<meta http-equiv="Expires" content="0"> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<script type="text/javascript">
	var m="${message}"; 
	if(m!=""){
		alert(m); 
	}
	function docheck(){
		var account=document.f.account.value;
		var pwd=document.f.pwd.value;
		if(account==""){
			alert("请输入账号！");
		 	return false;
		}
		if(pwd==""){
			alert("请输入密码！");
		 	return false;
		}
	}
</script>
<div class="login_box">
      <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo" ><a href='Fss//Login//logining.jsp'><img style='margin: 1.5em' src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>宏图后台管理系统</p>
          </div>
          <form name='f' method="post"  action='hongtu?method=logining'>
              <input id='account' name="account" type="text"  value="账号" onfocus="this.value=''" onblur="if(this.value==''){this.value='账号'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
			  <input   name="pwd" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
			  <hr size='15' color='white'>
			 <input value="登录" style="width:100%;" onclick="return docheck();" type="submit">
          </form>
      </div>
      <div class="copyright">Powered by © 2018</div>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
