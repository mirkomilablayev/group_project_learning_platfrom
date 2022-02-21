<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/20/2022
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="user_id" value="${user_id}"/>
<c:set var="course_id" value="${course_id}"/>
<c:set var="course" value="${course}"/>



<form action="/addModule/${user_id}/${course_id}/${course}" method="post">
    Module Name <br>
    <input type="text" name="name" placeholder="Module Name"><br><br>
    Module Description <br>
    <textarea name="description" placeholder="Module Description"></textarea><br><br>
    <input type="submit" value="Add module">
</form>


</body>
</html>
