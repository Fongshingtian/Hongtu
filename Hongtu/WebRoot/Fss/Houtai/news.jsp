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
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">新闻动态</strong><small></small></div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"><a href='${pageContext.request.contextPath}//Fss//Houtai//add//newsadd.jsp'><span class="am-icon-plus"></span> 新增</a></button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field">
						<span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
					</div>
				</div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form  class="am-form">
					<div class="am-cf">
							共 ${newsdatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li style="color: green;">
									当前第 ${newscurrentpage } 页
									</li>
									<li style="color: green;">
									共 ${newstotalpage } 页
									</li>
									<li>
										 &nbsp;&nbsp;&nbsp;
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${1 }">≤≤</a>
									</li>
									<li >
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${newscurrentpage-1 }">≤</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${newscurrentpage+1 }">≥</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${newstotalpage }">≥≥</a>
									</li>
								</ul>
							</div>
						</div>
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check" style="width:5%;"><input type="checkbox"></th>
									<th class="table-title" style="width:5%;">ID</th>
									<th class="table-title" style="width:17%;">标题</th>
									<th class="table-title" style="width:20%;">发布时间</th>
									<th class="table-title" style="width:20%;">内容</th>
									<th class="table-type" style="width:8%;">状态</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${newslist}" var="n">
								<tr>
									<td><input type="checkbox"></td>
									<td>${n.id }</td>
									<td>${n.title }</td>
									<td >${n.ctime }</td>
									<td ><a href='hongtu?method=readnews&id=${n.id }'>点击查看详细内容</a></td>
									<td class="am-hide-sm-only">
											<c:if test="${n.status==0}" >禁用</c:if>
											<c:if test="${n.status==1}" >启用</c:if>
									</td>
									<td>
										<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs"> 									   
											<c:if test="${n.status==1}" ><button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href='hongtu?method=newscstatus&status=0&id=${n.id }'style="color: red;">✖禁用</a></button></c:if>
												<c:if test="${n.status==0}" ><button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href='hongtu?method=newscstatus&status=1&id=${n.id }' style="color: green;"> ✔启用</a></button></c:if>
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href='hongtu?method=getnewsinfo&id=${n.id }'><span class="am-icon-pencil-square-o"></span> 编辑</a></button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a style="color: red;"  onclick="javascript:return mdelete(${n.id },'news');"><span class="am-icon-trash-o"></span> 删除</a></button>
											 
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							共 ${newsdatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li style="color: green;">
									当前第 ${newscurrentpage } 页
									</li>
									<li style="color: green;">
									共 ${newstotalpage } 页
									</li>
									<li>
										 &nbsp;&nbsp;&nbsp;
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${1 }">≤≤</a>
									</li>
									<li >
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${newscurrentpage-1 }">≤</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${newscurrentpage+1 }">≥</a>
									</li>
									<li>
										<a style="color: green;" href="hongtu?method=newsshow&currentpage=${newstotalpage }">≥≥</a>
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