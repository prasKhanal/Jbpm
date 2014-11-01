
package com.app;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;

import org.jbpm.services.task.identity.DBUserGroupCallbackImpl;


public class sdcsdasc {
	
	public static void main(String[] args){
		
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("jbpm.usergroup.callback.properties"));
		  for(String key : properties.stringPropertyNames()) {
			  String value = properties.getProperty(key);
			  System.out.println(key + " => " + value);
			}
		} catch (IOException e) {
			  System.out.println("err");
		}
}}


