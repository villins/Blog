package com.villins.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.villins.dao.BaseDao;
import com.villins.dao.PostDao;
import com.villins.entity.Post;

@Service
public class PostService extends BaseService<Post> {
	
	@Resource
	private PostDao postDao;
	
	@Override
	public BaseDao<Post> getDao() {
		// TODO Auto-generated method stub
		return postDao;
	}
	
	public Post add(Post entity) {
		return postDao.add(entity);
	}
	
	public Post edit(Post entity){
		return postDao.edit(entity);
	}

}
