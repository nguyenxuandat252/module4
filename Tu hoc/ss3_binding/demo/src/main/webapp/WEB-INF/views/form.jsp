<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 21/03/2025
  Time: 9:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form:form action="/users/register" method="post" modelAttribute="user">
  <form:input type="text" path="name" placeholder="Enter name"/>
  <form:input type="number" path="age" placeholder="Enter age"/>
  <form:input type="email" path="email" placeholder="Enter email"/>
  <form:button type="submit">Register1</form:button>
</form:form>
</body>
</html>
