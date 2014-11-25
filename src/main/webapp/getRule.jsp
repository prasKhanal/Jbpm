<%@ page import="java.util.List" %>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.jbpm.demo.entity.ContentCatogory" %>
<%@ page import="com.jbpm.demo.entity.Client" %>
<%@ page import="com.jbpm.demo.entity.Rule" %>
<%@ page import="org.json.JSONObject" %>

<%

  JSONObject ruleList = (JSONObject)request.getAttribute("jsonObj");
    out.print(ruleList);
    out.flush();
    
  %>