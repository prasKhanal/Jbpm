package com.jbpm.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.jbpm.demo.rewards.util.ExttraUtlis;
import org.json.JSONException;
import org.json.JSONObject;

@Entity public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue private  int commentId;
	@ManyToOne private User user;
	private Date date;
	private String comment;
	public Comment(){
		this.date=new Date();
	}
	
	public Comment(int i, String comment2, User user2) {
		this.commentId=i;
		this.date=new Date();
		this.comment=comment2;
		this.user=user2;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public JSONObject getJson() throws JSONException {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("commentId", this.commentId);
		jsonObj.put("comment", this.comment);
		jsonObj.put("user", this.user.getName());
		jsonObj.put("date", ExttraUtlis.dateToString(this.date));
		//jsonObj.put(""+this.ruleId, this.rule);
		return jsonObj;
		
	}
	
	
}
