package com.jbpm.demo.service;

import java.util.List;

import javax.ejb.Local;

import org.kie.api.task.model.TaskSummary;

@Local
public interface TaskListService {

	List<TaskSummary> retrieveTaskList(String user) throws Exception;

	void claimTask(String taskId, String name)throws Exception;

	List<TaskSummary> retrieveClaimedTaskList(String user)throws Exception;

}
