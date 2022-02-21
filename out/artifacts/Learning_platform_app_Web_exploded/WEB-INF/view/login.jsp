<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/19/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>


        <form action="/login" method="post" class="col-6 offset-3" style="width: 500px">
            <h1></h1>
            <h1>Registeration Form</h1>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">💌</span>
                <input type="email" class="form-control" name="email" placeholder="email" aria-label="Username" aria-describedby="basic-addon1">
            </div><br>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon2">⚠</span>
                <input type="password" class="form-control" name="password" placeholder="Password" aria-label="Username" aria-describedby="basic-addon2">
            </div><br>
            <button type="submit" class="btn btn-success">Log in</button>
            <p>create new account<a href="/register">sign up</a></p>
        </form>


</body>
</html>
