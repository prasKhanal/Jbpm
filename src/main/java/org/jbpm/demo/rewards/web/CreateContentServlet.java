/**
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.demo.rewards.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbpm.demo.rewards.ejb.TaskLocal;


@WebServlet("/createContent")
public class CreateContentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private TaskLocal taskService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

   
        String user = req.getUserPrincipal().getName();
        String taskId=req.getParameter("taskId");
        String clientName=req.getParameter("clientName");
        String contentDescription=req.getParameter("contentDescription");
        String hasGraphics=req.getParameter("hasGraphics");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("clientName", clientName);
        params.put("contentDescription", contentDescription);
        params.put("hasGraphics", hasGraphics);
       
        
        
        

      
}
}