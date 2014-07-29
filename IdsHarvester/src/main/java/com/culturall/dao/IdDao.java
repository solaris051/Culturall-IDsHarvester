package com.culturall.dao;

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

/*		
		Page page = new Page();
		page.setScreenShot("some screenshot");
		page.setUrl("www.maps.google.com");
		page.setIds(translateIds);
*/	
		Session session = this.getSession();
//		session.save(page);

//insert Id into page	
		Query query = session.getNamedQuery(Page.findPageByUrl).setString("url", "www.meta.ua");
		Page pageMatch = (Page) query.uniqueResult();
		
		TranslateId tId = new TranslateId();
		tId.setText("bla-bla");
		tId.setTransId(123456L);
		
		System.out.println("ids on page " + pageMatch.getIds().size());
		pageMatch.getIds().add(tId);

		session.update(pageMatch);
		
//end
		return this.value + ((pageMatch != null) ? (" <strong>" + pageMatch.getUrl() + "</strong>") : "");
	}
	
	private Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (Exception e) {
			return sessionFactory.openSession();
		}
	}
}
