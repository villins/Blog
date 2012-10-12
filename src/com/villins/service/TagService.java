package com.villins.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.villins.dao.BaseDao;
import com.villins.dao.TagDao;
import com.villins.entity.Tag;

@Service
public class TagService extends BaseService<Tag> {
	
	@Resource
	private TagDao tagDao;
	
	@Override
	public BaseDao<Tag> getDao() {
		// TODO Auto-generated method stub
		return tagDao;
	}
	
	public Tag add(Tag entity) {
		return tagDao.add(entity);
	}

}
