package com.villins.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.villins.dao.BaseDao;
import com.villins.dao.CommentDao;
import com.villins.entity.Comment;

@Service
public class CommentService extends BaseService<Comment> {
	
	@Resource
	private CommentDao commentDao;
	
	@Override
	public BaseDao<Comment> getDao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Comment add(Comment entity){
		return commentDao.add(entity);
	}
}
