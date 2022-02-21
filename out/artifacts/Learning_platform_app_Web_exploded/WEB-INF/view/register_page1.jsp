<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/19/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<form action="/register" class="col-6 offset-3" method="post" style="width: 500px">
    <h1>Registration Form</h1>
    <div class="input-group">
        <span class="input-group-text">Full name</span>
        <input type="text" name="firstname" aria-label="First name" class="form-control">
        <input type="text" name="lastname" aria-label="Last name" class="form-control">
    </div><br>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping">@</span>
        <input type="text" name="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
    </div><br>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon3">💸</span>
        <input type="number" class="form-control" name="balance" placeholder="Balance" aria-label="Username" aria-describedby="basic-addon3">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon1">💌</span>
        <input type="email" class="form-control" name="email" placeholder="email" aria-label="Username" aria-describedby="basic-addon1">
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon2">⚠</span>
        <input type="password" class="form-control" name="password" placeholder="Password" aria-label="Username" aria-describedby="basic-addon2">
    </div>
    <div class="form-floating">
        <textarea class="form-control" name="bio" placeholder="Bio" id="floatingTextarea"></textarea>
        <label for="floatingTextarea">Bio</label>
    </div>
    <br>
    <select name="who" class="form-select" aria-label="Default select example">
        <option value="Mentor">Mentor</option>
        <option value="Student">Student</option>
    </select>
    <br>
    <button type="submit" class="btn btn-success">Register</button>
    <p>If already exist <a href="/login">log in</a></p>
</form>


</body>
</html>
