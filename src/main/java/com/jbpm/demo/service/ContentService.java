package com.jbpm.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import org.json.JSONException;
import org.json.JSONObject;

import com.jbpm.demo.entity.Client;
import com.jbpm.demo.entity.Comment;
import com.jbpm.demo.entity.ContentCatogory;
import com.jbpm.demo.entity.Rule;

@Local
public interface ContentService {

	void addContentCatogory(String catogoryName, int clientId,
			List<Rule> rules);

	List<ContentCatogory> getContentCatogories(String clientId);

	List<ContentCatogory> getContentCatogories(int clientId);

	List<ContentCatogory> getContentCatogoriesFromProcess(String processId);

	List<ContentCatogory> getContentCatogoriesFromProcess(int processId);

	void createContent(String userId, String taskId, Map<String, Object> params);

	Client getClient(String taskId);

	ContentCatogory getContentCatogoryFromTaskProcess(String taskId);

ContentCatogory getContentCatogoryFromTaskProcess(int taskId);

	Map<Integer, Comment> getComments(String taskId);
	Map<Integer, Comment> getComments(int taskId);

	Date getProposedDate(int taskId);

	Date getProposedDate(String taskId);

	String getContentDescriptionFromTaskProcess(String taskId);

	String getContentDescriptionFromTaskProcess(int taskId);

	List<Rule> getRuleList(String contentCatogoryId);

	List<Rule> getRuleList(int contentCatogoryId);

	List<Client> getAllClient();

	List<JSONObject> getRuleListJson(int parseInt) throws JSONException;

	Comment addComment(int processId, String comment, String userId);

	Map<Integer, Comment> getProcessComments(String taskId);
	

	
}
