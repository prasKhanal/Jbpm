package com.jbpm.demo.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.json.JSONException;
import org.json.JSONObject;

@Entity public class Rule implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id @GeneratedValue private int ruleId;
	private String rule;
	
 
 @ManyToOne
 @JoinColumn(name="ContentCatogoryId")
 private ContentCatogory contentCatogory;
	
	public ContentCatogory getContentCatogory() {
		return contentCatogory;
	}
	public void setContentCatogory(ContentCatogory contentCatogory) {
		this.contentCatogory = contentCatogory;
	}
	public Rule(){}
	public Rule(String rule){
		this.rule=rule;
	}
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public JSONObject getJson() throws JSONException {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("ruleId", this.ruleId);
		jsonObj.put("rule", this.rule);
		//jsonObj.put(""+this.ruleId, this.rule);
		return jsonObj;
		
	}
	
	@Override
	public String toString() {
		return "{'ruleId': '" + this.ruleId + "', 'rule': '" + this.rule + "'}";
	}
	
	

}
