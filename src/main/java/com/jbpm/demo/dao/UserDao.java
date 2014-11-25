package com.jbpm.demo.dao;

import javax.ejb.Local;

import com.jbpm.demo.entity.User;

@Local
public interface UserDao {

	User getUser(int parseInt);

	User getUserbyName(String userId);

	void saveUser(User user);

}
