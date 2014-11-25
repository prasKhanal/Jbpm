package com.jbpm.demo.service;

import javax.ejb.Stateless;
import javax.inject.Inject;



import org.jbpm.demo.rewards.ejb.ProcessLocal;

import com.jbpm.demo.dao.ClientDao;

@Stateless
public class ProcessServiceImpl implements ProcessService  {
   
	@Inject
	private ProcessLocal processBean;
	@Inject
	private ClientDao clientDao;
	
	@Override
	public long startProcess(String clientId) throws Exception {
		
		return processBean.startProcess(clientDao.getClient(clientId));
	}

}
