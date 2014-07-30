package com.culturall.dao;

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

		Page pageMatch = null;
		
		Page page = new Page();
		page.setScreenShot("some screenshot");
		page.setUrl("www.culturall.com");
	
		TranslateId tId = new TranslateId();
		tId.setText("bla-bla");
		tId.setTransId(123456L);
		
		tId.setPage(page);

		page.getIds().add(tId);
		
		System.out.println("size is " + page.getIds().size());
		

		
		Session session = this.getSession();
		session.save(page);
		
		return this.value + ((pageMatch != null) ? (" <strong>" + pageMatch.getUrl() + "</strong>") : value);
	}
	
	private Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}
}