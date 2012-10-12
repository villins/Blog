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
		$(document).ready(function () {
				var bt = $('#toolBackTop');
				
		
				$(window).scroll(function() {
						var st = $(window).scrollTop();
						if(st > 30){
								bt.show();
						}else{
								bt.hide();
						}
				});
		})
		
		$(function(){
			var i = 1;
			$('#load').click(function(){
				 alert("nothing");
				 $.getJSON("<%=path%>/article/load",{pageNo:i},function(data){  
				 alert(data); 
	                if(data){   
	                    var str = "";   
	                    alert(data);
	                    $.each(data,function(index,post){   
	                       str = "<div class=\"title\"><h2><a href=\"<%=path %>/article/"+post[post_id]+"\">"+post[title]+"</a></h2></div>"
	                        $("#container").append(str);   
	                    });   
	                    i++;   
	                }else{   
	                    $(".nodata").show().html("别滚动了，已经到底了。。。");   
	                    alert("nothing");
	                    return false;   
	                }   
            	});      
			})
		})
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
			<p><span class="datetime">${post.created_at }</span>
				<c:forEach items="${post.tags }" var="tag">
			    		<span class="tag"><a href="">${tag.name}</a></span>
	    		</c:forEach>
			</p>
			<div class="note-content">${fn:substring(post.content, 0, 200)} 
			<br/>
			<br/><br/><br/><br/><br/><br/>
			<br/>
			<hr class="hr0"/>
			
			
			</div>
			<div class="share"></div>
		  </c:forEach>
		</div>
		<div class="more-load">
			<input type="button" id="load" name="load" value="更多"/>
		</div>
	  </div>
	  <div class="main-right">
	  	<div style="display:none;" class="back-to" id="toolBackTop">
			<a title="返回顶部" onClick="window.scrollTo(0,0);return false;" href="#top" class="back-top">
			<img src="img/back_top.jpg"/></a>
		</div>
	  </div>
	</div>
	
  </body>
</html>
