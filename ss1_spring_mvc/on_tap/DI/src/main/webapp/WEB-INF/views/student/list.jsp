<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 23/03/2025
  Time: 12:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<form action="/student/search" method="get">
  <input type="text" name="keyword" placeholder="Enter name">
  <button type="submit">Search</button>
</form>
<form action="/student/add" method="get">
  <button>Add</button>
</form>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Function</th>
  </tr>
  <c:forEach var="student" items="${studentList}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td><a href="/student/edit/${student.id}">Edit</a></td>
      <td><a href="/student/delete/${student.id}">Delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
