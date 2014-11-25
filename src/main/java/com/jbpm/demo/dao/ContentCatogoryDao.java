package com.jbpm.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.jbpm.demo.entity.Client;
import com.jbpm.demo.entity.ContentCatogory;
import com.jbpm.demo.entity.Rule;

@Local
public interface ContentCatogoryDao {

	

	void addContentCatogory(ContentCatogory contentCatogory);

	List<ContentCatogory> getContentCatogories(Client client);
	List<ContentCatogory> getContentCatogories(int clientId);

	ContentCatogory getContentCatogory(int contentCatogoryId);

	List<Rule> getRuleList(int contentCatogoryId);

	

}
