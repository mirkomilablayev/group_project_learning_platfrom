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

<form action="/register" method="post">
    <h1>Registration Form</h1>
    <input type="text" name="firstname" placeholder="Firstname" ><br><br>
    <input type="text" name="lastname" placeholder="Last name"><br><br>
    <input type="text" name="username" placeholder="Username">  <br><br>
    <input type="number" name="balance" placeholder="Your Balance"><br><br>
    <input type="email" name="email" placeholder="Your email"><br><br>
    <input type="password" name="password" placeholder="Password">  <br><br>
    <textarea  placeholder="Bio" name="bio" style="height: 100px"></textarea><br>
    <select name="who" >
        <option value="Mentor">Mentor</option>
        <option value="Student">Student</option>
    </select><br><br>
    <input type="submit" style="background-color: green;" value="Register">
</form>


</body>
</html>
