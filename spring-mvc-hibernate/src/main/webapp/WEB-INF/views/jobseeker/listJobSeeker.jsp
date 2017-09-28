<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job Seeker List</title>
    </head>
    <body>
        <div align="center">
            <h1>JobSeeker List</h1>
            <h3><a href="/jobportal/newJobSeeker">New JobSeeker</a></h3>
            <table border="1">
                <th>No</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Action</th>
                 
                <c:forEach var="jobSeeker" items="${listJobSeeker}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${jobSeeker.firstName}</td>
                    <td>${jobSeeker.lastName}</td>
                    <td>${jobSeeker.age}</td>
                    <td>
                        <a href="/jobportal/editJobSeeker?id=${jobSeeker.jobSeekerId}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/jobportal/deleteJobSeeker?id=${jobSeeker.jobSeekerId}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>