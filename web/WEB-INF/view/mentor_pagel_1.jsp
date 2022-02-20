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
<h1>Assalomu alaykum mentor panelga,,,${currentUser.firstName}</h1>

<a href="/addCourse/${currentUser.id}">
    <button style="background-color: green">+ Add Course</button>
</a>
<hr>


<c:choose>
    <c:when test="${course.size() == 0}">
        <h1 style="background-color: red">You don't have any picture yet</h1>
    </c:when>
    <c:otherwise>
        <div class="row">
            <c:forEach var="c" items="${courses}">
                <div class="card" style="width: 18rem;background-color: aqua;border-color: blue;"
                     class="col-8 offset-2">
                    <img style="padding: 2%;"
                         src="data:image/png;base64, ${c.img}"
                         class="card-img-top" alt="Here should be image">
                    <div class="card-body">
                        <p class="card-title"><strong>Course Name:</strong>${c.course.name}</p>
                        <p class="card-text"><strong>Description:</strong>${c.course.description}</p>
                        <p><strong>Like:</strong> ${c.likeCount} -- <strong>Comments:</strong> ${c.commentCount}</p>
                        <br>
                        <a href="#" class="btn btn-primary">
                            <button>More Info</button>
                        </a>
                        <a href="/deleteCourse/${c.course.id}/${currentUser.id}" class="btn btn-primary">
                            <button style="background-color: red">Delete</button>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
