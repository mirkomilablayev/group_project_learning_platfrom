<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set value="${user_id}" var="user_id"/>

<form action="/addBalance/${user_id}" method="post" style="width: 300px">
    <div class="input-group mb-3">
        <span class="input-group-text" id="basic-addon2">Balance</span>
        <input type="number"  class="form-control" placeholder="BALANCE" name="balance" aria-label="Username" aria-describedby="basic-addon2">
    </div>
    <div class="input-group mb-3">

        <input style="width: 100px" type="submit" class="form-control" value="ADD" aria-label="Username" aria-describedby="basic-addon1">
    </div>
</form>

</body>
</html>
