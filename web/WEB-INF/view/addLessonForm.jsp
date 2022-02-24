<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/21/2022
  Time: 1:21 AM
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

<c:set var="module_id" value="${module_id}"/>

<form action="/addLesson/${module_id}" method="post" style="width: 600px" class="col-6 offset-3">
    Input Lesson name <br><br>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping">📚</span>
        <input type="text" name="name" class="form-control" placeholder="Lesson name" aria-label="Username"
               aria-describedby="addon-wrapping">
    </div>
    <br><br>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping1">📚</span>
        <input type="text" name="url" class="form-control" placeholder="video url" aria-label="Username"
               aria-describedby="addon-wrapping1">
    </div>
    <br><br>
    <input type="submit" style="background-color: green" value="Save Lesson">
</form>

</body>
</html>
