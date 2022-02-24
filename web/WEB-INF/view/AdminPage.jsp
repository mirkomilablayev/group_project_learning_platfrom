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
                    <a class="nav-link" href="#">  <button type="button" class="btn btn-outline-primary">Requests</button></a>
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

<h1></h1>



</body>
</html>
