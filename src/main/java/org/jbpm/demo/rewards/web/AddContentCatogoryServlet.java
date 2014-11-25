package org.jbpm.demo.rewards.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbpm.demo.dao.ClientDao;
import com.jbpm.demo.dao.ContentCatogoryDao;
import com.jbpm.demo.entity.ContentCatogory;
import com.jbpm.demo.entity.Rule;

import com.jbpm.demo.service.ContentService;


@WebServlet("/addContentCatogory")
public class AddContentCatogoryServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ContentService contentService ;
	
	
    
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		 req.setAttribute("clientList", contentService.getAllClient());
		 ServletContext context = this.getServletContext();
         RequestDispatcher dispatcher = context.getRequestDispatcher("/addContentCatogory.jsp");
         dispatcher.forward(req, res);
         return;
		
	 }
	 
	 
	 
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 int clientId=Integer.parseInt(req.getParameter("clientId"));
		 String catogoryName =req.getParameter("name");
	        String rule1=req.getParameter("rule1");
	        String rule2=req.getParameter("rule2");
	        ArrayList<Rule> rules=new ArrayList<Rule>();
	        rules.add(new Rule(rule1));
	        rules.add(new Rule(rule2));
	        contentService.addContentCatogory(catogoryName,clientId,rules);
	        
	        ServletContext context = this.getServletContext();
	         RequestDispatcher dispatcher = context.getRequestDispatcher("/addContentCatogory.jsp");
	         dispatcher.forward(req, res);
	         return;
       }
	 }
