package org.jbpm.demo.rewards.web;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbpm.demo.rewards.util.ExttraUtlis;






import com.jbpm.demo.entity.Comment;
import com.jbpm.demo.service.ContentService;

/**
 * Servlet implementation class AddGraphicsServlet
 */
@WebServlet("/addGraphics")
public class AddGraphicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  @Inject
	    private ContentService contentService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGraphicsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String taskId=req.getParameter("taskId");
    	String processId=req.getParameter("processId");
    	
    	 req.setAttribute("processId", processId);
    	 req.setAttribute("taskId", taskId);
    	 req.setAttribute("client",contentService.getClient(taskId));
    	 req.setAttribute("comments",new ArrayList<Comment>((Collection<Comment>)contentService.getProcessComments(processId).values()));
    	 req.setAttribute("proposedDate", ExttraUtlis.dateToString(contentService.getProposedDate(taskId)));
    	 req.setAttribute("contentCatogory", contentService.getContentCatogoryFromTaskProcess(taskId));
    	 req.setAttribute("contentDescription", contentService.getContentDescriptionFromTaskProcess(taskId));
    	
         ServletContext context = this.getServletContext();
         RequestDispatcher dispatcher = context.getRequestDispatcher("/addGraphics.jsp");
         dispatcher.forward(req, res);
         return;
         }
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
