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

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbpm.demo.service.ProcessService;


@WebServlet("/process")
public class ProcessServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProcessService processService;
    
   
    


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String processCreator = req.getUserPrincipal().getName();
        String clientId=req.getParameter("clientId");

        long processInstanceId = -1;
        try {
            processInstanceId = processService.startProcess(clientId);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        String message =  "Process (id = " + processInstanceId + ") has been started by " + processCreator ;
        
        req.setAttribute("message", message);
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/home");
        dispatcher.forward(req, res);
    }
}