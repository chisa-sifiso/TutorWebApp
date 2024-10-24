<%-- 
    Document   : add_tutor_outcome
    Created on : 12 Jun 2024, 2:02:23 PM
    Author     : sifis
--%>

<%@page import="za.ac.tut.models.Tutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Tutor tutor = (Tutor)request.getAttribute("tutor");
        String name = tutor.getName();
        %>
    <body style="background-color: #ffff99">
    <center>
        
        <p>
            <b><%=name%></b> has been added to the database
        <p>
        <p>Click <a href="index.html">here</a> to go back to menu page</p>
        
    </center>
    </body>
</html>
