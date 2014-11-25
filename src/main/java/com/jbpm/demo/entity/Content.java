package com.jbpm.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity public class Content {
	@Id @GeneratedValue private int contentId;
	@ManyToOne private User client;
	@ManyToOne private ContentCatogory contentCatogory;
	private boolean hasGraphics;
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public ContentCatogory getContentCatogory() {
		return contentCatogory;
	}
	public void setContentCatogory(ContentCatogory contentCatogory) {
		this.contentCatogory = contentCatogory;
	}
	public boolean isHasGraphics() {
		return hasGraphics;
	}
	public void setHasGraphics(boolean hasGraphics) {
		this.hasGraphics = hasGraphics;
	}
	
	

}
