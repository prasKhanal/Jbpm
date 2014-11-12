
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jbpm.demo.entity.ContentCatogory" %>
<%@ page import="com.jbpm.demo.entity.Client" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Content</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Here we include the css file  -->
<link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
$( "#date" ).datepicker();
});
</script>
</head>

<body><div id="container" style=" height : 348px;">
 <% String taskId = (request.getAttribute("taskId")).toString(); %>
<%--  <%String clientName=(request.getAttribute("clientName")).toString(); %> --%>
 <% List <ContentCatogory> contentCatogories=(List <ContentCatogory>) (request.getAttribute("contentCatogories")); %>
 <%Client client=(Client)(request.getAttribute("client")); %>
      
        <div id="content">

            <p style="FONT-SIZE: large;">Create Content</p>
            
         

           <form action="createContent" method="POST">
<p><%= request.getAttribute("message") == null ? "" : request.getAttribute("message") %></p>
Client Name: <input type="text" name="clientName" value="<%= client.getName() %>" readonly /><BR/>
Proposed Date: <input type="text" name="date" id="date"  /><BR/>
Content Description: <input type="text" name="contentDescription" /><BR/>
Comment:<input type="text" name="comment" /><BR/>

 <input type="hidden" name="taskId" value="<%=taskId %>"/> 
Contain Graphics: <select name="hasGraphics">
<option value="true" >Yes</option>
<option value="false" >No</option>
</select>
<BR/>
Content Catogory:
<select name="contentCatogoryId">
<option>Select One</option>
<%for(ContentCatogory contentCatogory:contentCatogories){%>
	<option value="<%= contentCatogory.getId()%>"> <%= contentCatogory.getName()%></option>
	
<%} %>
</select>
<BR/>


<input type="submit" value="Create Content" style=""/>
</form>
			

        </div>
        
      
    </div>
</body>
</html>
