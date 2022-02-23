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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<c:set value="${student}" var="currentUser"/>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Asilbek</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">  <button type="button" class="btn btn-outline-primary">Home</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">  <button type="button" class="btn btn-outline-primary">My courses</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">  <button type="button" class="btn btn-outline-primary">Profile settings</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">  <button type="button" class="btn btn-outline-primary">Log out</button></a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="row">
    <c:forEach var="c" items="${courses}">
        <div class="card;" class="col-10 offset-1"  style="width: 18rem;background-color: silver;margin: 2%">
            <img style="padding: 2%"
                 src="data:image/png;base64, ${c.img}"
                 class="card-img-top" alt="Here should be image">
            <div class="card-body">
                <p class="card-title"><strong>Course Name:</strong>${c.course.name}</p>
                <p class="card-text"><strong>Description:</strong>${c.course.description}</p>
                <a href="/more/${c.course.id}" class="btn btn-success"><button>More...</button></a>
            </div>
        </div>
    </c:forEach>
</div>

<%--<h1>Assalomu alaykum Student Panel,,${currentUser.firstName}</h1>--%>
</body>
</html>
