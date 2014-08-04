package com.culturall.dao;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.culturall.model.Page;
import com.culturall.model.TranslateId;

@Repository
@Transactional
public class IdDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String value = "def DAO value";
	
	
	public String getValue() {

		return this.value;
	}
	
	private Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}

	public void persistPages (Set<Page> pageSet) {
		Session session = this.getSession();
		for (Page p: pageSet) {
			session.save(p);
		}
		session.close();
	}
	
	public Page getPageByTranslateId (Long translateId) {
		Session session = this.getSession();
		Query query = session.getNamedQuery("getTranslateIdById");
		query.setLong("tId", translateId);
		ArrayList<TranslateId> matchedIds = (ArrayList<TranslateId>) query.list();
		
		if (matchedIds.size() > 0) {
			Long pageId = matchedIds.get(0).getPage().getPageId();
			System.out.println("pageId is: " + pageId);
			query.setLong("id", pageId);
			Page matchedPage = (Page) query.uniqueResult();
			return matchedPage;
		} else {
			return null;
		}
	}
}