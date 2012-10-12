package com.villins.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.villins.dao.Page;
import com.villins.entity.Post;
import com.villins.service.PostService;

@Controller
public class MiscController {
	
	@Resource
	private PostService postService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public String index(ModelMap modelMap){
		Page page = postService.pagedQuery("from Post", 1, 10);
		List<Post> posts = page.getResult();
		modelMap.addAttribute("posts",posts);
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "about";
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	
}
