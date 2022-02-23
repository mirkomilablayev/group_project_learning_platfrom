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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<c:set var="currentUser" value="${mentor}"/>
<c:set value="${courses}" var="course"/>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid" style="background-color: blueviolet;">
        <a><strong>${currentUser.firstName} ${currentUser.lastName} </strong></a>
        <a class="navbar-brand" href="#"><button type="button" class="btn btn-primary"> Profile Settings</button></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/addCourse/${currentUser.id}"><button type="button" class="btn btn-success">+Add New Course</button></a>
                <a class="nav-link active" aria-current="page" href="/login"><button type="button" class="btn btn-success">Log out</button></a>
            </div>
        </div>
    </div>
</nav>

<c:choose>
    <c:when test="${course.size() == 0}">
        <h1 style="background-color: red">You don't have any Course yet</h1>
    </c:when>
    <c:otherwise>
        <div class="row">
                <c:forEach var="c" items="${courses}">
                    <div class="card;" class="col-10 offset-1"  style="width: 18rem;background-color: aqua;border-color: blue;margin: 2%">
                        <img style="padding: 2%"
                             src="data:image/png;base64, ${c.img}"
                             class="card-img-top" alt="Here should be image">
                        <div class="card-body">
                            <p class="card-title"><strong>Course Name:</strong>${c.course.name}</p>
                            <p class="card-text"><strong>Description:</strong>${c.course.description}</p>
                            <a href="/more/${c.course.id}" class="btn btn-primary">
                                <button style="width: 75px;background-color: cadetblue">More</button>
                            </a>
                            <a href="/deleteCourse/${c.course.id}/${currentUser.id}" class="btn btn-primary">
                                <button style="background-color: red;width: 75px">Delete</button>
                            </a>
                        </div>
                    </div>
                </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
