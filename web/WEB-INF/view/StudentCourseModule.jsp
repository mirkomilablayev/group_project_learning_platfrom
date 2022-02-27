<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Course Module</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>

<c:set var="user_id" value="${user_id}"/>
<c:set value="${module}" var="modules"/>


<hr><br>


<table class="table">
<thead>
<tr>
    <th scope="col">#</th>
    <th scope="col">Name</th>
    <th scope="col">Button</th>

</tr>
</thead>
<tbody>

<c:forEach var="module" items="${module}">
<tr>
    <th scope="row">❤</th>
    <td>${module.name}</td>
    <td><a href="/lessons/${user_id}/${module.id}"><button type="button" class="btn btn-primary btn-sm">Lessons</button></a></td>
</tr>
</c:forEach>
</tbody>
</table>



</body>
</html>
