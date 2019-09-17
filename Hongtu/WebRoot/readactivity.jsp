<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${read.title }</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <script type="text/javascript">
  	function doover(t){
  		document.getElementById(t).style='background-color:lightgray;';
  	}
  	
  	function doout(t){
  		document.getElementById(t).style='background-color:white;';
  	}
  </script>
    <jsp:include page="toubu.jsp"/><br/>	
    	<table align='center' border='0' width='75%'>
    		<tr><td style="font-size: x-large;color:black;">${read.title }<hr  style="border: 0.5px solid gray;margin: 0.5em auto"></td></tr>
    		<tr align='center'><td><img src="${read.imgs }" style="width: 1000px;height:800px"></td></tr>
    		<tr align='center'><td><div style='margin: 1em;'>${read.title }</div></td></tr>
    		<tr style='text-align: center'>
    			<td  >
    				<ul style='list-style: none;'>
    				<li style="float: left;width: 49%;">
    				<table id='t1' onmouseout="doout('t1');" onmouseover="doover('t1');" border='2' align="right"><tr><td><a style=" font-size: large;color:black" href='qt?method=lastactivity&id=${read.id }'>上一个</a></td></tr></table>
    				</li>
    				<li style="float: left;width: 2%;">
    					&nbsp;
    				</li>
    				<li style="float: left;width: 49%">
    				<table id='t2' onmouseout="doout('t2');" onmouseover="doover('t2');"  border='2' ><tr ><td ><a  style=" font-size: large;color:black"  href='qt?method=nextactivity&id=${read.id }'>下一个</a></td></tr></table>
    				</li>
    				</ul>
    			</td>
    		</tr>
    	</table>
    <br/><br/><br/><jsp:include page="weibu.jsp"/>
  </body>
</html>
