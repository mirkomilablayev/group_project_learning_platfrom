<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/19/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set value="${user}" var="user"/>

<c:choose>
    <c:when test="${user.firstName != null}">
        <h1>Hello ${user.firstName} ${user.lastName}</h1>
        <form action="/login" method="post">
            <input type="email" name="email" placeholder="Your email"><br><br>
            <input type="password" name="password" placeholder="Password"><br><br>
            <input type="submit" value="Log in">
        </form>
    </c:when>
    <c:otherwise>
        <form action="/login" method="post">
            <h1>Login Page</h1>
            <input type="email" name="email" placeholder="Your email"><br><br>
            <input type="password" name="password" placeholder="Password"><br><br>
            <input type="submit" value="Log in">
        </form>
    </c:otherwise>
</c:choose>



</body>
</html>
