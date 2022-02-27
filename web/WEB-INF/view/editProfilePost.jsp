<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 12:34 PM
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

<c:set var="current_user" value="${user_id}"/>



<form action="/editProfile/${current_user.id}" class="col-6 offset-3" method="post" style="width: 500px">
    <h1>Edit Profile</h1>
    <div class="input-group">
        <span class="input-group-text">Full name</span>
        <input type="text" name="firstname" value="${current_user.firstName}" aria-label="First name" class="form-control">
        <input type="text" name="lastname" value="${current_user.lastName}" aria-label="Last name" class="form-control">
    </div><br>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping">@</span>
        <input type="text" name="username" value="${current_user.username}" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
    </div><br>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">💌</span>
        <input type="email" class="form-control" value="${current_user.email}" name="email" placeholder="email" aria-label="Username" aria-describedby="basic-addon1">
    </div>
    <div class="form-floating">
        <textarea class="form-control" name="bio" value="${current_user.bio}" placeholder="Bio" id="floatingTextarea"></textarea>
        <label for="floatingTextarea">Bio</label>
    </div>
    <br>
    <button type="submit" class="btn btn-success">Edit</button>
    <c:choose>
        <c:when test="${current_user.role.equalsIgnoreCase('Admin')}">
            <a href="/profileSettigs/${current_user.id}" class="card-link">
                <button type="button" class="btn btn-outline-danger">Back</button>
            </a>
        </c:when>
        <c:when test="${current_user.role.equalsIgnoreCase('Student')}">
            <a href="/profileSettigs/${current_user.id}" class="card-link">
                <button type="button" class="btn btn-outline-danger">Back</button>
            </a>
        </c:when>
        <c:when test="${current_user.role.equalsIgnoreCase('Mentor')}">
            <a href="/profileSettigs/${current_user.id}" class="card-link">
                <button type="button" class="btn btn-outline-danger">Back</button>
            </a>
        </c:when>
    </c:choose>
</form>





</body>
</html>
