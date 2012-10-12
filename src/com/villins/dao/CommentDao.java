package com.villins.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.villins.entity.Comment;

@Repository
public class CommentDao extends BaseDao<Comment> {
	public Comment add(Comment entity) {		
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
}
