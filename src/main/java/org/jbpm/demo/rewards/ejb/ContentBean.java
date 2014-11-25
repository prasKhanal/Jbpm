package org.jbpm.demo.rewards.ejb;

import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;

import org.kie.api.task.TaskService;



@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ContentBean implements ContentLocal {
	
	 @Resource
	    private UserTransaction ut;

	    @Inject
	    TaskService taskService;

	    

	@Override
	public void createContent(String userId, String taskId,
			Map<String, Object> params) throws  Exception {
		System.out.println("TaskId started is"+taskId);
		createContent(userId,Long.parseLong(taskId),params);
	}

	@Override
	public void createContent(String userId, long taskId,
			Map<String, Object> params) throws Exception
	{
         ut.begin();
        try {
           taskService.start(taskId, userId);
           taskService.complete(taskId, userId, params);
            ut.commit();
        } catch (RollbackException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

       
		
	}

}
