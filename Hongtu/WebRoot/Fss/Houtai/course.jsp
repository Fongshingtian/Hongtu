<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="hcss/amazeui.min.css" />
	<link rel="stylesheet" href="hcss/admin.css" />
	<script type="text/javascript"   src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<script type="text/javascript"   src="smallarAlert.js"></script>

  </head>
  
 	<body>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">课程介绍</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"><a href='${pageContext.request.contextPath}//Fss//Houtai//add//courseadd.jsp'><span class="am-icon-plus"></span> 新增</a></button>
						</div>
					</div>
				</div>
			</div>
			<hr>
			<div class="am-g">
							
				<div class="am-u-sm-12">
					<form  class="am-form">
						<div class="am-cf">
						共 ${coursedatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li style="color: green;">
									当前第 ${coursecurrentpage } 页
									</li >
									<li style="color: green;">
									共 ${coursetotalpage } 页
									</li>
									<li >
										 &nbsp;&nbsp;&nbsp;
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${1 }">≤≤</a>
									</li>
									<li >
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${coursecurrentpage-1 }">≤</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${coursecurrentpage+1 }">≥</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${coursetotalpage }">≥≥</a>
									</li>
								</ul>
							</div>
						</div>
						<table class="am-table am-table-striped am-table-hover table-main" style='table-layout:fixed;'>
							<thead>
								<tr>
									<th class="table-check" style='width:5%;'><input type="checkbox"></th>
									<th class="table-title" style='width:5%;'>ID</th>
									<th class="table-title" style='width:8%;'>课程</th>
									<th class="table-title" style='width:10%;'>封面</th>
									<th class="table-title" style='width:40%;word-wrap:break-word;'>介绍</th>
									<th class="table-type" style='width:8%;'>状态</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${courselist}" var="c">
								<tr>
									<td><input type="checkbox"></td>
									<td>${c.id }</td>
									<td>${c.course }</td>
									<td >
										<img src='${c.imgs }' width="50px" height='50px'> 
									</td>
									<td class="am-hide-sm-only" style='word-wrap:break-word;'>${c.detail }</td>
									<td class="am-hide-sm-only">
											<c:if test="${c.status==0}" >禁用</c:if>
											<c:if test="${c.status==1}" >启用</c:if>
									</td>
									<td>
										<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs"> 									   
											<c:if test="${c.status==1}" ><button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href='hongtu?method=coursecstatus&status=0&id=${c.id }' style="color: red;">✖禁用</a></button></c:if>
												<c:if test="${c.status==0}" ><button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href='hongtu?method=coursecstatus&status=1&id=${c.id }' style="color: green;"> ✔启用</a></button></c:if>
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href='hongtu?method=getcourseinfo&id=${c.id }'><span class="am-icon-pencil-square-o"></span> 编辑</a></button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" ><a style='color:red'  onclick="javascript:return mdelete(${c.id },'course');"><span class="am-icon-trash-o"></span> 删除</a></button>
											 
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							共 ${coursedatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li style="color: green;">
									当前第 ${coursecurrentpage } 页
									</li >
									<li style="color: green;">
									共 ${coursetotalpage } 页
									</li>
									<li >
										 &nbsp;&nbsp;&nbsp;
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${1 }">≤≤</a>
									</li>
									<li >
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${coursecurrentpage-1 }">≤</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${coursecurrentpage+1 }">≥</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=courseshow&currentpage=${coursetotalpage }">≥≥</a>
									</li>
								</ul>
							</div>
						</div>
						<hr>
					</form>
				</div>
			</div>
		</div>	
		<script type="text/javascript">
		function mdelete(id,tablename){
			$.MsgBox(({type:"confirm",speed:2000,userDesign:false,borderColor:"red"}),id,tablename);
			return false;
		}
	</script>
	</body>
</html>