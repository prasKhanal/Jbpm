package com.jbpm.demo.service;


import javax.ejb.Local;

import com.jbpm.demo.entity.Client;
@Local
public interface ClientService {

	Client getClient(String clientId);

}
