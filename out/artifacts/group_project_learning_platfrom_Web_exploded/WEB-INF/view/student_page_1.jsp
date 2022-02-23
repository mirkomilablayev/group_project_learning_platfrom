<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/19/2022
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Page</title>
</head>
<body>

<c:set value="${student}" var="currentUser"/>

<h1>Assalomu alaykum Student Panel,,${currentUser.firstName}</h1>

</body>
</html>
