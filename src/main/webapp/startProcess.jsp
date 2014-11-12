
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page import="com.jbpm.demo.entity.Client" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jBPM Rewards Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<%List <Client> clientList= (List <Client>)request.getAttribute("clientList"); %>
    <table>
	<tr>  <td>
	<form name="form1" method="post" action="process" >
	      <p>Client Name:<Select name="clientId">
	      <option value="0"> Select One Client <option>
			<%for (Client client : clientList){ %>      
	      <option value="<%= client.getClientId()%>"><%= client.getName() %> </option>
	      <%} %>
	      
	      </Select>
	      </p>
		<p>To Start A Process<input type="submit" value="Start"/>
		</p>
	</form>
	</td></tr>
<!-- 	<tr> -->
<!-- 	<td> -->
<!-- 	<form > -->
<!-- 		<p>To List Unclaimed Task<a href="task"><input type="Button" name="submit"  value="ListUnclaimed"/></a></p> -->
<!-- 	</form></td></tr> -->
<!-- 	<tr> -->
<!-- 	<td> -->
<!-- 	<form name= "form2 " method="post" action="task" > -->
<!-- 		<p>To List Claimed Task<input type="submit" name="submit" value="ListClaimed"/></p> -->
<!-- 	</form></td></tr> -->
   </table>
   </body>
   </html>