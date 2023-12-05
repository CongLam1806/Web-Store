<%-- 
    Document   : registration
    Created on : Jun 15, 2023, 4:14:30 PM
    Author     : Trần Công Lâm
--%>

<%@page import="pe.entity.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link
            rel="stylesheet"
            href="./css/registration.css"
        />
    </head>
    <body>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>
        <form action="MainController" method="POST" class="info">
            <div class="title">
                <h1>WELCOME</h1><br/>
                <p>Enter your details</p><br/> 
            </div>

            <h4>User ID</h4><br/>
            <input type ="text" name="userID" placeholder="Your userID" required=""/></br>
            <%
                if(userError.getUserID() != null){ %>
                    <p style="color: red;"><%= userError.getUserID() %></p></br>
                <% }
                %>
            <h4>Status</h4> 
            
            <input type="radio" name="status" value="Yes" id="radio1" checked/>
            <label for="radio1">Yes</label>
            <input type="radio" name="status" value="No" id="radio2"/>
            <label for="radio2">No</label><br/>
            
            <h4>Full Name</h4><br/>
            <input type ="text" name="fullName" placeholder="Your full name" required=""/></br>
            
            
            <h4>Password</h4><br/>
            <input type ="password" name="password" required="" placeholder="Your password"/><br/><br/>
            
            
            <input class="submit" type="submit" name="action" value="Create"/><br/>
            <input class="submit" type="reset" value="Reset"/>  
            <p class="note">Have you has an account <a href="./login.jsp" >Click here</a></p>
        </form>
    </body>
</html>
