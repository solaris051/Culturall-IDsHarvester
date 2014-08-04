package com.culturall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="translate_ids")
@NamedQueries({
	@NamedQuery(name="getTranslateIdById", query="SELECT t FROM TranslateId t WHERE t.transId = :tId")
})
public class TranslateId {

	//public static final String getTranslateIdById = "TranslateId.getTranslateIdById";
	
	private Long id;
	private Long transId;
	private Page page;
	private String text;
	
	public TranslateId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TranslateId(Long id, Long transId, Page page, String text) {
		super();
		this.id = id;
		this.transId = transId;
		this.page = page;
		this.text = text;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="tr_id")
	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	@ManyToOne
	@JoinColumn(name="page_id")
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Column(name="tr_text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
