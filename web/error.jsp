<%-- 
    Document   : error
    Created on : Mar 1, 2022, 8:33:55 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link
            rel="stylesheet"
            href="./css/style.css"
        />
    </head>
    <body>
       Error: <h1><%= request.getAttribute("ERROR")%></h1>  
    </body>
   
</html>
