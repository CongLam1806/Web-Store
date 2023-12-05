<%-- 
    Document   : add
    Created on : Jun 13, 2023, 4:30:16 PM
    Author     : Trần Công Lâm
--%>

<%@page import="pe.entity.ComesticError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        
        <link
            rel="stylesheet"
            href="./css/add.css"
        />
    </head>
    <body>
        <%
            ComesticError comesticError = (ComesticError) request.getAttribute("COMESTIC_ERROR");
            if (comesticError == null) {
                comesticError = new ComesticError();
            }
        %>
        
        <button class="link"><a href="admin.jsp" >Back</a> </button>
        <form action="MainController" method="POST" class="info">
            <div class="title">
                <h1>WELCOME</h1><br/>
                <p>Enter details</p><br/> 
            </div>

            <h4>Comestic ID</h4><br/>
            <input type ="text" name="Id" placeholder="Comestic ID" required=""/></br>
            
            <h4>Comestic Name</h4><br/>
            <input type ="text" name="name" required="" placeholder="Comestic Name"/><br/>
            <%
                if(comesticError.getName() != null){ %>
                    <p style="color: red;"><%= comesticError.getName() %></p><br/>
                <%
            }
            
            %>
            
            <h4>Description</h4><br/>
            <input type ="text" name="description" placeholder="Comestic description" required=""/></br>      
            

            <h4>Price</h4><br/>
            <input type ="text" name="price"  placeholder="Comestic price"/><br/><br/>

            

            <h4>Year Of Production</h4><br/>
            <input type ="text" name="yearOfProduction" required="" /><br/><br/>

            <h4>Quantity</h4><br/>
            <input type ="text" name="quantity" required="" /><br/>

            <input class="submit" type="submit" name="action" value="Add"/><br/>
            <input class="submit" type="reset" value="Reset"/> 
        </form>
    </body>
</html>
