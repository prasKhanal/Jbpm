package com.jbpm.demo.service;



import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jbpm.demo.dao.ClientDao;
import com.jbpm.demo.entity.Client;


@Stateless
public class ClientServiceImpl implements ClientService {
	@Inject
	private ClientDao clientDao;

	@Override
	public Client getClient(String clientId) {
		
		return clientDao.getClient(clientId);
	}

}
