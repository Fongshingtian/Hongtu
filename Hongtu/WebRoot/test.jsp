<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
  <style>#yinyue{ background:no-repeat; position:absolute; top:100px; left:100px; visibility:inherit;}</style>  
<div id="yinyue">  
<object classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" id="MusicPlayer" height="200" width="240">  
<!--是否透明-->  
<param name="wmode" value="transparent">  
<param name="AutoStart" VALUE="-1">  
<!--是否自动播放-->  
<param name="Balance" VALUE="0">  
<!--调整左右声道平衡,同上面旧播放器代码-->  
<param name="enabled" value="-1">  
<!--播放器是否可人为控制-->  
<param name="EnableContextMenu" VALUE="-1">  
<!--是否启用上下文菜单-->  
<param name="url" VALUE="sss.mp4">  
<!--播放的文件地址-->  
<param name="PlayCount" VALUE="1">  
<!--播放次数控制,为整数-->  
<param name="rate" value="1">  
<!--播放速率控制,1为正常,允许小数,1.0-2.0-->  
<param name="currentPosition" value="0">  
<!--控件设置:当前位置-->  
<param name="currentMarker" value="0">  
<!--控件设置:当前标记-->  
<param name="defaultFrame" value="">  
<!--显示默认框架-->  
<param name="invokeURLs" value="0">  
<!--脚本命令设置:是否调用URL-->  
<param name="baseURL" value="">  
<!--脚本命令设置:被调用的URL-->  
<param name="stretchToFit" value="0">  
<!--是否按比例伸展-->  
<param name="volume" value="50">  
<!--默认声音大小0%-100%,50则为50%-->  
<param name="mute" value="0">  
<!--是否静音-->  
<param name="uiMode" value="mini">  
<!--播放器显示模式:Full显示全部;mini最简化;None不显示播放控制,只显示视频窗口;invisible全部不显示-->  
<param name="windowlessVideo" value="0">  
<!--如果是0可以允许全屏,否则只能在窗口中查看-->  
<param name="fullScreen" value="0">  
<!--开始播放是否自动全屏-->  
<param name="enableErrorDialogs" value="-1">  
<!--是否启用错误提示报告-->  
<param name="SAMIStyle" value>  
<!--SAMI样式-->  
<param name="SAMILang" value>  
<!--SAMI语言-->  
<param name="SAMIFilename" value>  
<!--字幕ID-->  
</object>  
<script language="javascript" type="text/javascript">  
<!--  
function changeMusic(srcMusic)  
{  
MusicPlayer.url = srcMusic;  
}  
//-->  
</script>  
<table width="200" border="0">  
</table>  
</div>  
  
  </body>
</html>
