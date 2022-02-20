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
    <title>Title</title>

</head>
<body>


<c:set var="course" value="${course}"/>


<div class="card bg-dark text-white" style="border-color: red; background-color: aquamarine">
    <img style="padding: 2%;"
         src="data:image/png;base64, ${course.img}"
         class="card-img-top" alt="Here should be image">
    <div class="card-img-overlay">
        <h5 class="card-title">Course Name: ${course.course.name}</h5>
        <p class="card-text">Course Description: ${course.course.description}</p>
        <p class="card-text">Price: ${course.course.description}</p>
        <p class="card-text">Category: ${course.course.category}</p>
        <p class="card-text">Uploaded At ${course.course.uploaded_at}</p>
        <br><br>
    </div>
</div>
<hr>
<br><br>
<a href="/back/${course.course.owner}">
    <button style="background-color: red">Back</button>
</a>
<a href="/addModule/${course.course.owner}/${course.course.id}">
    <button style="background-color: green">+ Add Module</button>
</a>
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
                <th scope="col">button</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="module" items="${course.modules}">
                <tr>
                    <th scope="row">💛</th>
                    <td>${module.name}</td>
                    <td><a href="#/${module.id}">
                        <button style="background-color: green;">Edit</button>
                    </a></td>
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
