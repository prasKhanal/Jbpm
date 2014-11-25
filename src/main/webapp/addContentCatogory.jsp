<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jbpm.demo.entity.Client" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Start Process</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Here we include the css file  -->
<link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
</head>

<body>
<%List <Client> clientList= (List <Client>)request.getAttribute("clientList"); %>

<div id="container" style=" height : 500px;">
      
        <div id="content">

            <p style="FONT-SIZE: large;">Add Content Catogory</p>
			<form method="post" action="addContentCatogory">
			
   
	      <p>Client Name:<Select name="clientId">
	      <option value="0"> Select One Client <option>
			<%for (Client client : clientList){ %>      
	      <option value="<%= client.getClientId()%>"><%= client.getName() %> </option>
	      <%} %>
	      </Select><br/>
			Name:<input type="text" name="name"/><br/>
			Rule0:<textarea rows="1" cols="20" name="rule1"></textarea><br/>
			Rule1:<textarea rows="1" cols="20"name="rule2"></textarea><br/>
			
			<input type="submit" value="Submit"/>
			
			</form>
			

        </div>
        
      
    </div>
</body>
</html>
