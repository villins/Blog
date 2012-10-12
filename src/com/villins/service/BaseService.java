package com.villins.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.villins.dao.BaseDao;
import com.villins.dao.Page;



public abstract class BaseService<T> {

	
	public abstract  BaseDao<T> getDao() ;
	

	public T get(Serializable id) {
		return (T) getDao().get( id);
	}
	
	public void save(T entity) {
		getDao().save(entity);
	}

	public void remove(T entity) {
		getDao().remove(entity);
	}
	@Transactional
	public void update(T entity) {
		getDao().update(entity);
	}
	public List find(String hql) {
		return this.getDao().find(hql);
	}
	
	public List find(String hql, Object... params) {
		return this.getDao().find(hql,params);
	}
	

	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
	

		return getDao().pagedQuery(hql, pageNo, pageSize, values);
	}
	
	public Query createQuery(String hql, Object... values) {
	
		return getDao().createQuery(hql, values);
	}
	

	
}
