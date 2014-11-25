package com.jbpm.demo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbpm.demo.entity.Client;


@Stateless
public class ClientDaoImpl implements ClientDao {
	@Inject
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClient(){
		List<Client> list = null;

		
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
			     list=session.createQuery("FROM Client").list();
			     session.getTransaction().commit();	     
		return list;
		
	}

	@Override
	public Client getClient(int clientId) {
		
		Client client=null;
		
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
	    client=(Client) session.get(Client.class, clientId);
	    session.getTransaction().commit();	  
			     
			     
		return client;
	}

	@Override
	public Client getClient(String clientId) {
		return getClient(Integer.parseInt(clientId));
	}

}
