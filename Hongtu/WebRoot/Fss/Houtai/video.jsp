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
				<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">在线视频</strong><small></small></div>
			</div>

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"><a href='${pageContext.request.contextPath}//Fss//Houtai//add//videoadd.jsp'><span class="am-icon-plus"></span> 新增</a></button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">

				</div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form  class="am-form">
					<div class="am-cf">
							共 ${videodatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li>
									当前第 ${videocurrentpage } 页
									</li>
									<li>
									共 ${videototalpage } 页
									</li>
									<li>
										<a href="hongtu?method=videoshow&currentpage=${1 }">≤≤</a>
									</li>
									<li >
										<a href="hongtu?method=videoshow&currentpage=${videocurrentpage-1 }">≤</a>
									</li>
									<li>
										<a href="hongtu?method=videoshow&currentpage=${videocurrentpage+1 }">≥</a>
									</li>
									<li>
										<a href="hongtu?method=videoshow&currentpage=${videototalpage }">≥≥</a>
									</li>
								</ul>
							</div>
						</div>
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check" style='width:5%;'><input type="checkbox"></th>
									<th class="table-title" style='width:5%;'>ID</th>
									<th class="table-title" style='width:14%;'>标题</th>
									<th class="table-title" style='width:30%;'>视频</th>
									<th class="table-title" style='width:18%;'>创建时间</th>
									<th class="table-type" style='width:5%;'>状态</th>
									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${videolist}" var="c">
								<tr>
									<td><input type="checkbox"></td>
									<td>${c.id }</td>
									<td>${c.title }</td>
									<td >
									<object classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" id="MusicPlayer" height="200" width="240"><!--是否透明-->    
									<param name="wmode" value="transparent">  
									<param name="AutoStart" VALUE="0">  <!--是否自动播放-->  
									<param name="Balance" VALUE="0">  <!--调整左右声道平衡,同上面旧播放器代码-->  
									<param name="enabled" value="-1">  <!--播放器是否可人为控制-->  
									<param name="EnableContextMenu" VALUE="-1"> <!--是否启用上下文菜单-->   
									<param name="url" VALUE="${C.video }"> <!--播放的文件地址-->   
									<param name="PlayCount" VALUE="1"> <!--播放次数控制,为整数-->   
									<param name="rate" value="1"><!--播放速率控制,1为正常,允许小数,1.0-2.0-->   
									<param name="currentPosition" value="0">  <!--控件设置:当前位置-->  
									<param name="currentMarker" value="0">  <!--控件设置:当前标记--> 
									<param name="defaultFrame" value="">  <!--显示默认框架-->  
									<param name="invokeURLs" value="0">  	<!--脚本命令设置:是否调用URL-->
									<param name="baseURL" value="">  <!--脚本命令设置:被调用的URL--> 
									<param name="stretchToFit" value="0">  <!--是否按比例伸展-->  
									<param name="volume" value="50">  		<!--默认声音大小0%-100%,50则为50%-->
									<param name="mute" value="0">  <!--是否静音-->  
									<param name="uiMode" value="mini">  <!--播放器显示模式:Full显示全部;mini最简化;None不显示播放控制,只显示视频窗口;invisible全部不显示-->
									<param name="windowlessVideo" value="0">  <!--如果是0可以允许全屏,否则只能在窗口中查看-->  
									<param name="fullScreen" value="0">  <!--开始播放是否自动全屏-->  
									<param name="enableErrorDialogs" value="-1">  <!--是否启用错误提示报告-->  
									<param name="SAMIStyle" value>  <!--SAMI样式-->  
									<param name="SAMILang" value>  <!--SAMI语言-->  
									<param name="SAMIFilename" value>  <!--字幕ID-->  
									</object>  
									<script language="javascript" type="text/javascript">  
									 
									function changeMusic(srcMusic)  
									{  
									MusicPlayer.url = srcMusic;  
									}  
									</script>
									</td>
									<td>${c.ctime }</td>
									<td class="am-hide-sm-only">
											<c:if test="${c.status==0}" >禁用</c:if>
											<c:if test="${c.status==1}" >启用</c:if>
									</td>
									<td>
										<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs"> 									   
											<c:if test="${c.status==1}" ><button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a href='hongtu?method=videocstatus&status=0&id=${c.id }'style="color: red;">✖禁用</a></button></c:if>
												<c:if test="${c.status==0}" ><button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href='hongtu?method=videocstatus&status=1&id=${c.id }' style="color: green;"> ✔启用</a></button></c:if>
												<button class="am-btn am-btn-default am-btn-xs am-text-secondary"><a href='hongtu?method=getvideoinfo&id=${c.id }'><span class="am-icon-pencil-square-o"></span> 编辑</a></button>
												<button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><a  onclick="javascript:return mdelete(${c.id },'video');" style="color: red;"><span class="am-icon-trash-o"></span> 删除</a></button>
											 
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							共 ${videodatacount } 条记录
							<div class="am-fr">
								<ul class="am-pagination">
									<li>
									当前第 ${videocurrentpage } 页
									</li>
									<li>
									共 ${videototalpage } 页
									</li>
									<li>
										<a href="hongtu?method=videoshow&currentpage=${1 }">≤≤</a>
									</li>
									<li >
										<a href="hongtu?method=videoshow&currentpage=${videocurrentpage-1 }">≤</a>
									</li>
									<li>
										<a href="hongtu?method=videoshow&currentpage=${videocurrentpage+1 }">≥</a>
									</li>
									<li>
										<a href="hongtu?method=videoshow&currentpage=${videototalpage }">≥≥</a>
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