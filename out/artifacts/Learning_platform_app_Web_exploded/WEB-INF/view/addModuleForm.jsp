<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/20/2022
  Time: 8:11 PM
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
<c:set var="course_id" value="${course_id}"/>
<c:set var="course" value="${course}"/>



<form action="/addModule/${user_id}/${course_id}/${course}"  style="width: 600px" class="col-6 offset-3" method="post">
    Module Name <br>
<%--    <input type="text" name="name" placeholder="Module Name"><br><br>--%>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping">📚</span>
        <input type="text" name="name" class="form-control" placeholder="Module Name" aria-label="Username"
               aria-describedby="addon-wrapping">
    </div>
    Module Description <br>
<%--    <textarea name="description" placeholder="Module Description"></textarea><br><br>--%>
    <textarea class="form-control" name="description" placeholder="Description" id="floatingTextarea2"
              style="height: 100px"></textarea><br><br>
    <input type="submit" value="Add module">
</form>


</body>
</html>
