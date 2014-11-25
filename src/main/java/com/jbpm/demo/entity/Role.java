package com.jbpm.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity public class Role implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="userId")
private User user;
private String role;

@Id @GeneratedValue
private int roleId;
public Role(){}
public Role(String role) {
	this.role=role;
}
public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

}
