<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/21/2022
  Time: 1:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="module_id" value="${module_id}"/>

<form action="/addLesson/${module_id}" method="post">
    Input Lesson name <br><br>
    <input type="text" name="name"><br><br>
    <input type="text" name="url"><br><br>
    <input type="submit" style="background-color: green" value="Save Lesson">
</form>

</body>
</html>
