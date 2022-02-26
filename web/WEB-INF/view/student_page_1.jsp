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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<c:set value="${student}" var="currentUser"/>
<c:set value="${all}" var="allcourse"/>

<c:choose>

    <c:when test="${currentUser.isBlocked eq true}">
        <h1 style="background-color: red">You Are Blocked</h1>
    </c:when>
    <c:otherwise>

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
                            <a class="nav-link" href="/">
                                <button type="button" class="btn btn-outline-primary">My courses</button>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/">
                                <button type="button" class="btn btn-outline-primary">Profile settings</button>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/start">
                                <button type="button" class="btn btn-outline-primary">Log out</button>
                            </a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="text" placeholder="Search">
                        <button class="btn btn-outline-primary" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <hr>
        <br>

        <c:choose>
            <c:when test="${courses.size() == 0}">
                <h1>There is no any Course to buy</h1>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <c:forEach items="${allcourse}" var="courses">
                        <div class="card" style="width: 18rem; background-color: aqua;padding: 1%" class="col-6 offset-3">
                            <img style="padding: 2%"
                                 src="data:image/png;base64, ${courses.img}"
                                 class="card-img-top" alt="Here should be image">
                            <div class="card-body">
                                <h5 class="card-title">${courses.course.name}</h5>
                                <p class="card-text">Description: ${courses.course.description}</p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item" style="background-color: aqua">price: ${courses.course.price}</li>
                                <li class="list-group-item"  style="background-color: aqua">category: ${courses.course.category}</li>
                            </ul>
                            <div class="card-body">
                                <a href="#" class="card-link">
                                    <button type="button" class="btn btn-outline-success">Buy Now</button>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>


    </c:otherwise>

</c:choose>
</body>
</html>
