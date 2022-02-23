<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/21/2022
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set value="${module}" var="module"/>

<div class="card" style="background-color: olivedrab">
    <div class="card-header">
        Module
    </div>
    <div class="card-body">
        <h5 class="card-title">Name: ${module.module.name}</h5>
        <p class="card-text">Description: ${module.module.description}</p>
        <p class="card-text">Author: ${module.module.user.firstName} ${module.module.user.lastName}</p>
        <p class="card-text">Course Name: ${module.module.course.name}</p>
        <a href="#" style="background-color: green" class="btn btn-primary">Edit</a>
    </div>
</div>

<hr>
<br>
<a href="/addLesson/${module.module.id}"><button style="background-color: green">+Add Lesson</button></a>
<br>
<br>
<c:choose>
    <c:when test="${module.lessons.size() == 0}">
        <h1 style="background-color: red">There is no Video</h1>
    </c:when>
    <c:otherwise>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">name</th>
                <th scope="col">button</th>
                <th scope="col">Tasks</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lesson" items="${module.lessons}">
                <tr>
                    <th scope="row">💚</th>
                    <td><a href="/watch/${lesson.video_url}/${module_id}/${lesson.id}">${lesson.name}</a></td>
                    <td><a href="/addLessonTask/${module_id}/${lesson.id}">
                        <button STYLE="background-color: green">+Add Task To This Lesson</button>
                    </a></td>
                    <td><strong>Tasks count : ${lesson.taskCount}</strong></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>
