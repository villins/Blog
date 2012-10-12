<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


    <div id="nav">
		<ul>
			<li><a href="" title="主页">Home</a></li>
			<li><a href="" title="档案">Archives</a></li>
			<li><a href="<%=path %>/about" title="我">About Me</a></li>
			<li><a href="" title="推送">Rss</a></li>
		</ul>
	</div>
