<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Content</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Here we include the css file  -->
<link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
</head>

<body><div id="container" style=" height : 348px;">
<%-- <% String taskId = (request.getAttribute("taskId")).toString(); %> --%>
      
        <div id="content">

            <p style="FONT-SIZE: large;">Create Content</p>

           <form action="creatContent" method="POST" enctype="multipart/form-data">
<p><%= request.getAttribute("message") == null ? "" : request.getAttribute("message") %></p>
Client Name: <input type="text" name="clientName" /><BR/>
Content Description: <input type="text" name="contentDescription" /><BR/>
<%-- <input type="hidden" name="taskId" value="<%=taskId %>"> --%>
Contain Graphics: <select name="hasGraphics">
<option value="true" >Yes</option>
<option value="false" >No</option>
</select>
<BR/>
<input type="submit" value="Create Content" style=""/>
</form>
			

        </div>
        
      
    </div>
</body>
</html>
