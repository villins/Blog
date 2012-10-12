<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<p><span class="datetime">${post.created_at }</span>
				<c:forEach items="${requestScope.post.tags }" var="tag">
			    		<span class="tag"><a href="">${tag.name}</a></span>
	    		</c:forEach>
			</p>
			<div class="note-content">${post.content } 
			<br/>
			<br/><br/><br/><br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
			</div>
			<div class="share"></div>
			<div class="comment-list">
			    	<c:if test="${requestScope.post.comments !=null}">
			    		<h2>comments：</h2>
			    		<% int i=1; %>
			    		<c:forEach items="${requestScope.post.comments }" var="comment" begin="0">
			    			<h5>#<%=i++ %>楼:<span class="commentor">${comment.reviewer }</span></h5>
			    			<p><span class="comment-content">${comment.content }</span></p>
			    			
	    				</c:forEach>
	    			</c:if>	
			</div>
			<h3>
			你的回应
			 &nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;&nbsp;&middot;
			</h3>
			<div class="comment">
				<form name="comment_form" method="post" action="<%=path %>/article/${post.post_id }/comment/create">
				 <label class="field" for="note_title">name:</label>
				 <div class="item">
				 	 <input tabindex="1" name="reviewer" style="width:403px;" type="text" value=""/>
				 </div>
				 <label class="field" for="note_title">email:</label>
				 <div class="item">
				 	 <input tabindex="2" name="email" style="width:403px;" type="text" value=""/>
				 </div>
				 <label class="field" for="note_title">content:</label>
			  <div class="item">
				  <textarea tabindex="3" name="content" rows="4" cols="64"></textarea><br/>
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
