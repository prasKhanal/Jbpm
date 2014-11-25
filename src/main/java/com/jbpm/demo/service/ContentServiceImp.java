package com.jbpm.demo.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jbpm.demo.rewards.ejb.ContentLocal;
import org.jbpm.demo.rewards.ejb.ProcessEngineService;
import org.jbpm.demo.rewards.ejb.TaskLocal;
import org.jbpm.demo.rewards.util.ExttraUtlis;
import org.json.JSONException;
import org.json.JSONObject;

import com.jbpm.demo.dao.ClientDao;
import com.jbpm.demo.dao.ContentCatogoryDao;
import com.jbpm.demo.dao.UserDao;
import com.jbpm.demo.entity.Address;
import com.jbpm.demo.entity.Client;
import com.jbpm.demo.entity.Comment;
import com.jbpm.demo.entity.ContentCatogory;
import com.jbpm.demo.entity.Role;
import com.jbpm.demo.entity.Rule;
import com.jbpm.demo.entity.User;

@Stateless
public class ContentServiceImp implements ContentService  {
	@Inject
    private ContentCatogoryDao contentCatogoryDao;
	 @Inject 
	 private ClientDao clientDao;
	 @Inject
	 private ProcessEngineService processService;
	 @Inject
	 private ContentLocal contentBean;
	 @Inject
	 private TaskLocal taskService ;
	 @Inject 
	 private UserDao userDao;
	    
	@Override
	public void addContentCatogory(String catogoryName, int clientId,
			List<Rule> rules) {
		
		ContentCatogory contentCatogory=new ContentCatogory(catogoryName);
		for(Rule rule :rules){
			rule.setContentCatogory(contentCatogory);
		}
		contentCatogory.setRules(rules);
		contentCatogory.setClient(clientDao.getClient(clientId));
		contentCatogoryDao.addContentCatogory(contentCatogory);
	}

	@Override
	public List<ContentCatogory> getContentCatogories(String clientId) {
		return getContentCatogories(Integer.parseInt(clientId));
	}

	@Override
	public List<ContentCatogory> getContentCatogories(int clientId) {
		List <ContentCatogory> ContentCatogories=contentCatogoryDao.getContentCatogories(clientDao.getClient(clientId));
		 return ContentCatogories;
	}
	
	@Override
	public List<ContentCatogory> getContentCatogoriesFromProcess(
			int processId) {
		int clientId=((Client) processService.getProcessVariable(processId, "client")).getClientId();
		return contentCatogoryDao.getContentCatogories(clientId);
	}
	
	@Override
	public List<ContentCatogory> getContentCatogoriesFromProcess(
			String processId) {
		return getContentCatogoriesFromProcess(Integer.parseInt(processId));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void createContent(String userId, String taskId,
			Map<String, Object> params) {
		Map <Integer,Comment> comments=new TreeMap<Integer,Comment>();
		Date date=ExttraUtlis.formateDate((String) params.get("date"));
        ContentCatogory contentCatogory= contentCatogoryDao.getContentCatogory(Integer.parseInt((String)params.get("contentCatogoryId")));
  
        
        User user=new User();
        user.setName(userId);
        Comment comment= new Comment(1,(String) params.get("comment"),user);
        comments.put(comment.getCommentId(), comment);
		params.put("proposedDate_", date);
        params.put("contentDescription_", params.get("contentDescription"));
        params.put("hasGraphics_", Boolean.parseBoolean((String) params.get("hasGraphics")));
        params.put("contentCatogory_", contentCatogory);
        params.put("comment_", comments);
		try {
			contentBean.createContent(userId, taskId, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Client getClient(int taskId) {
		return (Client) taskService.getTaskVariable(taskId).get("_client");
		
	}
	@Override
	public Client getClient(String processId) {
		return getClient(Integer.parseInt(processId));
	}

	@Override
	public ContentCatogory getContentCatogoryFromTaskProcess(
			String processId) {
		// TODO Auto-generated method stub
		return getContentCatogoryFromTaskProcess(Integer.parseInt(processId));
	}

	
	@Override
	public ContentCatogory getContentCatogoryFromTaskProcess(int processId) {
		return (ContentCatogory) taskService.getTaskVariable(processId).get("_contentCatogory");
	}

	@Override
	public Map<Integer,Comment> getComments(String taskId) {
		// TODO Auto-generated method stub
		return getComments(Integer.parseInt(taskId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer,Comment> getComments(int taskId) {
		return (Map<Integer,Comment>) taskService.getTaskVariable(taskId).get("_comments");
	}

	@Override
	public Date getProposedDate(String taskId) {
		// TODO Auto-generated method stub
		return getProposedDate(Integer.parseInt(taskId));
	}

	@Override
	public Date getProposedDate(int taskId) {
		Map<String, Object> has=taskService.getTaskVariable(taskId);
		return (Date) has.get("_proposedDate");
	}

	@Override
	public String getContentDescriptionFromTaskProcess(String taskId) {
		// TODO Auto-generated method stub
		return getContentDescriptionFromTaskProcess(Integer.parseInt(taskId));
	}

	@Override
	public String getContentDescriptionFromTaskProcess(int taskId) {
		Map<String, Object> has=taskService.getTaskVariable(taskId);
		String contentDescription=(String) has.get("_contentDescription");
		return contentDescription;
	}

	@Override
	public List<Rule> getRuleList(String contentCatogoryId) {
		
		return getRuleList(Integer.parseInt(contentCatogoryId));
	}
	@Override
	public List<Rule> getRuleList(int contentCatogoryId) {
		
		return contentCatogoryDao.getRuleList(contentCatogoryId);
	}

	public List<JSONObject> getRuleListJson(int contentCatogoryId) throws JSONException {
		 List<JSONObject> jobj=new ArrayList<JSONObject>(); 
		Iterator<Rule> iterator=contentCatogoryDao.getRuleList(contentCatogoryId).iterator();
		while(iterator.hasNext()){
			jobj.add(iterator.next().getJson());
		}
		return jobj;
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return clientDao.getAllClient();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comment addComment(int processId, String comment, String userId) {
		// TODO Auto-generated method stub
		TreeMap<Integer,Comment> comments=(TreeMap<Integer, Comment>) processService.getProcessVariable(processId, "comments");
		User user=new User();
        user.setName(userId);
        Comment _comment= new Comment(comments.lastKey()+1,comment,user);
        comments.put(_comment.getCommentId(), _comment);
		processService.setProcessVariable(processId, comments, "comments");
		return ((Map<Integer, Comment>) processService.getProcessVariable(processId, "comments")).get(_comment.getCommentId());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, Comment> getProcessComments(String processId) {
		return ((Map<Integer, Comment>) processService.getProcessVariable(Integer.parseInt(processId), "comments"));
	}


	

}
