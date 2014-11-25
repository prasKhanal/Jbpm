<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jbpm.demo.entity.ContentCatogory" %>
<%@ page import="com.jbpm.demo.entity.Client" %>
<%@ page import="com.jbpm.demo.entity.Rule" %>
<%@ page import="com.jbpm.demo.entity.Comment" %>
<%@ page import="org.jbpm.demo.rewards.util.ExttraUtlis" %>
<!DOCTYPE html>
<html>
<head>
    <title>add Graphics</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <!-- Here we include the css file  -->
    <link href="resources/css/screen.css" rel="stylesheet" type="text/css">
    <link href="resources/demos/style.css" rel="stylesheet">
    
     <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link href=
    "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
    rel="stylesheet"><!-- Optional theme -->
    <link href=
    "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"
    rel="stylesheet"><!-- Latest compiled and minified JavaScript -->

    <script src=
    "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery.form.js" ></script>
</head>

<body>
    <div id="container" style=" height : 600px;">
        <% String taskId = (request.getAttribute("taskId")).toString(); %>
         <% String processId = (request.getAttribute("processId")).toString(); %>
        <%--  <%String clientName=(request.getAttribute("clientName")).toString(); %>--%>
        <% ContentCatogory contentCatogory=(ContentCatogory) (request.getAttribute("contentCatogory")); %>
        <%Client client=(Client)(request.getAttribute("client")); %>
        <%List comments=(List )request.getAttribute("comments"); %>

  
            <div class="row">
                <!-- Left Column -->

                <div class="col-md-6" style="FONT-SIZE: medium;  border-top: 5px solid ;   border-left: 5px solid ;   border-right: 5px solid ;   border-bottom: 5px solid ;">
                    <h2>Add graphics</h2>

                    <form action="createContent" method="post" enctype="multipart/form-data">
                        <p>
                        <%= request.getAttribute("message") == null ? "" : request.getAttribute("message") %></p>
                        <p>Client Name: <input name="clientName" readonly type="text"
                        value="<%= client.getName() %>">
                        </p>
                        <p>
                        Proposed Date: <input name="proposedDate" type="text"
                        value="<%= request.getAttribute("proposedDate") %>" readonly />
                        </p>
                        <p>
                        Content Description: <textarea name="contentDescription" readonly  style="width: 360px; height: 49px;" >
                        <%= request.getAttribute("contentDescription") %>
                        </textarea>
                        </p>
                        <input name="taskId" type="hidden" value=
                        "<%=taskId %>">
                         <p>
                        	Content Catogory:
                        	<select name="contentCatogoryId">
		                            <option value="<%= contentCatogory.getId()%>">
		                                <%= contentCatogory.getName()%>
		                            </option>
		                        </select>
                        </p>
                        
		               <br />
                        <p>
                    </form>
                    
                    <div id="graphics_container">
                       Upload File:
                        <form id="graphic_1" class="graphic" action="UploadFile" method="post" enctype="multipart/form-data">
                        	<input type="file" name="graphics"/> 
                        </form><p id="graphic_1_result"></p>
                        </div>
                        <div id="progressbox">
			           <div id="progressbar"></div>
			           <div id="percent">0%</div>
		               </div>
		               <div id="message"></div>
                    
                </div><!-- Right Column -->

                <div class="col-md-6" >
                    <div Style=" border: 5px solid; padding:10px;">
                        <h2>Comments</h2>

                        <table id="commentTable">
                            <tr>
                                <th>Date</th>

                                <th>Comment</th>

                                <th>PostBy</th>
                            </tr><%for (Object object: comments){ %>

                            <tr>
                                <% Comment comment= (Comment)(object); %>

                                <td>
                                <%=ExttraUtlis.dateToString(comment.getDate())  %></td>

                                <td><%= comment.getComment() %></td>

                                <td><%= comment.getUser().getName()%></td>
                            </tr><%} %>
                            <tr><td>
                       
                        </td></tr>
                        </table>
                    </div>
                    <div>
                   
                            <p>
                       <label for="comment">Your Comment</label> 
                        <textarea id="comment">
                        </textarea>
                        <input type="hidden" name="processId" id="processId" value="<%= processId %>" />  
                        <input type="button" value="Add Comment" onClick="addComment()"/>
                        </p>
                      
                    </div>

                    <div id="contentCatogory" style="border: 5px solid ;  ">
                        <h2>List Of Rules</h2>

                        <ul>
                            <%for(Rule rule:contentCatogory.getRules()) {%>

                            <li><%= rule.getRule() %></li><%} %>
                        </ul>
                    </div>
                </div>
             
        </div>
    </div>
</body>
<script type="text/javascript" src="resources/js/fileUploadScript.js"></script>
<script type="text/javascript">
function addComment(){
	var comment = $('#comment').val();
	var processId = $('#processId').val();
	//var comment=document.getElementsByName("comment");
	//var taskId=document.getElementsByName("processId");
	if(comment!=null&&processId!=null){
		$.ajax({
			dataType: 'json',
			url: 'addComment',
			data: {  comment : comment, processId : processId}
			 })
			 .done(function( data ) {
				console.log( data );
				
				$( "#commentTable > tbody" ).append('<tr><td>'+data.comment['date']+'</td><td>'+data.comment['comment']+'</td><td>'+data.comment['user']+'</td></tr>');
				$('#comment').append('');
				console.log('<tr><td>'+data.comment['date']+'</td><td>'+data.comment['comment']+'</td><td>'+data.comment['user']+'</td></tr>');
					//var key = Object.keys(data.ruleList[x])[0];
					//$('<tr><td>'+data.comment['date']+'</td><td>'+data.comment['comment']+'</td><td>'+data.comment['user']+'</td></tr>'.appendTo( "#commentTable > tbody" ));
				
			
				
			
			});


		}
		}
</script>
</html>
