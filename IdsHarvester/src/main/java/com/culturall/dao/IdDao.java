package com.culturall.dao;

import java.util.HashSet;
import java.util.Set;

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
	
	public void persistIdsFromPage (Set<String> translateIds, String url) {
		Page page = new Page();
		page.setUrl(url);
		
		Set<TranslateId> idSet = new HashSet<TranslateId>();
		for (String trId: translateIds) {
			TranslateId itTrId = new TranslateId();
			itTrId.setPage(page);
			itTrId.setText("def. Text");
			itTrId.setTransId(Long.parseLong(trId));
			idSet.add(itTrId);
		}
		page.setIds(idSet);
		this.getSession().save(page);
	}
	
/*	
	//for test purposes
	private void writeToDb() {
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
	}
	*/
}