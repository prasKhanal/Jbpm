package org.jbpm.demo.rewards.ejb;


import java.util.Map;

import javax.ejb.Local;


@Local
public interface ContentLocal {

	public void createContent(String userId, String taskId, Map<String, Object> params) throws Exception;
	public void createContent(String userId, long taskId, Map<String, Object> params) throws  Exception;


}
