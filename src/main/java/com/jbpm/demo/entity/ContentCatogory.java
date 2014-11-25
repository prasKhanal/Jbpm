package com.jbpm.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cascade;

 @Entity public class ContentCatogory implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue private int contentCatogoryId;
    @OneToMany(fetch = FetchType.EAGER,mappedBy="contentCatogory",cascade={javax.persistence.CascadeType.ALL})
    private List <Rule> rules;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="ClientId")
	private Client client;
	
	public ContentCatogory (){}
	
	public ContentCatogory (String name){
		this.name=name;
	}
   
	public int getContentCatogoryId() {
		return contentCatogoryId;
	}

	public void setContentCatogoryId(int contentCatogoryId) {
		this.contentCatogoryId = contentCatogoryId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return contentCatogoryId;
	}
	public void setId(int id) {
		this.contentCatogoryId = id;
	}
	public List<Rule> getRules() {
		return rules;
	}
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
	
	

}
