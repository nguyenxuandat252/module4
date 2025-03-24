<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 19/03/2025
  Time: 1:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit form</title>
</head>
<body>
<form:form action="/students/edit" method="post" modelAttribute="student">
    <form:input path="id" type="hidden" value="${student.id}"/>
    <form:input path="name" type="text" value="${student.name}"/>
    <form:button>Update</form:button>
</form:form>
</body>
</html>
