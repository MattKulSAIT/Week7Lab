<%-- 
    Document   : users
    Created on : 28-Feb-2023, 9:46:18 AM
    Author     : mdkul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <table>   
            <tr><th>Email</th><th>First Name</th><th>Last Name</th><th>Role</th><th></th><th></th></tr>
            <c:forEach items="${users}" var="user">
            <tr><td>user.email</td><td>user.firstName</td><td>user.lastName</td><td>user.role</td><td><a href="users?action=editUser;userEmail=${user.email}">Edit</a></td><td><a href="users?action=deleteUser;userEmail=${user.email}">Delete</a></td></tr>

                </c:forEach>
        </table> 
        <h2></h2>
        
    </body>
</html>
