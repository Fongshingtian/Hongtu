<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>宏图后台管理系统</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link href="hcss/Site.css" rel="stylesheet" type="text/css" />
		<link href="hcss/zy.layout.css" rel="stylesheet" />
		<link href="hcss/zy.form.css" rel="stylesheet" />
		<link href="hcss/font-awesome.min.css" rel="stylesheet" />
		<style type="text/css">
			a{
				text-decoration: none;
				color: #333;
			}
			.headerlitooleulsubitem_gray {
				background-Color: White;
				position: absolute;
				border-left: 1px solid #BCD4E5;
				border-right: 1px solid #BCD4E5;
				border-bottom: 1px solid #BCD4E5;
				box-shadow: 0px 0px 5px #BCD4E5;
				width: 230px;
				margin-left: -170px;
				color: Black;
				display: none;
			}
			
			.headerlitooleulsubitem_red {
				background-Color: White;
				position: absolute;
				border-left: 1px solid #E5BCD4;
				border-right: 1px solid #E5BCD4;
				border-bottom: 1px solid #E5BCD4;
				box-shadow: 0px 0px 5px #E5BCD4;
				width: 230px;
				margin-left: -170px;
				color: Black;
				display: none;
			}
			
			.headerlitooleulsubitem_gray>li,
			.headerlitooleulsubitem_red>li {
				height: 45px;
				background-color: White;
				padding: 0px 10px;
				border-bottom: 1px solid #E4ECF3;
				font-size: 14px;
				line-height: 26px;
			}
			
			.headerlitoolelisubitemtitle_gray {
				height: 35px !important;
				line-height: 35px !important;
				background-color: #ECF2F7 !important;
				margin: 0px !important;
				color: #8090A0 !important;
				font-size: 14px;
				font-weight: bold;
				border-bottom: 1px solid #BCD4E5 !important;
			}
			
			.headerlitoolelisubitemtitle_red {
				height: 35px !important;
				line-height: 35px !important;
				background-color: #F7ECF2 !important;
				margin: 0px !important;
				color: #B471A0 !important;
				font-size: 14px;
				font-weight: bold;
				border-bottom: 1px solid #E5BCD4 !important;
			}
			
			.headerlitooleulsubitem_gray>li:hover {
				background-Color: #F4F9FC;
			}
			
			.headerlitooleulsubitem_red>li:hover {
				background-color: #FCF4F9;
			}
			
			.ulsubitemitems>li {
				float: left;
				height: 20px;
				font-size: 13px;
				font-weight: normal !important;
				color: #555 !important;
			}
			
			.ulsubitemitems>li:last-child {
				clear: both;
				width: 100%;
				height: 10px;
				margin-top: 8px;
				background-color: #DADADA;
			}
			
			.headerlitools_info {
				background-color: #0a318d;
				height: 45px;
				padding: 0px 10px;
				width: 135px;
			}
			
			.headeruserface {
				background-image: url('/content/resources/images/logo.png');
				width: 40px;
				height: 40px;
				background-color: white;
				margin: 2px 10px 2px 2px;
				border-radius: 20px;
				float: left;
			}
			
			.headerlitools_ulinfo {
				background-Color: white;
				border-left: 1px solid #D1D1D1;
				border-right: 1px solid #D1D1D1;
				border-bottom: 1px solid #D1D1D1;
				box-shadow: 0px 0px 5px #D1D1D1;
				width: 160px;
				margin-left: -20px;
				color: Black;
				display: none;
			}
			
			.headerlitools_ulinfo>li {
				height: 35px;
				background-color: White;
				padding: 0px 10px;
				font-size: 14px;
				line-height: 36px;
			}
			
			.headerlitools_ulinfo>li:hover {
				background-Color: #FEE188;
			}
			
			.dvcontent {
				padding: 0px 20px;
				margin: 45px auto 0px auto;
				overflow: auto;
			}
			
			.dvpagerecord {
				padding: 6px 12px;
				background-color: #EAEFF2;
				color: #2283C5;
				float: left;
				border: 1px solid #D9D9D9;
				text-decoration: underline;
				font-size: 14px;
				cursor: pointer;
			}
			
			.dvpagerecord:hover {
				cursor: pointer;
			}
			
			.dvpagerecord:hover i {
				text-decoration: underline;
			}
			
			.ulpageRecord {
				max-width: 165px;
				float: left;
				white-space: nowrap;
				overflow: auto;
				margin: 0px;
				padding: 0px;
			}
			
			.ulpageRecord li {
				margin: 0px;
				padding: 6px 12px;
				background-color: #EAEFF2;
				color: #2283C5;
				display: inline-block;
				font-size: 14px;
				border: 1px solid #D9D9D9;
			}
			
			.ulpageRecord li:hover {
				text-decoration: underline;
				cursor: pointer;
			}
			
			.currentPage {
				background-color: #2468a9 !important;
				color: white !important;
			}
			
			#warn {
				width: 300px;
			}
			
			#warn tr {
				width: 300px;
				height: 20px;
			}
			
			#warn tr td {
				width: 90px;
				height: 20px;
				text-align: center;
			}
			
			iframe {
				border: none;
			}
		</style>
		<link href="hcss//zy.menu.css" rel="stylesheet" />
		<script type="text/javascript"> 
			function checklogin(){
				var m="${managers}"
				if(m==""){
				window.location.href='Fss//Login//logining.jsp';
				}
			}
		</script>
	</head>

	<body onload="checklogin();">
		
		<div class="dvheader">
			<div class="dvheadertools">
				<span class="headerspantitle">宏图软件后台管理</span>
				<ul class="headerultools" style='text-indent: -10em;'>
					<li >
						<div><img style="vertical-align: middle" src='${managers.face }' width='40px' height='40px'> ${managers.nickname } </div>
					</li>
				</ul>
			</div>
		</div>
		<div class="dvcontent">

			<ul class='ulleftmenu' style="border-right: 1px solid #ddd;">

				<li class="limenuitem">
					<i class="icon-cog menuicon"></i>系统菜单<b class="arrow icon-angle-down arrow-down"></b>
					<ul class="ulleftsubitems">
						<c:if test="${managers.id==1}">
						<a href="hongtu?method=managersshow" target="right">
							<li>后台成员</li>
						</a>
						</c:if>
						<a href="hongtu?method=aboutusshow" target="right">
							<li>关于我们</li>
						</a>
						<a href="hongtu?method=courseshow" target="right">
							<li>课程介绍</li>
						</a>
						<a href="hongtu?method=newsshow" target="right">
							<li>新闻动态</li>
						</a>
						<a href="hongtu?method=studentsshow" target="right">
							<li>就业明星</li>
						</a>
						<a href="hongtu?method=teachersshow" target="right">
							<li>师资力量</li>
						</a>
						<a href="hongtu?method=messageboardshow" target="right">
							<li >留言板块</li>
						</a>
						<a href="hongtu?method=messagereplyshow" target="right">
							<li >留言回复</li>
						</a>
						<a href="hongtu?method=plansignupshow" target="right">
							<li >预定报名</li>
						</a>
						<a href="hongtu?method=signupshow" target="right">
							<li >报名资料</li>
						</a>
						<a href="hongtu?method=activityshow" target="right">
							<li >学校活动</li>
						</a>
						<a href="hongtu?method=environmentshow" target="right">
							<li >学校环境</li>
						</a>
						<a href="hongtu?method=graduationshow" target="right">
							<li >学生毕业</li>
						</a>
						<a href="hongtu?method=contactusshow" target="right">
							<li >联系我们</li>
						</a>
					</ul>
				</li>
			</ul>  
			<div style="position: absolute; left: 191px; right: 0px; ">
				<iframe src="${pageContext.request.contextPath }//Fss//Houtai//welcome.jsp" scrolling="no"  width="100%" height="1600" name="right" border="none"  ></iframe>
			</div>
		</div>
		<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/plugs/Jqueryplugs.js" type="text/javascript"></script>
		<script src="js/_layout.js"></script>
 
	</body>

</html>
