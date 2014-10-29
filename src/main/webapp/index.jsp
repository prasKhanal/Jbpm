<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Start Process</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Here we include the css file  -->
<link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
</head>

<body><div id="container" style=" height : 348px;">
      
        <div id="content">

            <p style="FONT-SIZE: large;">jBPM 6 Rewards Demo</p>

            <%@ include file="startProcess.jsp"%>
            
            <p>
            	<label style="color: green;width: 100%;text-align: left;">
            		<%= request.getAttribute("message") == null ? "no action" : request.getAttribute("message") %>
            	</label> 
			</p>
			<br/>
			
			

        </div>
        
      
    </div>
</body>
</html>
