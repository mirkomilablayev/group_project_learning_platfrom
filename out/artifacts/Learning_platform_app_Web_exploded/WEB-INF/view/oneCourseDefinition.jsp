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


<div class="card bg-dark text-white" style="border-color: red; background-color: aquamarine" >
    <img style="padding: 2%;"
         src="data:image/png;base64, ${course.img}" class="card-img"
         class="card-img-top" alt="Here should be image">
    <div class="card-img-overlay">
        <h5 class="card-title">Card title</h5>
        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        <p class="card-text">Last updated 3 mins ago</p>
    </div>
</div>
<hr><hr>


</body>
</html>
