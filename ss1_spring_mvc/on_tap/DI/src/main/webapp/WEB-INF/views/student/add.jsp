<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 23/03/2025
  Time: 3:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/student/add" method="post" modelAttribute="student">
  <form:input type="text" path="id" placehodel = "id"/>
  <form:input type="text" path="name" placehodel = "name"/>
  <form:button>Add</form:button>
</form:form>
</body>
</html>
