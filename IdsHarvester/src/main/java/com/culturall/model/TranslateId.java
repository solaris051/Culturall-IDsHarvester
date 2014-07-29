package com.culturall.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TranslateId {

	private Long transId;
	private Page page;
	private String text;
	
	public TranslateId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TranslateId(Long transId, Page page, String text) {
		super();
		this.transId = transId;
		this.page = page;
		this.text = text;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	@ManyToOne
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
