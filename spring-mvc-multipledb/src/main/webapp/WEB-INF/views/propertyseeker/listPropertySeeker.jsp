<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Property Seeker List</title>
    </head>
    <body>
        <div align="center">
            <h1>PropertySeeker List</h1>
            <h3><a href="/portal/newPropertySeeker">New PropertySeeker</a></h3>
            <table border="1">
                <th>No</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Action</th>
                 
                <c:forEach var="propertySeeker" items="${listPropertySeeker}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${propertySeeker.firstName}</td>
                    <td>${propertySeeker.lastName}</td>
                    <td>${propertySeeker.age}</td>
                    <td>
                        <a href="/portal/editPropertySeeker?id=${propertySeeker.propertySeekerId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/portal/deletePropertySeeker?id=${propertySeeker.propertySeekerId}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>