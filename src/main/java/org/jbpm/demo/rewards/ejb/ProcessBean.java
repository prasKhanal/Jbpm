/**
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.demo.rewards.ejb;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.kie.internal.runtime.manager.cdi.qualifier.Singleton;
import org.kie.internal.runtime.manager.context.EmptyContext;

import com.jbpm.demo.entity.Client;


@Startup
@javax.ejb.Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class ProcessBean implements ProcessLocal {

    @Resource
    private UserTransaction ut;

    @Inject
    private ProcessEngineService processService;


    public long startProcess(Client client) throws Exception {

    	KieSession ksession=processService.getKsession();

        long processInstanceId = -1;

        ut.begin();

        try {
            // start a new process instance
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("client", client);
            ProcessInstance processInstance = ksession.startProcess("defaultPackage.newTask1", params);

            processInstanceId = processInstance.getId() ;
            WorkflowProcessInstance p = (WorkflowProcessInstance) processInstance;  
           System.out.println("Client Name Is "+((Client)p.getVariable("client")).getName());
          
            
            System.out.println("Process started ... : processInstanceId = " + processInstanceId);

            ut.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (ut.getStatus() == Status.STATUS_ACTIVE) {
                ut.rollback();
            }
            throw e;
        }

        return processInstanceId;
    }

  
   
}
