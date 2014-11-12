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

package org.jbpm.demo.rewards.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.jbpm.runtime.manager.impl.RuntimeEnvironmentBuilder;
import org.jbpm.runtime.manager.impl.cdi.InjectableRegisterableItemsFactory;
import org.jbpm.services.task.HumanTaskConfigurator;
import org.jbpm.services.task.HumanTaskServiceFactory;
import org.jbpm.services.task.audit.JPATaskLifeCycleEventListener;
import org.jbpm.services.task.identity.DBUserGroupCallbackImpl;
import org.jbpm.services.task.identity.DefaultUserInfo;
import org.jbpm.services.task.impl.command.CommandBasedTaskService;
import org.kie.api.io.ResourceType;
import org.kie.api.task.TaskService;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.manager.RuntimeEnvironment;
import org.kie.internal.runtime.manager.cdi.qualifier.PerProcessInstance;
import org.kie.internal.runtime.manager.cdi.qualifier.PerRequest;
import org.kie.internal.runtime.manager.cdi.qualifier.Singleton;

@ApplicationScoped
public class RewardsApplicationScopedProducer {

    @Inject
    private InjectableRegisterableItemsFactory factory;
    
    @Inject
    private DBUserGroupCallbackImpl usergroupCallback;
    
    @Inject
    private TaskService taskService;

    @PersistenceUnit(unitName = "org.jbpm.newTask")
    private EntityManagerFactory emf;


    @Produces
    public DBUserGroupCallbackImpl produceUserGroupCallback() {
    	Properties properties = new Properties();
    	
    	properties.setProperty(DBUserGroupCallbackImpl.DS_JNDI_NAME, "java:/mysqlCredential");
    	properties.setProperty(DBUserGroupCallbackImpl.PRINCIPAL_QUERY, "select principal_id  from principles where principal_id = ?");
    	properties.setProperty(DBUserGroupCallbackImpl.ROLES_QUERY, "select role_group from roles where role_group = ?");
    	properties.setProperty(DBUserGroupCallbackImpl.USER_ROLES_QUERY, "select role_group from roles where principal_id = ?");
		try {
		 
		  for(String key : properties.stringPropertyNames()) {
			  String value = properties.getProperty(key);
			  System.out.println(key + " => " + value);
			}
		} catch (Exception e) {
			  System.out.println(e);
		}
    	usergroupCallback=new DBUserGroupCallbackImpl(properties);
        return usergroupCallback;
    }

    @Produces
    public EntityManagerFactory produceEntityManagerFactory() {
        if (this.emf == null) {
            this.emf = Persistence.createEntityManagerFactory("org.jbpm.newTask");
        }
        return this.emf;
    }

    @Produces
    @Singleton
    @PerProcessInstance
    @PerRequest
    public RuntimeEnvironment produceEnvironment(EntityManagerFactory emf) {
        RuntimeEnvironment environment = RuntimeEnvironmentBuilder
                .getDefault()
                .entityManagerFactory(emf)
                .userGroupCallback(usergroupCallback)
                .registerableItemsFactory(factory)
                .addAsset(ResourceFactory.newClassPathResource("newTask1.bpmn2"),ResourceType.BPMN2).get();
        return environment;
    }
    

    @Produces
	public CommandBasedTaskService produceTaskService(EntityManagerFactory emf) {
		if (taskService == null) {
			HumanTaskConfigurator configurator = HumanTaskServiceFactory.newTaskServiceConfigurator()
					.entityManagerFactory(emf)
					.userGroupCallback(usergroupCallback)
					.userInfo(new DefaultUserInfo(true));

			
			this.taskService = (CommandBasedTaskService) configurator.getTaskService();	
		}
		
		return (CommandBasedTaskService)taskService;
	}
  
}
