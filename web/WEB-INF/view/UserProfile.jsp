<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set var="user" value="${currentUser}"/>

<div class="card" style="width: 35rem;">
    <div class="card-body">
        <h5 class="card-title">${user.firstName} ${user.lastName}</h5>
        <p class="card-text">${user.bio}</p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Balance: ${user.balance} <a href="/addBalance/${currentUser.id}"><button type="button" class="btn btn-outline-dark">Fill Balance</button></a> </li>
        <li class="list-group-item">Email: ${user.email}</li>
        <li class="list-group-item">Username: ${user.username}</li>
        <li class="list-group-item">Status: Active Account</li>
        <c:choose>
            <c:when test="${user.role.equalsIgnoreCase('Student')}">
                <li class="list-group-item">Role: ${user.role} <a href="/enterSystemWithOtherRole/${user.id}">
                    <button type="button" class="btn btn-outline-primary">Enter as Mentor</button>
                </a></li>
            </c:when>
            <c:when test="${user.role.equalsIgnoreCase('Mentor')}">
                <li class="list-group-item">Role: ${user.role} <a href="/enterSystemWithOtherRole/${user.id}">
                    <button type="button" class="btn btn-outline-primary">Enter as Student</button>
                </a></li>
            </c:when>
        </c:choose>
        <li class="list-group-item">Register At: ${user.register_at}</li>

    </ul>
    <div class="card-body">
        <c:choose>
            <c:when test="${currentUser.role.equalsIgnoreCase('Admin')}">
                <a href="/backToAdminMenu/${currentUser.id}" class="card-link">
                    <button type="button" class="btn btn-outline-danger">Back</button>
                </a>
            </c:when>
            <c:when test="${currentUser.role.equalsIgnoreCase('Student')}">
                <a href="/backToUserPage/${currentUser.id}" class="card-link">
                    <button type="button" class="btn btn-outline-danger">Back</button>
                </a>
            </c:when>
            <c:when test="${currentUser.role.equalsIgnoreCase('Mentor')}">
                <a href="/back/${currentUser.id}" class="card-link">
                    <button type="button" class="btn btn-outline-danger">Back</button>
                </a>
            </c:when>
        </c:choose>
        <a href="/editProfile/${currentUser.id}" class="card-link">
            <button type="button" class="btn btn-outline-success">Edit Profile</button>
        </a>
    </div>
</div>


</body>
</html>
