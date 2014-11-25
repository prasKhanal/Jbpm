package com.jbpm.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue private int clientId;
	private String name;
	
	 @OneToMany(mappedBy="client",cascade={javax.persistence.CascadeType.ALL},orphanRemoval=true)
	private List <ContentCatogory> contentCatogory;
	 
	
	public List<ContentCatogory> getContentCatogory() {
		return contentCatogory;
	}
	public void setContentCatogory(List<ContentCatogory> contentCatogory) {
		this.contentCatogory = contentCatogory;
	}

	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
