<%@ page import="uz.pdp.model.Comment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/20/2022
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>One Course Definition</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>


<c:set var="course" value="${course}"/>


<div class="card mb-3" style="max-width: 600px;border-color: black;background-color: aqua">
    <div class="row g-0">
        <div class="col-md-4">
            <img style="padding: 2%;border-color: black"
                 src="data:image/png;base64, ${course.img}"
                 class="card-img-top" alt="Here should be image">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">Course Name: <strong>${course.course.name}</strong></h5>
                <p class="card-text">Description: <strong>${course.course.description}</strong></p>
                <p class="card-text">Price: <strong>${course.course.price}</strong></p>
                <p class="card-text">Category: <strong>${course.course.category}</strong></p>
                <p class="card-text"><small class="text-muted">Uploaded at:
                    <strong>${course.course.uploaded_at}</strong></small></p>
                <c:choose>
                    <c:when test="${course.course.inProgres eq true}">
                        <a class="btn btn-secondary btn-lg disabled" role="button" aria-disabled="true">Checking....</a>
                        <a href="/remoreRequest/${course.course.id}">
                            <button>❌</button>
                        </a>
                    </c:when>
                    <c:when test="${course.course.isAccepted eq false}">
                        <a href="/sendRequest/${course.course.id}">
                            <button type="button" class="btn btn-outline-success">Request to Admin</button>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-secondary btn-lg disabled" role="button" aria-disabled="true">Request is
                            Accepted</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>

<hr>
<a href="/back/${course.course.owner}">
    <button style="background-color: red">Back</button>
</a>
<c:choose>
    <c:when test="${course.course.isAccepted eq false}">
        <a href="/addModule/${course.course.owner}/${course.course.id}">
            <button style="background-color: green">+ Add Module</button>
        </a>
    </c:when>
</c:choose>
<br>


<c:choose>
    <c:when test="${course.modules.size() == 0}">
        <h1 style="background-color: red">There is no any Modules ,Now you can Add new Module for this course</h1>
    </c:when>
    <c:otherwise>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Module name</th>
                <th scope="col">button</th>
                <th scope="col">button</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="module" items="${course.modules}">
                <tr>
                    <th scope="row">💛</th>
                    <td>${module.name}</td>
                    <td><a href="/moreInfoModul/${module.id}">
                        <button style="background-color: rgba(51,0,128,0.92);">More</button>
                    </a></td>
                    <td><a href="/deleteModule/${module.id}/${course.course.id}">
                        <button style="background-color: red;">Delete</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>


</body>
</html>
