package com.jbpm.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.jbpm.demo.rewards.ejb.TaskLocal;
import org.kie.api.task.model.TaskSummary;

public class TaskListServiceImp implements TaskListService {
    
	@Inject
	private TaskLocal taskbean;
	@Override
	public List<TaskSummary> retrieveTaskList(String user) throws Exception {
		return taskbean.retrieveTaskList(user);
	}
	@Override
	public void claimTask(String taskId, String name) throws Exception {
		taskbean.claimTask(taskId, name);
		
	}
	@Override
	public List<TaskSummary> retrieveClaimedTaskList(String user)
			throws Exception {
		// TODO Auto-generated method stub
		return taskbean.retrieveClaimedTaskList(user);
	}

}
