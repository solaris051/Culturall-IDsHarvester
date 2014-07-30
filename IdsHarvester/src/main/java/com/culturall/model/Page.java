package com.culturall.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="pages")
@NamedQueries({
	@NamedQuery(name=Page.findAll, query="SELECT p FROM Page p ORDER by p.url"),
	@NamedQuery(name=Page.findPageByUrl, query="SELECT p FROM Page p WHERE p.url = :url")
})
public class Page {
	
	public static final String findAll = "Page.findAll";
	public static final String findPageByUrl = "Page.findPageByUrl";

	private Long pageId;
	private Set<TranslateId> ids = new HashSet<TranslateId>();
	private String screenShot;
	private String url;
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(Long pageId, Set<TranslateId> ids, String screenShot,
			String url) {
		super();
		this.pageId = pageId;
		this.ids = ids;
		this.screenShot = screenShot;
		this.url = url;
	}

	@Id
	@GeneratedValue
	@Column(name="page_id")
	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	@OneToMany(mappedBy="page", cascade=CascadeType.ALL)
	public Set<TranslateId> getIds() {
		return ids;
	}

	public void setIds(Set<TranslateId> ids) {
		this.ids = ids;
	}

	@Column(name="screenshot")
	public String getScreenShot() {
		return screenShot;
	}

	public void setScreenShot(String screenShot) {
		this.screenShot = screenShot;
	}
	
	@Column(name="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
}
