<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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




<!-- //css files -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>

<!-- //js -->
<script type="text/javascript">
	function tdoover(id){
		document.getElementById(id).style='color:lightblue;font-weight:900;font-size:x-large';
	}
	function tdoout(id){
		document.getElementById(id).style='color:white;font-weight:500;font-size:large';
	}
	function tdoover2(){
		document.getElementById('ht').style='color:lightblue;font-weight:900;font-size:39px';
	}
	function tdoout2(){
		document.getElementById('ht').style='font-size: xx-large;color: white;';
	}
</script>
</head>
<body>
<style>a{TEXT-DECORATION:none}</style>
<section class="banner-header" id="home">
		<!--header-->
		<div class="header" >
			<nav class="navbar navbar-default">
				<div class="container">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div style='font-size:large ;font-weight: 500; '>
						<table  width="100%">
						<tr><td>
						<ul  style="list-style: none;">
							<li style="float: left;width: 10%;">
								<table style='width: 95%'>
									<tr>
										<td align="center"><a style='color: white; ' id='course' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);"  href="qt?method=czkcjs" >课程介绍</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 10%;"> 
								<table  style='width: 95%'>
									<tr>
										<td align="center"><a id='students' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white' href="qt?method=czjymx">就业明星</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 10%;">
								<table  style='width: 95%'>
									<tr>
										<td align="center"><a id='teachers' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white'  href="qt?method=czszll" >师资力量</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left;width: 10%; ">
								<table  style='width: 95%'>
									<tr>
										<td align="center"><a id='news' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white' href="qt?method=czxwdt" >新闻动态</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 20%;margin: -12px auto">
								<table  style='width: 95%'>
									<tr>
										<td align="center"><a onmouseover="tdoover2();" onmouseout="tdoout2();" href="main.jsp"><font id="ht"  style='font-size: xx-large;color: white;'>宏图软件</font></a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 10%;">
								<table style='width: 95%'>
									<tr>
										<td align="center"><a id='messageboard' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white' href="qt?method=czlyb"  >留言板块</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 10%;">
								<table  style='width: 95%'>
									<tr>
										<td align="center"><a  id='aboutus' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white' href="qt?method=czgywm"  >关于我们</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 10%;">
								<table  style='width: 95%'>
									<tr>
										<td align="center"><a id='contactus' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white' href="qt?method=czlxwm"  >联系我们</a></td>
									</tr>
								</table>
							</li>
							<li style="float: left; width: 10%;">
								<table style='width: 95%'>
									<tr>
										<td align="center"><a id='psignup' onmouseout="tdoout(this.id);" onmouseover="tdoover(this.id);" style='color: white' href="qt?method=czydbm"  >预定报名</a></td>
									</tr>
								</table>
							</li>
						</ul>
						</td>
						</tr>
						</table>
						</div>
				</div>
			</nav>
	</div>
		<!--//header-->
<!-- banner -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1" class=""></li>
			<li data-target="#myCarousel" data-slide-to="2" class=""></li>
			<li data-target="#myCarousel" data-slide-to="3" class=""></li>
			<li data-target="#myCarousel" data-slide-to="4" class=""></li> 
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active"> 
				<div class="container">
					<div class="carousel-caption">
						<h2></h2>
						<p></p>
						<!-- <button class="btn btn-primary" data-target="#myModal" data-toggle="modal"></button> -->
					</div>
				</div>
			</div>
			<div class="item item2"> 
				<div class="container">
					<div class="carousel-caption">
						<h3></h3>
						<p></p>
						<!-- <button class="btn btn-primary" data-target="#myModal" data-toggle="modal"></button> -->
					</div>
				</div>
			</div>
			<div class="item item3"> 
				<div class="container">
					<div class="carousel-caption">
						<h3></h3>
						<p></p>
						<!-- <button class="btn btn-primary" data-target="#myModal" data-toggle="modal"></button> -->
					</div>
				</div>
			</div>
			<div class="item item4"> 
				<div class="container">
					<div class="carousel-caption">
						<h3></h3>
						<p></p>
						<!-- <button class="btn btn-primary" data-target="#myModal" data-toggle="modal"></button> -->
					</div>
				</div>
			</div>
			<div class="item item5"> 
				<div class="container">
					<div class="carousel-caption">
						<h3></h3>
						<p></p>
						<!-- <button class="btn btn-primary" data-target="#myModal" data-toggle="modal"></button> -->
					</div>
				</div>
			</div> 
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
		<!-- The Modal -->
		<div id="myModal" class="modal wthree-modal" tabindex="-1"> 
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<span class="close" data-dismiss="modal" >&times;</span>
					<h3>Education portal</h3>
				</div>
				<div class="col-md-6 modal-img">
					<img src="images/ban1.jpg" class="img-responsive" alt="w3layouts" title="w3layouts">
				</div>
				<div class="col-md-6 modal-text">
					<p class="banner-p1">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed nisl ultricies, dignissim mi at, dignissim dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque tempor ultrices nisi eget dictum. Integer quis massa ut elit laoreet consectetur. Sed rhoncus erat tellus, at commodo erat mattis eu.</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>		
    </div> 
	<!-- //banner -->
</section>	