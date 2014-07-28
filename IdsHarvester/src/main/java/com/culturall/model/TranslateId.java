package com.culturall.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*@Entity
@Embeddable*/
public class TranslateId {

	private Long id;
	private Integer number;
	private Page page;
	private String text;
	
	public TranslateId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TranslateId(Long id, Integer number, Page page, String text) {
		super();
		this.id = id;
		this.number = number;
		this.page = page;
		this.text = text;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	} 

	@Embedded
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
