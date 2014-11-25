package com.jbpm.demo.service;

import javax.ejb.Local;

@Local
public interface ProcessService {

	long startProcess(String clientId) throws Exception;

}
