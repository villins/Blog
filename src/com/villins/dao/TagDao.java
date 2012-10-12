package com.villins.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.villins.entity.Post;
import com.villins.entity.Tag;

@Repository
public class TagDao extends BaseDao<Tag> {
	public Tag add(Tag entity) {		
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
