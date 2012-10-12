<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'about.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="styles/main.css" rel="stylesheet" type="text/css">
	<link href="styles/article.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <jsp:include page="top.jsp"/>
	<div class="mian-wrap">
		<h1>About Me</h1>
		<p><span class="about">学过ruby，写过java的一软件工程应届生</span></p>
	</div>
  </body>
</html>
