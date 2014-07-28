package com.culturall.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.culturall.model.Page;
import com.culturall.model.TranslateId;

@Repository
public class IdDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String value = "def DAO value";
	
	public String getValue() {
		Page page = new Page();
		page.setScreenShot("some screenshot");
		page.setUrl("www.google.com");
		
		this.getSession().save(page);
		
		return this.value;
	}
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
}
