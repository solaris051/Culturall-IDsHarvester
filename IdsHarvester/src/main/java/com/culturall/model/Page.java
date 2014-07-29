package com.culturall.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Page.findAll, query="SELECT p FROM Page p ORDER by p.url"),
	@NamedQuery(name=Page.findPageByUrl, query="SELECT p FROM Page p WHERE p.url = :url")
})
public class Page {
	
	public static final String findAll = "Page.findAll";
	public static final String findPageByUrl = "Page.findPageByUrl";

	private Long pageId;
	private List<TranslateId> ids;
	private String screenShot;
	private String url;
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(Long pageId, List<TranslateId> ids, String screenShot,
			String url) {
		super();
		this.pageId = pageId;
		this.ids = ids;
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

	@OneToMany(mappedBy="page")
	@Column(name="translateIds")
	public List<TranslateId> getIds() {
		return ids;
	}

	public void setIds(List<TranslateId> ids) {
		this.ids = ids;
	}

	
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
