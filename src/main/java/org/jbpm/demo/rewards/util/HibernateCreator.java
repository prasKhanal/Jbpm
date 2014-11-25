package org.jbpm.demo.rewards.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ApplicationScoped
public class HibernateCreator {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Produces
	public SessionFactory produceHibernateSessionFactory(){
	Configuration configuration = new Configuration().configure();
	sessionFactory= configuration.buildSessionFactory();
	return sessionFactory;
	}
}
