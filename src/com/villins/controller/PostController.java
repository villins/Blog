package com.villins.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.villins.dao.Page;
import com.villins.entity.Post;
import com.villins.entity.Tag;
import com.villins.service.PostService;
import com.villins.service.TagService;
import com.villins.util.BlogUtil;

@Controller
@RequestMapping("/article")
public class PostController {
	
	@Resource
	private PostService postService;
	
	@Resource
	private TagService tagService;
	
	@RequestMapping("/new")
	public String toNew(){	
		return "addArticle";
	}
	
	@RequestMapping(value="/new",method = RequestMethod.POST)
	public ModelAndView add(Post post,String note_tags,HttpServletRequest request/*,HttpServletResponse response*/){
		Date date = new Date();
		post.setCreated_at(BlogUtil.parseDate(date));
		String[] strs = note_tags.split(",|，");
		post = postService.add(post);
		List<Tag> tags = new ArrayList<Tag>();
		for(String str : strs){
			Tag tag = new Tag();
			tag.setName(str);
			tag.setPost(post);
			tag = tagService.add(tag);
			tags.add(tag);
		}
		post.setTags(tags);
		post = postService.edit(post);
		return new ModelAndView(new RedirectView(request.getContextPath()+"/article/"+post.getPost_id())); 
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") int id,ModelMap modelMap){
		Post post = postService.get(id);
		modelMap.addAttribute(post);
		return "showArticle";
	}
	
	@RequestMapping("/{id}/edit")
	public String toEdit(@PathVariable("id") int id,ModelMap modelMap){
		Post post = postService.get(id);
		modelMap.addAttribute(post);
		return "editArticle";
	}
	
	@RequestMapping(value = "/{id}/edit",method = RequestMethod.PUT)
	public ModelAndView edit(Post post,HttpServletRequest request/*,HttpServletResponse response*/){
		Date date = new Date();
		post.setCreated_at(date);
		post = postService.add(post);
		return new ModelAndView(new RedirectView(request.getContextPath()+"/article/"+post.getPost_id())); 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/load")
	public @ResponseBody List<Post> loadMore(@RequestParam("pageNo") int pageNo){
		System.out.println(pageNo);
		Page page = postService.pagedQuery("from Post", pageNo+1, 10);
		List<Post> posts = page.getResult();
		System.out.println(posts.size());
		return posts;
	}
	
	

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public TagService getTagService() {
		return tagService;
	}

	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	
	
}
