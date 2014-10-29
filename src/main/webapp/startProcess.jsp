<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jBPM Rewards Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>

	
    <table>
	<tr>  <td>
	<form name="form1" method="post" action="process" >
		<p>To Start A Process<input type="submit" value="Start"/>
		</p>
	</form>
	</td></tr>
	<tr>
	<td>
	<form >
		<p>To List Unclaimed Task<a href="task"><input type="Button" name="submit"  value="ListUnclaimed"/></a></p>
	</form></td></tr>
	<tr>
	<td>
	<form name= "form2 " method="post" action="task" >
		<p>To List Claimed Task<input type="submit" name="submit" value="ListClaimed"/></p>
	</form></td></tr>
   </table>
   </body>
   </html>