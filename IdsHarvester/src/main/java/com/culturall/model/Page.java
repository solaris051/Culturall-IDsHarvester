package com.culturall.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Page {
	private Long pageId;
	//private List<TranslateId> idList;
	private String screenShot;
	private String url;
	
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(Long pageId, /*List<TranslateId> idList,*/ String screenShot,
			String url) {
		super();
		this.pageId = pageId;
		//this.idList = idList;
		this.screenShot = screenShot;
		this.url = url;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}
/*	
	public List<TranslateId> getIdList() {
		return idList;
	}

	public void setIdList(List<TranslateId> idList) {
		this.idList = idList;
	}
*/
	public String getScreenShot() {
		return screenShot;
	}

	public void setScreenShot(String screenShot) {
		this.screenShot = screenShot;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
