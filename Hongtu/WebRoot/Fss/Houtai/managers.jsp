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
 		<script type="text/javascript">
 			function tosearch(){
	 			document.getElementById('f').submit();
 			}
 			
 			function allchecked(){
 				var allc = document.getElementById('allcheck').checked;
 				var onec= document.getElementsByName('onecheck');
 				if(allc){
 					document.getElementById('checkhide').style.display='inline';
 				}else if(!allc){
 					document.getElementById('checkhide').style.display='none';
 				}
 				for(var i=0;i<onec.length;i++){
 					onec[i].checked=allc;
 				}
 			}
 			
 			function onechecked(){
 				var ischecked=false;
 				var onec= document.getElementsByName('onecheck');
 				for(var i=0;i<onec.length;i++){
 					if(onec[i].checked){
 						ischecked=true;
		 				document.getElementById('checkhide').style.display='inline';
 						break;
 					}
 				} 
 				if(!ischecked){
 					document.getElementById('checkhide').style.display='none';
 				}
 			}
 			
 			function alldisable(){
 				var onec= document.getElementsByName('onecheck');
 				var id='';
 				for(var i=0;i<onec.length;i++){
 					if(onec[i].checked){
 						id =id+ onec[i].id+'-';
 					}
 				} 
 				window.location.href='hongtu?method=allmanagerscstatus&status=0&id='+id;
 			}
 			
 			function allenable(){
 			 	var onec= document.getElementsByName('onecheck');
 				var id='';
 				for(var i=0;i<onec.length;i++){
 					if(onec[i].checked){
 						id =id+ onec[i].id+'-';
 					}
 				} 
 				window.location.href='hongtu?method=allmanagerscstatus&status=1&id='+id;
 			}
 			 
 		</script>
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0" >
				<div class="am-fl am-cf" ><strong class="am-text-primary am-text-lg" >后台成员</strong><small></small></div>
			</div>

			<hr>
 			<form id="f" action="hongtu?method=managerssearch" method="post">
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"><a href='${pageContext.request.contextPath}//Fss//Houtai//add//managersadd.jsp'  ><span class="am-icon-plus" ></span> 新增</a></button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">

				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="text" name='search' class="am-form-field" <c:if test="${managersshow=='managerssearchshow' }">value='${searchvalue }'</c:if>>
						<span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button" onclick="tosearch();" >搜索</button>
          
          </span>
					</div>
				</div>
			</div>
			<hr>  
			</form>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form  class="am-form">
					<div class="am-cf">
							共 ${managersdatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li style="color: green;">
									当前第 ${managerscurrentpage } 页
									</li>
									<li style="color: green;">
									共 ${managerstotalpage } 页
									</li> 
									<li >
										 &nbsp;&nbsp;&nbsp;
									</li>
									<li >
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${1 }" style="color: green;">≤≤</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${1}" style="color: green;">≤≤</a></c:if>
									</li>
									<li >
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${managerscurrentpage-1 }" style="color: green;">≤</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${managerscurrentpage-1 }" style="color: green;">≤</a></c:if>
									</li>
									<li>
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${managerscurrentpage+1 }" style="color: green;">≥</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${managerscurrentpage+1 }" style="color: green;">≥</a></c:if>
									</li>
									<li>
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${managerstotalpage }" style="color: green;">≥≥</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${managerstotalpage }" style="color: green;">≥≥</a></c:if>
									</li>
									 
								</ul>
							</div>
						</div>
						
						<div   id='checkhide' class="am-table am-table-striped am-table-hover table-main" style='display: none;'>
							<div class="am-btn-group am-btn-group-xs" > 	
								<a href='hongtu?method=allmanagerscstatus' ></a>
								<button   class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" style='visibility: hidden;'></button>								  
								<button   class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href='javascript:alldisable();' style="color: red;">✖全部禁用</a></button>	
								<button  class="am-btn am-btn-default am-btn-xs am-text-secondary" style='color:green'><a  href='javascript:allenable();' style="color: green;">✔全部启用</a></button>
							</div>
						</div>
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr >
									<th class="table-check" style='width:5%;'><input type="checkbox" id='allcheck' onclick="allchecked();"></th>
									<th class="table-title" style='width:5%;'>ID</th>
									<th class="table-title" style='width:20%;'>成员</th>
									<th class="table-title" style='width:15%;'>账号</th>
									<th class="table-title" style='width:15%;'>密码</th>
									<th class="table-author am-hide-sm-only" style='width:8%;'>性别</th> 
									<th class="table-type" style='width:8%;'>状态</th>
									<th class="table-set" >  操作  </th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${managerslist}" var="m">
								<tr >
									<td><input type="checkbox" id='${m.id }' name='onecheck' onclick='onechecked();'></td>
									<td > ${m.id } </td>
									<td >
										<img src='${m.face }' width="30px" height='30px'> ${m.nickname }
									</td>
									<td>${m.account }</td>
									<td class="am-hide-sm-only">${m.pwd }</td>
									<td class="am-hide-sm-only">${m.sex }</td>
									<td class="am-hide-sm-only">
											<c:if test="${m.status==0}" >禁用</c:if>
											<c:if test="${m.status==1}" >启用</c:if>
									</td>
									<td>
										<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs"> 								  
											<c:if test="${m.status==1}" ><button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href='hongtu?method=managerscstatus&status=0&id=${m.id }' style="color: red;">✖禁用</a></button></c:if>
												<c:if test="${m.status==0}" ><button class="am-btn am-btn-default am-btn-xs am-text-secondary" style='color:green'><a href='hongtu?method=managerscstatus&status=1&id=${m.id }' style="color: green;">✔启用</a></button></c:if>
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary" ><a href='hongtu?method=getmanagersinfo&id=${m.id }'><span class="am-icon-pencil-square-o" ></span>编辑	</a></button>
												<button style='color:red' class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="javascript:return mdelete(${m.id },'managers');" > <span class="am-icon-trash-o" ></span> 删除 </button>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							共 ${managersdatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination" >
									<li style="color: green;">
									当前第 ${managerscurrentpage } 页
									</li>
									<li style="color: green;">
									共 ${managerstotalpage } 页
									</li> 
									<li >
										 &nbsp;&nbsp;&nbsp;
									</li>
									<li >
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${1 }" style="color: green;">≤≤</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${1}" style="color: green;">≤≤</a></c:if>
									</li>
									<li >
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${managerscurrentpage-1 }" style="color: green;">≤</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${managerscurrentpage-1 }" style="color: green;">≤</a></c:if>
									</li>
									<li>
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${managerscurrentpage+1 }" style="color: green;">≥</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${managerscurrentpage+1 }" style="color: green;">≥</a></c:if>
									</li>
									<li>
										<c:if test="${managersshow=='managersshow'}"><a href="hongtu?method=managersshow&currentpage=${managerstotalpage }" style="color: green;">≥≥</a></c:if>
										<c:if test="${managersshow=='managerssearchshow'}"><a href="hongtu?method=managerssearch&currentpage=${managerstotalpage }" style="color: green;">≥≥</a></c:if>
									</li>
								</ul>
							</div>
						</div>
						<hr>
					</form>
				</div>
			</div>
		</div>	
			<a href='https://www.baidu.com' id='s'></a>
		<script>
		function mdelete(id,tablename){
			$.MsgBox(({type:"confirm",speed:2000,userDesign:false,borderColor:"red"}),id,tablename);
			return false;
		}
	</script>
	</body>
</html>
