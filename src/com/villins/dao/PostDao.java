package com.villins.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.villins.entity.Post;

@Repository
public class PostDao extends BaseDao<Post> {

	public Post add(Post entity) {		
		Session session = getSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return entity;
	}
	
	public Post edit(Post entity) {
		Session session = getSession();
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.merge(entity);
			tx.commit();
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return entity;
	}
}
