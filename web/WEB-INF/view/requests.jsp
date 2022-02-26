<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/24/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requests</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<c:set value="${request}" var="req"/>
<c:set value="${admin_id}" var="admin_id"/>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="spinner-border text-success" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/backToAdminMenu/${admin_id}">
                        <button type="button" class="btn btn-outline-primary">Back</button>
                    </a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search users,courses">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<hr>


<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Course Name</th>
        <th scope="col">Mentor</th>
        <th scope="col">Price</th>
        <th scope="col">Button</th>
        <th scope="col">Button</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="r" items="${req}">
        <c:choose>
            <c:when test="${r.accepted eq false}">
                <tr>
                    <th scope="row">❤</th>
                    <td>${r.course.name}</td>
                    <td>${r.mentor.firstName} ${r.mentor.lastName}</td>
                    <td>${r.course.price}</td>
                    <td><a href="/accept/${admin_id}/${r.course.id}"><button style="background-color: green">Accept</button></a></td>
                    <td><a href="/cancel/${admin_id}/${r.course.id}"><button style="background-color: red">Cancel</button></a></td>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>

    </tbody>
</table>


</body>
</html>
