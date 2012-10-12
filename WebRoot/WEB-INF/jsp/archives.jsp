<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="styles/main.css" rel="stylesheet" type="text/css">
	<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
	<script type="text/javascript">
		
	</script>
	<link href="styles/article.css" rel="stylesheet" type="text/css">
   
  </head> 	
  <body>
  	<jsp:include page="top.jsp"/>
	<div class="mian-wrap">
	  <div class="main-left">
		<div id="content-list">
		  <c:forEach var="post" items="${posts}">  
			<div class="title"><h2><a href="<%=path %>/article/${post.post_id }">${post.title }</a></h2></div>
			<p><span class="datetime">${post.created_at }</span></p>

			<div class="share"></div>
		  </c:forEach>
		</div>
	  </div>
	  <div class="main-right">
	 
	  </div>
	</div>
	
  </body>
</html>
