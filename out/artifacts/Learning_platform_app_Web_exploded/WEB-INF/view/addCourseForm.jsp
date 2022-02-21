<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/20/2022
  Time: 9:37 AM
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

<c:set var="user_id" value="${user_id}"/>

<a href="/back//${user_id}"><button style="background-color: bisque">Back</button></a>

<div style="width: 600px;border-color: black" class="col-6 offset-3">
    <form action="/addCourse/${user_id}"  method="post"
          enctype="multipart/form-data">
        <h1>Add Course Form</h1>
        <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping">📚</span>
            <input type="text" name="courseName" class="form-control" placeholder="Course Name" aria-label="Username"
                   aria-describedby="addon-wrapping">
        </div>
        <br>
        <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping2">💸</span>
            <input type="number" name="price" class="form-control" placeholder="Course Price" aria-label="Course Price"
                   aria-describedby="addon-wrapping2">
        </div>
        <br>
        <textarea class="form-control" name="description" placeholder="Description" id="floatingTextarea2"
                  style="height: 100px"></textarea><br><br>
        Select File: <input type="file" name="file"/><br><br>
        category <br>
        <select name="category" class="form-select" aria-label="Default select example">
            <c:forEach var="c" items="${categories}">
                <option value="${c.name}">${c.name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="+ Add Course" style="background-color: green;">
    </form>
</div>

</body>
</html>
