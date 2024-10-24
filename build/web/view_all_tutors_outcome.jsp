<%-- 
    Document   : view_all_tutors_outcome
    Created on : 12 Jun 2024, 3:15:07 PM
    Author     : sifis
--%>

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Base64"%>
<%@page import="za.ac.tut.models.Tutor"%>
<%@page import="za.ac.tut.models.Tutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        List<Tutor> tutors = (List<Tutor>) request.getAttribute("tutors");
        %>
    <body style="background-color: #ffff99">
        
        
    <center>
        <h1>List of all Students</h1>
        <table border="1">
            <tbody>
                <%
         for (int e = 0; e < tutors.size(); e++) {
                 
           
        
         Tutor tutor =tutors.get(e);
         String photo = "data:image/png;base64,"+Base64.getEncoder().encodeToString(tutor.getPhoto());
         String name = tutor.getName();
         Integer age = tutor.getAge();
         String gender = tutor.getGender();
         Long id = tutor.getId();
         Date date = tutor.getDate();
         SimpleDateFormat famate = new SimpleDateFormat("yyyy-MM-dd");
         String newDate=famate.format(date);
         List<String> subs=tutor.getSubs();
         %>
                <tr>
                    <td>Photo:</td>
                    <td>
                        <img src="<%=photo%>"/>
                    </td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><%=name%></td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><%=age%></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <%=gender %>
                    </td>
                </tr>
                <tr>
                    <td>Stuff Number</td>
                    <td><%=id%></td>
                </tr>
                <tr>
                    <td>Subject</td>
                    <td>
                        <%for (int i = 0; i < subs.size(); i++) {%>
                        <table>
                         
                            <tbody>
                                <tr>
                                    <td>Subject <%=i +1%></td>
                                    <td> <%=subs.get(i)%></td>
                                </tr>
                            </tbody>
                        </table>                      
                        <%}%>
                    </td>
                </tr>
                 <tr>
                    <td>Date</td>
                    <td><%=newDate%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <p>Click <a href="index.html">here</a> to go back to menu page</p>
        
        
    </center>
    </body>
</html>
