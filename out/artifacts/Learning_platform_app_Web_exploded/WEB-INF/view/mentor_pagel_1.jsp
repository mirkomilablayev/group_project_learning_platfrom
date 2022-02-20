<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/19/2022
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mentor page</title>
</head>
<body>

<c:set var="currentUser" value="${mentor}"/>
<h1>Assalomu alaykum mentor panelga,,,${currentUser.firstName}</h1>

<a href="/addCourse">b<button style="background-color: green">+ Add Course</button></a><hr>

</body>
</html>
