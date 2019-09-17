<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>赣州宏图软件教育官网</title>
<link rel="icon" href="images/logo.ico" type="images/x-ico" />
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--// Meta tag Keywords -->
<!-- css files -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/carousel.css" type="text/css" rel="stylesheet" media="all"> 
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<!-- gallery -->
<link href="css/lsb.css" rel="stylesheet" type="text/css">
<!-- //gallery -->
<!-- /fonts -->
<link href="http://fonts.googleapis.com/css?family=Montserrat+Alternates:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic" rel="stylesheet">
<!-- //fonts -->

<link href="css-lyb/style.css" rel='stylesheet'/>


<!-- //css files -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>

<!-- //js -->
<script type="text/javascript">
	function tomain(){
		window.location.href="qt?method=main";
	}
	
	function docheck(){
		var nickname=document.messages.nickname.value;
		var tel=document.messages.tel.value;
		var email=document.messages.email.value;
		var contents=document.messages.contents.value;
		if(nickname==""){
			alert('昵称不能为空！');
			return false;
		}
		if(email==""){
			alert('邮箱不能为空！');
			return false;
		}
		if(tel==""){
			alert('电话不能为空！');
			return false;
		}
		if(contents==""){
			alert('内容不能为空！');
			return false;
		}
		alert("留言信息已提交，待审核中。");
	}
</script>
</head>
<body >
<style>a{TEXT-DECORATION:none}</style>
<jsp:include page="toubu.jsp"/>
<!--//关于我们 -->
<!--/experience overview -->
<div class="w3-faculty-ex" style='margin: -55px auto'>
	<table   style='width: 90%;border: 0px solid red;height: 400px;' align="center" >
		<tr >
			<td width="66%" valign="top" style='border-bottom: 1px solid;'>
				<font style='font-size: 20px;color: #343130'>关于我们</font>
			</td>
			<td style='width: 50px;border-bottom: 1px solid;'>
				<a href='qt?method=czgywm'><img align="top" src='more.png' style='width: 44px;height: 12px;'></a>
			</td>
			<td style="width: 20px;border-right: 1px solid lightgray;border-style: dashed"></td>
			<td rowspan="2" >
				<table border='2'>
					<tr>
					<td style="width: 20px;"></td>
						<td style='line-height: 25px;letter-spacing: 0.8px'>
							<font style='font-size: 23px;color: #343130;font-weight: 400;'>为什么选择宏图？</font>
							<hr style='border: 0.6px solid #bdb4b2;margin: 13px;'>
							<font style='font-size: 16px;color: teal;font-weight: 600;'>一流的专家师资</font>
							<br><span><i class="fa fa-check" aria-hidden="true"></i></span>宏图软件教育的老师都是具有5年以上项目经验的资深专家。
							<br><span><i class="fa fa-check" aria-hidden="true"></i></span>资深软件专家手把手小班实战教学，老师全程细心辅导。
							
							<br><br><br><br><font style='font-size: 16px;color: teal;font-weight: 600;'>手把手教学，理论+大量上机实战</font>
							<br><span><i class="fa fa-check" aria-hidden="true"></i></span>宏图软件学院采用小班授课，一个班在30人之内，每个班配备一名专业老师，实现手把手教学。
							<br><span><i class="fa fa-check" aria-hidden="true"></i></span>每天2个小时的理论课+6个小时以上的上机实战。
							<br><span><i class="fa fa-check" aria-hidden="true"></i></span>宏图实行精英化教学，学习热门、实用、高端的软件开发技术与思想。
							<br><br><br><br><font style='font-size: 16px;color: teal;font-weight: 600;'>就业保障</font>
							<br><span><i class="fa fa-check" aria-hidden="true"></i></span>
							入学即签定就业保障协议，保障100%对口就业；并且就业工资在4000元以上，否则退还全部学费，并提供终身就业服务。
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2"><div style='margin: -19px auto'>${aboutus.contents }</div></td>
			<td style="width: 20px;border-right: 1px solid lightgray;border-style: dashed"></td>
		</tr>
	</table></div>
<!--//关于我们 -->
<br>
<hr  style='border: 0.6px solid teal;'>
<!--//课程介绍 -->
<div class="about all_pad w3ls" style='margin: -50px'>
	<div class="container">
		<table width="100%">
			<tr>
			<td width="33.3%">
			</td>
			<td width="33.3%" align="center">
			<font style='color: teal;font-size: 30px;font-weight: 400'>课程介绍</font>
			 </td>
			 <td width="33.3%">
			 	<a href="qt?method=czkcjs"><img align="top" src='more.png' style='width: 44px;height: 12px;'></a>
			</td>
			</tr>
		</table>
		<hr  >
		<div class="ser-top-grids"  style='margin: 55px'>
			<div class="col-md-4 ser-grid wow flipInY" data-wow-duration="1.5s" data-wow-delay="0s">
				<div class="con-left text-center">
					<div class="spa-ico"><span><i class="fa fa-book" aria-hidden="true"></i></span></div>
					<h5><font face="微软雅黑">${course1.course }</font></h5>
					<p><font face="微软雅黑">${course1.detail }</font></p>
					
				</div>
			</div>
			<div class="col-md-4 ser-grid wow flipInY" data-wow-duration="1.5s" data-wow-delay="0s">
				<div class="con-left text-center">
					<div class="spa-ico"><span><i class="fa fa-book" aria-hidden="true"></i></span></div>
					<h5><font face="微软雅黑">${course2.course }</font></h5>
					<p><font face="微软雅黑">${course2.detail }</font></p>
					
				</div>
			</div>
			<div class="col-md-4 ser-grid wow flipInY" data-wow-duration="1.5s" data-wow-delay="0s">
				<div class="con-left text-center">
					<div class="spa-ico"><span><i class="fa fa-book" aria-hidden="true"></i></span></div>
					<h5><font face="微软雅黑">${course3.course }</font></h5>
					<p><font face="微软雅黑">${course3.detail }</font></p>
					
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--//课程介绍 -->
<hr  style='border: 0.4px solid teal;'>
<br>
<!-- 就业明星 -->
<table width="100%">
			<tr>
			<td width="33.3%">
			</td>
			<td width="33.3%" align="center">
			<font style='color: teal;font-size: 30px;font-weight: 400'>就业明星</font>
			 </td>
			 <td width="33.3%">
			 	<a href="qt?method=czjymx"><img align="top" src='more.png' style='width: 44px;height: 12px;'></a>
			</td>
			</tr>
		</table>
	<table  style='width: 83%;border: 0px solid red;' align="center">
		<tr align="center">
			<td align="center">
				<ul style='list-style: none;'>
					<c:forEach items='${studentslist}' var='s'>
						<li style='float: left;width: 25%' >
							<hr style='width: 88%;border-color: #d0bfbc'>
							<table align="center" style="border: 0px solid;line-height: 24px">
								<tr ><td  colspan="2" align="center"><img src='${s.imgs}' style='border: 1px solid;' ></td></tr>
								<tr><td height="7px"></td></tr>
								<tr><td ><font style='font-size: 19px;font-weight: 500'> ${s.name }</font></td><td align="right"><font style='color:  #6193d7;font-size: 16px;font-weight: 600'>月薪: </font><font style='font-size: 16px'> ${s.salary }</font> &nbsp;&nbsp;</td></tr>
								<tr><td colspan="2"><font face="幼圆" style='color: #6193d7;font-size: 16px;font-weight: 500'>就职: </font> <font style='font-size: 16px'>  ${s.takeoffice }</font></td></tr>
								<tr><td colspan="2"><font style='color: #6193d7;font-size: 16px;font-weight: 500'>毕业: </font><font style='font-size: 16px'>  ${s.graduation}</font></td></tr>
								<tr><td colspan="2"><font style='color: #6193d7;font-size: 16px;font-weight: 500'>住址: </font><font style='font-size: 16px'>  ${s.home }</font></td></tr>
							</table>
						</li>
					</c:forEach>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
					<li style='float: left;width: 25%'>
						<hr style='width: 88%;border-color: #d0bfbc'>
					</li>
				</ul>
			</td>
		</tr>
	</table>
<!-- //就业明星 -->
	<script src="js/lsb.min.js"></script>
	<script>
	$(window).load(function() {
		  $.fn.lightspeedBox();
		});
	</script>

<!-- //师资力量 -->
<hr  style='border: 0.4px solid teal;'>
<br>
 <table width="100%">
			<tr>
			<td width="33.3%">
			</td>
			<td width="33.3%" align="center">
			<font style='color: teal;font-size: 30px;font-weight: 400'>师资力量</font>
			 </td>
			 <td width="33.3%">
			 	<a href="qt?method=czszll"><img align="top" src='more.png' style='width: 44px;height: 12px;'></a>
			</td>
			</tr>
	</table>
<hr style='width: 88%'>
	<table  style='width: 83%;border: 0px solid red;' align="center">
		<tr align="center">
			<td align="center">
				<ul style='list-style: none;'>
					<c:forEach items='${teacherslist}' var='s'>
						<li style='float: left;width: 50%;' >
							<table align="center"  style='width: 91%;'>
								<tr><td  align="center"><font style='font-size: 20px;'>${s.name }</font>
									 <hr style='border: 0.6px solid #d0bfbc;black;width: 100%;margin: 15px auto'> 
								</td></tr>
								<tr ><td style="height: 370px" align="center"><img src='${s.imgs}' style='border: 0px solid;' ></td></tr>
							</table>
							<br><br><br>
						</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
<!-- //师资力量 -->
<hr  style='border: 0.4px solid teal;'>
 <!--学生就业一览表  -->

	<br>
	<c:forEach items="${graduationlist}" var="a">
	<br>
	<table style="border: 1px solid #51cdd4;width: 83%;margin: 0 auto;">
			<tr style='background:#51cdd4;height: 37px;color:white;'> 
				<td style='vertical-align:middle'> &nbsp;&nbsp;${a.title }</td>
			</tr>
			<tr style='text-align: center;'>
				<td><br><img src="${a.imgs}"style='width:940px;'><br><br></td>
			</tr>
	</table>
	<br>
	</c:forEach>
	<br>
	<table style="border: 1px solid #51cdd4;width: 83%;margin: 0 auto;">
		<tr style='background:#51cdd4;height: 34px;color:white;'> 
			<td style='vertical-align:middle'> &nbsp;&nbsp;学校活动展示</td>
		</tr>
		<tr>
			<td>
			<ul>
				<br>
				<c:forEach items="${activitylist}" var="a">
				<li style="float: left;width: 20%">
					<table style="border: 0px solid #3586f2;width: 90%;margin: 0 auto;">
					<tr style='text-align: center;'>
						<td > <br><a href='qt?method=readactivity&id=${a.id }' target="_Blank"><img src="${a.imgs}" style='width: 177px;height:134px;'></a></td>
					</tr>
					<tr style='text-align: center;font-size: large'>
						<td> <br><a style="color: black" href='qt?method=readactivity&id=${a.id }' target="_Blank"><font style='font-weight: 500'>${a.title }</font></a></td>
					</tr>
					</table>
					<br>
				</li>
				</c:forEach>
			</ul>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<table style="border: 1px solid #51cdd4;width: 83%;margin: 0 auto;">
		<tr style='background:#51cdd4;height: 32px;color:white;'> 
			<td style='vertical-align:middle'> &nbsp;&nbsp;学校环境展示</td>
		</tr>
		<tr>
			<td>
			<ul>
				<br>
				<c:forEach items="${environmentlist}" var="a">
				<li style="float: left;width: 20%;border: 0px solid;">
					<table style="border: 0px solid #3586f2;width: 90%;margin: 0 auto;">
					<tr style='text-align: center;'>
						<td > <br><a href='qt?method=readenvironment&id=${a.id }' target="_Blank"><img src="${a.imgs}" style='width: 177px;height:134;'></a></td>
					</tr>
					<tr style='text-align: center;font-size: large'>
						<td> <br><a style="color: black" href='qt?method=readenvironment&id=${a.id }' target="_Blank"><font style='font-weight: 500'>${a.title }</font></a></td>
					</tr>
					</table>
					<br>
				</li>
				</c:forEach>
			</ul>
			</td>
		</tr>
	</table>
	<br><br>
<hr  style='border: 0.4px solid teal;'>
	<br>
<!--//留言板 -->
		<table width="100%">
			<tr>
			<td width="33.3%">
			</td>
			<td width="33.3%" align="center">
			<font style='color: teal;font-size: 30px;font-weight: 400'>留言板</font>
			 </td>
			 <td width="33.3%">
			 	<a href="qt?method=czlyb"><img align="top" src='more.png' style='width: 44px;height: 12px;'></a>
			</td>
			</tr>
	</table>
<div class="login-01">
			<form name='messages' action='hongtu?method=messageboardadd' method='post'>
				<ul>
				<li class="first">
					<a class=" icon user"></a><input type="text" class="text" placeholder="请输入昵称" name="nickname" >
					<div class="clear"></div>
				</li>
				<li class="first">
					<a class=" icon email"></a><input type="text" class="text" placeholder="请输入邮箱" name="email">
					<div class="clear"></div>
				</li>
				<li class="first">
					<a class=" icon phone"></a><input type="text" class="text" placeholder="请输入电话" name="tel">
					<div class="clear"></div>
				</li>
				<li class="second">
					<a class=" icon msg"></a><textarea value="Message" name="contents" placeholder="请输入内容"></textarea>
					<div class="clear"></div>
				</li>
			</ul>
			<input type="submit" onClick="return docheck();" value="提交留言" >
			<div class="clear"></div>
		</form>
</div>
	<br>
	<jsp:include page="weibu.jsp"/>
	</body>
	</html>
	