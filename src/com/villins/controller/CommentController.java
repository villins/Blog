package com.villins.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.villins.entity.Comment;
import com.villins.entity.Post;
import com.villins.service.CommentService;
import com.villins.service.PostService;

@Controller
public class CommentController {
	
	@Resource
	private CommentService commentService;
	@Resource
	private PostService postService;
	
	@RequestMapping(value="article/{post_id}/comment/create",method = RequestMethod.POST)
	public ModelAndView add(Comment comment,@PathVariable("post_id") int post_id,HttpServletRequest request/*,HttpServletResponse response*/){
		comment = commentService.add(comment);
//		int id = Integer.parseInt(request.getParameter("id"));
		Post post = postService.get(post_id);
		post.getComments().add(comment);
		post = postService.edit(post);
		return new ModelAndView(new RedirectView(request.getContextPath()+"/article/"+post.getPost_id())); 
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}


	
	
}
