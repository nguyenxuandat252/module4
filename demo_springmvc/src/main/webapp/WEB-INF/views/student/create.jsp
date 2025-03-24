<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 19/03/2025
  Time: 10:30 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/students/create" method="post" modelAttribute="student">
    <form:input type="text" path="id"/>
    <form:input type="text" path="name"/>
    <form:button>add</form:button>
</form:form>
</body>
</html>
