package org.jbpm.demo.rewards.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jbpm.demo.entity.Rule;
import com.jbpm.demo.service.ContentService;

/**
 * Servlet implementation class RuleServlet
 */
@WebServlet("/getRule")
public class RuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ContentService contentService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentCatogoryId=(String) request.getParameter("contentCatogoryid");
		System.out.println("hello value is"+contentCatogoryId);
	         JSONObject jsonObj=new JSONObject();
	    try {
	
			jsonObj.put("ruleList",contentService.getRuleListJson(Integer.parseInt(contentCatogoryId)));
		request.setAttribute("jsonObj", jsonObj);
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ServletContext context = this.getServletContext();
         RequestDispatcher dispatcher = context.getRequestDispatcher("/getRule.jsp");
         dispatcher.forward(request, response);
         return;
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
