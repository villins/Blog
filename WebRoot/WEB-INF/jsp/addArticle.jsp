<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addArticle.jsp' starting page</title>
    
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
  <br/>
  <br/>
   <div class="mian-wrap">
      <form action="<%=path %>/article/new" method="post" >
   		<div class="row note-title">
	        <label class="field" for="note_title">题目:</label>
	        <div>
	            <input tabindex="1" id="note_title" name="title" type="text" value=""/>
	        </div>
    	</div>
		<div class="row note-text">
	        <label class="field" for="note_text">正文:</label>
	        <div>
	        	<textarea tabindex="2" id="note_text" name="content"></textarea>
	        </div>
    	</div>
    	
    	<div class="row note-title">
	        <label class="field" for="note_title">标签:(用逗号分开，不超过五个)</label>
	        <div>
	            <input tabindex="1" id="note_title" name="note_tags" type="text" value=""/>
	        </div>
    	</div>
    	
    	<div class="row footer">
	        <div class="error-msg board">
	        </div>
	        <span>
	            <input tabindex="7" id="preview_note" value="预览" type="button" class="button" />
	        </span>
	        &nbsp;
	        <input tabindex="8" id="publish_note" value="发表" type="submit" class="btn" name="note_submit" />
    	</div>
	  </form>
   </div>
  </body>
</html>
