<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Here we include the css file  -->
<link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
</head>

<body><div id="container" style=" height : 348px;">
      
        <div id="content">

            <p style="FONT-SIZE: large;">User Authentication</p>

           <form action="j_security_check" method="post">
	User Name:<input type="text" name="j_username" /><br/>
	Password:<input type="password" name="j_password" /><br/>
	<input type="submit" value="Login" />
</form>
			

        </div>
        
      
    </div>
</body>
</html>
