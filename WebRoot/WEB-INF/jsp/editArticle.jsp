<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showArticle.jsp' starting page</title>
    
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
		<div id="list-content">
			<div class="title"><h2>${post.title }</h2></div>
			<p><span class="datetime">${post.created_at }</span></p>
			<div class="note-content">${post.content } 
			<br/>
			<br/><br/><br/><br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
			</div>
			<div class="share"></div>
			<div class="comment-list">
			</div>
			<h3>
			你的回应
			 &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
			</h3>
			<div class="comment">
				<form name="comment_form" method="post" action="add_comment">
			  <div class="item">
				  <textarea name="rv_comment" rows="4" cols="64"></textarea><br/>
			  </div>
				<div class="item">
				  <span class="bn-flat-hot"><input type="submit" value="加上去"></span>
				</div>
			</form>
			</div>
		</div>
	</div>
  </body>
</html>
