
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jbpm.demo.entity.ContentCatogory" %>
<%@ page import="com.jbpm.demo.entity.Client" %>
<%@ page import="com.jbpm.demo.entity.Rule" %>
<%@ page import="org.json.JSONObject" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Create Content</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Here we include the css file  -->
<link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
<link rel="stylesheet" href="resources/css/jquery.datetimepicker.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- Latest compiled and minified CSS -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"rel="stylesheet">
<!-- Optional theme -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"rel="stylesheet">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js">
</script>
</head>

<body>


<div id="container" style=" height : 600px;">
		 <% String taskId = (request.getAttribute("taskId")).toString(); %>
		 <%--  <%String clientName=(request.getAttribute("clientName")).toString(); %> --%>
		 <% List <ContentCatogory> contentCatogories=(List <ContentCatogory>) (request.getAttribute("contentCatogories")); %>
		 <%Client client=(Client)(request.getAttribute("client")); %>
      
       <div class="row"><!-- Left Column -->
       
       <div class="col-md-6" style="FONT-SIZE: medium;  border-top: 5px solid ;   border-left: 5px solid ;   border-right: 5px solid ;   border-bottom: 5px solid ;">

            <h2>Create Content</h2>
            
         

           <form action="createContent" method="POST">
           
           <p>Client Name: <input type="text" name="clientName" value="<%= client.getName() %>" readonly /></p>
           <p>Proposed Date: <input type="text" name="date" id="date"  /></p>
           <p>Content Description: <textarea name="contentDescription" style="width: 361px; height: 77px;"></textarea></p>
           <p>Comment:<textarea name="comment" style="width: 360px; height: 49px;"></textarea></p>
           <input type="hidden" name="taskId" value="<%=taskId %>"/> 
           <p>Contain Graphics: 
           <select name="hasGraphics">
           <option value="true" >Yes</option>
           <option value="false" >No</option>
           </select>
           </p>
           <p>Content Catogory:
           <select id ="contentCatogoryId" name="contentCatogoryId" onchange="ChangeContentCatogory()">
           <option value="">Select One</option>
           <%for(ContentCatogory contentCatogory:contentCatogories){%>
           <option value="<%= contentCatogory.getId()%>"> <%= contentCatogory.getName()%></option>
           <%} %>
           </select><p/>
           <p><input type="submit" value="Create Content" style=""/></p>
           </form>
		</div>
		<div class="col-md-6" >
		<div id="contentCatogory" 
		style="FONT-SIZE: medium;  
		border-top: 5px solid ;   
		border-left: 5px solid ;   
		border-right: 5px solid ;   
		border-bottom: 5px solid ;
		width:100%;">
		<h2>Content Catogory Rule</h2>
    <div id="rule">
    </div>
    </div>
    </div>
    </div>
    </div>
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery.datetimepicker.js"></script>
<script>
$('#date').datetimepicker();
</script>
<script>
function ChangeContentCatogory(){
	var contentCatogoryId=document.getElementById("contentCatogoryId");
	var selectedContentCatogoryId=contentCatogoryId.options[contentCatogoryId.selectedIndex].value;
	$('#rule').html('');
	if(selectedContentCatogoryId!=""){
		
		$.ajax({
			type: 'GET',
			dataType: 'json',
			url: 'getRule',
			data: {  contentCatogoryid : selectedContentCatogoryId }
			 })
			 .done(function( data ) {
				console.log( data );
				
				for (x in data.ruleList) {
					//var key = Object.keys(data.ruleList[x])[0];
					$( '<label><input type="checkbox" name="checkbox" value="'+data.ruleList[x]['ruleId']+'">'+data.ruleList[x]['rule']+'</label>' ).appendTo( "#rule" );
				}
				
			
				
			
			});


		}
}
</script>
<style>

#rule {
}

#rule label {
	width:100%;
	float:left;
	text-align:left;
}

</style>
</html>
