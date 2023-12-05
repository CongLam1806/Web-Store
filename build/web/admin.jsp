<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="java.util.List"%>
<%@page import="pe.entity.Comestic"%>
<%@page import="pe.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link
            rel="stylesheet"
            href="./css/style.css"
        />
    </head>
    <body>
        <%
            User loginUser = (User) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID() )) {
//                System.out.println("OK");
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search != null) {
                search = "";
            }
        %>

        <h1>Welcome: <%= loginUser.getFullName()%></h1>
        <a href="MainController?action=Logout"></a> 
        <form action="MainController" class="btn" >
            <input type="submit" name="action" value="Logout"/>
            <input type="hidden" name="list" value=""<%= request.getParameter("list")%>/>
            <input type="submit" name="action" value="List"/><br/>
            <input type="submit" name="action" value="Add" />
        </form >
        
        <!--<button><a href="add.jsp">Add</a></button>-->
                
        
        
        <%
            List<Comestic> listComestic = (List<Comestic>) request.getAttribute("LIST_COMESTIC");
//            List<Comestic> listComestic1 = (List<Comestic>) session.getAttribute("LIST_MOBILE");
            if (listComestic != null) {
                if (listComestic.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Status</th>                  
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (Comestic comestic : listComestic) {
                %>
            <form action="MainController" method="POST">               
                <tr>
                    <td><%= ++count%></td>
                    <td>
                        <input type="text" name="Id" value="<%= comestic.getId() %>" readonly="" class="button"/>
                    </td>
                    <td>
                        <input type="text" name="name" value="<%= comestic.getName() %>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="description" value="<%= comestic.getDescription()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="price" value="<%= comestic.getPrice()%>" required=""/>
                    </td>
                    <td>
                        <input type="text" name="status" value="<%= comestic.isStatus() %>" required=""/>
                    </td>
                    
                </tr>
            </form>

            <%
                }
            %>
        </tbody>
    </table>
    <%
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    %>
    <%= error%>
    <%
            }
        }
    %>
            
    </body>
</html>
