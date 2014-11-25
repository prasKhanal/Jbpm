package org.jbpm.demo.rewards.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.jbpm.demo.entity.Comment;
import com.jbpm.demo.service.ContentService;

/**
 * Servlet implementation class addComment
 */
@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  @Inject
	    private ContentService contentService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getUserPrincipal().getName();
		String comment=(String)request.getParameter("comment");
		int processId=Integer.parseInt((String)request.getParameter("processId"));
		Comment comment_=contentService.addComment(processId,comment,userId);
		JSONObject jsonObj=new JSONObject();
	    try {
	
			jsonObj.put("comment",comment_.getJson());
		request.setAttribute("jsonObj", jsonObj);
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ServletContext context = this.getServletContext();
         RequestDispatcher dispatcher = context.getRequestDispatcher("/addComment.jsp");
         dispatcher.forward(request, response);
         return;
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getUserPrincipal().getName();
		String comment=(String)request.getParameter("comment");
		int processId=Integer.parseInt((String)request.getParameter("processId"));
		Comment comment_=contentService.addComment(processId,comment,userId);
		JSONObject jsonObj=new JSONObject();
	    try {
	
			jsonObj.put("comment",comment_.getJson());
		request.setAttribute("jsonObj", jsonObj);
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 ServletContext context = this.getServletContext();
         RequestDispatcher dispatcher = context.getRequestDispatcher("/addComment.jsp");
         dispatcher.forward(request, response);
         return;
		
		
	}

}
