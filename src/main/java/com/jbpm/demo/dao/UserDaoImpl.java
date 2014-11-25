package com.jbpm.demo.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jbpm.demo.entity.User;

@Stateless
public class UserDaoImpl implements UserDao {
	@Inject
	private SessionFactory sessionFactory;

	public User getUser(int userId) {
		  User user=null;
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		
		  try{
			   user=(User) session.get(User.class, userId);
			   transaction.commit();
		  }
	    catch (HibernateException e) {
	        System.out.println(e.getMessage());
	        System.out.println("error");
	    }
		return user;
	}

	@Override
	public User getUserbyName(String name) {
		User user=null;
		  Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		
		  try{
//			   Query query= session.createQuery("from user where name=:name");
//			   query.setParameter("name", name);
//			   user=query.
			   transaction.commit();
		  }
	    catch (HibernateException e) {
	        System.out.println(e.getMessage());
	        System.out.println("error");
	    }
		return user;

}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		
		  try{
			   session.save( user);
			   transaction.commit();
		  }
	    catch (HibernateException e) {
	        System.out.println(e.getMessage());
	        System.out.println("error");
	    }
		
	}}
