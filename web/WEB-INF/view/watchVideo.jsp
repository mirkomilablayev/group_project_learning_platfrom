<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/21/2022
  Time: 1:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Watch Video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set value="${url}" var="url"/>
<c:set value="${modul_id}" var="id"/>
<c:set var="tasks" value="${tasks}"/>

<iframe style="margin-left: 250px" width="800" height="500"
        src="https://www.youtube.com/embed/${url}"
        title="YouTube video player"
        allow="accelerometer; autoplay; clipboard-write;
  encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen>
</iframe>
<br><br><br>
<a href="/moreInfoModul/${id}"><button style="background-color: darkgray">Back</button></a>

<br><hr>

<h6>${tasks}</h6>

</body>
</html>
