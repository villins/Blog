package com.villins.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.villins.service.PostService;

@Controller
@RequestMapping("/archtives")
public class ArchiveContrller {
	
	@Resource
	private PostService postService;
	
	@RequestMapping("/")
	public String archives(){
		return "archives";
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	
	
}
