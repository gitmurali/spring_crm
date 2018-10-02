<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: muralinutalapati
  Date: 02/10/2018
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add customer</title>
</head>
<body>
<div class="wrapper">
    <div id="header">
        <h1>Customer relationship manager</h1>
    </div>
</div>

<form:form action="saveCustomer" modelAttribute="customer" method="post">
    <div>
        <label for="firstName">First Name: </label>
        <input type="text" id="firstName" name="firstName" />
    </div>
    <div>
        <label for="lastName">Last Name: </label>
        <input type="text" id="lastName" name="lastName" />
    </div>
    <div>
        <label for="email">First Name: </label>
        <input type="text" id="email" name="email" />
    </div>
    <button type="submit">Submit</button>
    <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
</form:form>
</body>
</html>
