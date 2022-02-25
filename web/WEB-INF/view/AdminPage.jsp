<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/23/2022
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set var="admin" value="${student}"/>




<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="spinner-border text-success" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/requests/${admin.id}">  <button type="button" class="btn btn-outline-primary">Requests</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">  <button type="button" class="btn btn-outline-primary">Users</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">  <button type="button" class="btn btn-outline-primary">Courses</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">  <button type="button" class="btn btn-outline-primary">Profile Settings</button></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">  <button type="button" class="btn btn-outline-primary">Log out</button></a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search users,courses">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<h1 style="color: green">Admin Of The Best Of The Best Team</h1>
<h2 style="color: #502188">Full Name: ${admin.firstName} ${admin.lastName}</h2>
<h2 style="color: green">Username: ${admin.username}</h2>
<h2 style="color: #591983">Email:${admin.email}</h2>
<h2 style="color: green">Bio:${admin.bio}</h2>
<h2 style="color: #5c1181">Register At:${admin.register_at}</h2>
<hr>
<h1>Our Teacher: Abrorjon Ergashev</h1>
<h3>Member of Team: Asilbek</h3>
<h3>Member of Team: Muhammad</h3>
<h3>Member of Team: Sardor</h3>
<h3>Member of Team: Oloviddin</h3>
<h3>Member of Team: Mirkomil</h3>


</body>
</html>
