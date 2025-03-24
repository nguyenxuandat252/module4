<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 23/03/2025
  Time: 4:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/student/edit/${student.id}" method="post" modelAttribute="student">
  <form:input type="hidden" path="id" value = "${student.id}"/>
  <form:input type="text" path="name" value = "${student.name}"/>
  <form:button>Update</form:button>
</form:form>
</body>
</html>
