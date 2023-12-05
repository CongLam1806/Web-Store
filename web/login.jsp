<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link
            rel="stylesheet"
            href="./css/login.css"
        />
    </head>
    <body>
        <!--your code here-->
        <form action="MainController" method="POST">
            <div class="title">
               <h1>WELCOME</h1><br/>
                <p>Enter your details</p><br/> 
            </div>
            Username: <input name="userID" required> <br>
            Password: <input name="password" required> <br>
            <p style="color: red">${ERROR} </p><br>
            <button type="submit" name="action" value="Login">Login</button>
        </form>
    </body>
    
</html>

