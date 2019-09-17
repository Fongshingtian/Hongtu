<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>赣州宏图软件教育</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  <!-- META DATA -->
	<meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content=""> 
	<!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css-kcjs/bootstrap.min.css"  type="text/css">
	
	<!-- Owl Carousel Assets -->
    <link href="owl-carousel-kcjs/owl.carousel.css" rel="stylesheet">
    <!-- <link href="owl-carousel-kcjs/owl.theme.css" rel="stylesheet"> -->
	
	<!-- Custom CSS -->
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css"  type="text/css">
	<!---<link href='http://fonts.googleapis.com/css?family=Asap:400,700' rel='stylesheet' type='text/css'>--->
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
    
	<style>
	body{
		margin:0;
		padding:0;
		background:#f1f1f1;
		font:70% Arial, Helvetica, sans-serif; 
		color:#555;
		line-height:150%;
		text-align:center;
	}
	a{
		text-decoration:none;
		color:#057fac;
	}
	a:hover{
		text-decoration:none;
		color:#999;
	}
	h1{
		font-size:140%;
		margin:0 20px;
		line-height:80px;	
	}
	h2{
		font-size:120%;
	}
	#container{
		margin:0 auto;
		background:#fff;
		padding-bottom:20px;
	}
	#content{margin:0 20px;}
	p.sig{	
		margin:0 auto;
		width:680px;
		padding:1em 0;
	}
	form{
		margin:1em 0;
		padding:.2em 20px;
		background:#eee;
	}
	</style>
</head>
 
<body style="background: #E6E6E6">
<jsp:include page="toubu.jsp"/>
<br/>
	<font face="幼圆" style='color: #5a524c;font-size: 30px;font-weight: 400'>课程介绍</font>
<hr  style='border: 0.4px solid gray;width: 94%'>
 <div id="s">
<table align="center"  border='0' style='width:100%;'>
	<tr>
	<td>
		<ul style='list-style: none;'>
			<c:forEach items="${courselist}" var='c'>
				<li style='width: 86px;float: left;border: 1px solid #E6E6E6;height: 510px;margin: 20px auto;'>
				</li>
				<li style='width: 340;float: left;border: 1px solid gray;height: 510px;margin: 20px auto;'>
					<table align="center" border='0' style='table-layout:fixed;height: 510px'>
						<tr height="50" align="center">
							<td><font style='font-size: x-large;color:black;'>${c.course }</font></td>
						</tr>
						<tr style='border-top: 1px solid;border-bottom: 1px solid;'>
							<td style='width: 340px;height: 314px' > <img src='${c.imgs }' style='width: 338px;height: 314px'></td>
						</tr>
						<tr >
							<td style='word-wrap:break-word;' valign="top">${c.detail }</td>
						</tr>
					</table>
				</li> 
			</c:forEach>
		</ul>
	</td>
	</tr>
</table>
<br>
<br>
<br>
<br>
</div>
<div id="container" style="background: #E6E6E6">
	<div id="content" align="center">
		<table border='2' cellspacing="0" cellpadding="0" style="width: 80%;align="center" style="background: lightgray">
			<tr style="height: 50px">
				<th colspan="6" style='text-align:center'><font size="5" face="微软雅黑">宏图软件专业课程表</font></th>
			</tr>
			<tr style="height: 25px">
				<th rowspan="7" style='text-align:center'><font face="微软雅黑">第一学期</font></th>
				<th style='text-align:center'><font face="微软雅黑">编号</font></th>
				<th style='text-align:center'><font face="微软雅黑">课程名称</font></th>
				<th style='text-align:center'><font face="微软雅黑">课程课时/天</font></th>
				<th style='text-align:center'><font face="微软雅黑">项目实训</font></th>
				<th style='text-align:center'><font face="微软雅黑">项目课时/天</font></th>								
			</tr>
			<tr style="height: 25px">
				<td>1</td>
				<td>计算机基础</td>
				<td>5</td>
				<td>PPT自我介绍</td>
				<td>1</td>								
			</tr>			
			<tr style="height: 25px">
				<td>2</td>
				<td>HTML语言</td>
				<td>6</td>
				<td>HTML个人网站</td>
				<td>2</td>								
			</tr>			
			<tr style="height: 25px">
				<td>3</td>	
				<td>C语言</td>
				<td>16</td>
				<td>贪吃蛇游戏</td>
				<td>5</td>								
			</tr>			
			<tr style="height: 25px">
				<td>4</td>
				<td>数据库基础</td>
				<td>6</td>
				<td> </td>
				<td> </td>							
			</tr>
			<tr style="height: 25px">
				<td>5</td>
				<td>JAVA语言</td>
				<td>32</td>
				<td>QQ即时通讯系统</td>
				<td>12</td>						
			</tr>
			<tr style="height: 25px">
				<td colspan="5"><font face="微软雅黑">课程课时:65天 &nbsp;&nbsp;项目课时:20天 &nbsp;&nbsp;总计:85天</font></td>							
			</tr>
			<tr style="height: 25px">
				<th rowspan="8" style='text-align:center'><font face="微软雅黑">第二学期</font></th>
				<td>6</td>
				<td>数据库高级部分</td>
				<td>9</td>
				<td> </td>
				<td> </td>								
			</tr>
			<tr style="height: 25px">
				<td>7</td>
				<td>JavaSeript</td>
				<td>4</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>8</td>
				<td>JSP</td>
				<td>24</td>
				<td>JSP项目答辩</td>
				<td>12</td>								
			</tr>			
			<tr style="height: 25px">
				<td>9</td>	
				<td>Ajax+jQuery</td>
				<td>4</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>10</td>
				<td>DIV+CSS</td>
				<td>3</td>
				<td> </td>
				<td> </td>							
			</tr>
			<tr style="height: 25px">
				<td>11</td>
				<td>数据结构</td>
				<td>6</td>
				<td> </td>
				<td> </td>						
			</tr>
			<tr style="height: 25px">
				<td>12</td>
				<td>XML</td>
				<td>4</td>
				<td> </td>
				<td> </td>						
			</tr>
			<tr style="height: 25px">
				<td colspan="5" style='text-align:center'><font face="微软雅黑">课程课时:54天 &nbsp;&nbsp;项目课时:12天 &nbsp;&nbsp;总计:66天</font></td>							
			</tr>
			<tr style="height: 25px">
				<th rowspan="8" style='text-align:center'><font face="微软雅黑">第三学期</font></th>
				<td>13</td>
				<td>Oracle</td>
				<td>13</td>
				<td> </td>
				<td> </td>								
			</tr>
			<tr style="height: 25px">
				<td>14</td>
				<td>Struts1.x和Struts2.x</td>
				<td>8</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>15</td>
				<td>Hibernate+Spring</td>
				<td>11</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>16</td>	
				<td>EasyUI</td>
				<td>8</td>
				<td>EasyUI项目实训</td>
				<td>2</td>								
			</tr>			
			<tr style="height: 25px">
				<td>17</td>
				<td>Activiti+Spring</td>
				<td>5</td>
				<td> </td>
				<td> </td>							
			</tr>
			<tr style="height: 25px">
				<td>18</td>
				<td>JFreeChart</td>
				<td>2</td>
				<td> </td>
				<td> </td>						
			</tr>
			<tr style="height: 25px">
				<td>19</td>
				<td>JasperReport</td>
				<td>2</td>
				<td>三大框架项目答辩</td>
				<td>18</td>						
			</tr>
			<tr style="height: 25px">
				<td colspan="5" style='text-align:center'><font face="微软雅黑">课程课时:49天 &nbsp;&nbsp;项目课时:20天 &nbsp;&nbsp;总计:69天</font></td>							
			</tr>
			<tr style="height: 25px">
				<th rowspan="9" style='text-align:center'><font face="微软雅黑">第四学期</font></th>
				<td>20</td>
				<td>MyBatis</td>
				<td>5</td>
				<td> </td>
				<td> </td>								
			</tr>
			<tr style="height: 25px">
				<td>21</td>
				<td>Spring MVC</td>
				<td>5</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>22</td>
				<td>BootStrap</td>
				<td>5</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>23</td>	
				<td>redis缓存技术</td>
				<td>3</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>24</td>
				<td>常见的web攻击</td>
				<td>1</td>
				<td> </td>
				<td> </td>							
			</tr>
			<tr style="height: 25px">
				<td>25</td>
				<td>Excel导入导出(POI)</td>
				<td>5</td>
				<td> </td>
				<td> </td>						
			</tr>
			<tr style="height: 25px">
				<td>26</td>
				<td>WebService+EJB+Linux</td>
				<td>5</td>
				<td>第四学期项目答辩</td>
				<td>18</td>						
			</tr>
			<tr style="height: 25px">
				<td>27</td>
				<td>就业集训</td>
				<td>24</td>
				<td> </td>
				<td> </td>						
			</tr>
			<tr style="height: 25px">
				<td colspan="5" style='text-align:center'><font face="微软雅黑">课程课时:53天 &nbsp;&nbsp;项目课时:30天 &nbsp;&nbsp;总计:83天</font></td>							
			</tr>
			<tr style="height: 25px">
				<th rowspan="9" style='text-align:center'><font face="微软雅黑">选修课程</font></th>
				<td>28</td>
				<td>JAVA高级</td>
				<td>10</td>
				<td> </td>
				<td> </td>								
			</tr>
			<tr style="height: 25px">
				<td>29</td>
				<td>ExtJs</td>
				<td>10</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>30</td>
				<td>支付宝接口 微信公众号</td>
				<td>10</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>31</td>	
				<td>CSS+DIV+HTML5+DW</td>
				<td>15</td>
				<td> </td>
				<td> </td>								
			</tr>			
			<tr style="height: 25px">
				<td>32</td>
				<td>JavaScript高级</td>
				<td>5</td>
				<td> </td>
				<td> </td>							
			</tr>
			<tr style="height: 25px">
				<td>33</td>
				<td>AngularJS框架</td>
				<td>5</td>
				<td> </td>
				<td> </td>						
			</tr>
			<tr style="height: 25px">
				<td>34</td>
				<td>Android</td>
				<td>20</td>
				<td>安卓项目答辩</td>
				<td>10</td>						
			</tr>
			<tr style="height: 25px">
				<td>35</td>
				<td>软件测试</td>
				<td>16</td>
				<td> </td>
				<td> </td>						
			</tr>																																									
		</table>		
	</div>
</div>
	<jsp:include page="weibu.jsp"/>
</body>
</html>