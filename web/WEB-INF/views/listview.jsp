<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: muralinutalapati
  Date: 01/10/2018
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Murali</title>
</head>
<body>
<div class="wrapper">
    <div id="header">
        <h1>Customer relationship manager</h1>
    </div>
</div>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="tempCustomer" items="${customers}">
        <tr>
            <td>${tempCustomer.firstName}</td>
            <td>${tempCustomer.lastName}</td>
            <td>${tempCustomer.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
