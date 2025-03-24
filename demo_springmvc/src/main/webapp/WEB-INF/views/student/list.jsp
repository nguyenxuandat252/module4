<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 19/03/2025
  Time: 9:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang danh sách Student</title>
</head>
<body>
<form action="/students/search" method="post">
  <input type="text" name="name" placeholder="name" value="${param.name}">
  <button>Search</button>
</form>
<a href="/students/create">Add Student</a>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Function</th>
  </tr>
  <c:forEach var="s" items="${studentList}">
    <tr>
      <td>${s.id}</td>
      <td>${s.name}</td>
      <td>
        <form action="/students/detail" method="get">
          <input type="hidden" name="id" value="${s.id}">
          <button>detail</button>
        </form>
      </td>
      <td>
        <form action="/students/delete" method="post">
          <input type="hidden" name="action" value="delete">
          <input type="hidden" name="id" value="${s.id}">
          <button>Delete</button>
        </form>
      </td>
      <td>
        <form action="/students/edit/${s.id}" method="get">
          <input type="hidden" name="id" value="${s.id}">
          <button>Edit</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
