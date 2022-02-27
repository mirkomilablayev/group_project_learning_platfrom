<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>watch video page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:set value="${video_url}" var="url"/>
<c:set value="${lesson_id}" var="id"/>
<c:set var="user_id" value="${user_id}"/>



<iframe style="margin-left: 250px" width="800" height="500"
        src="https://www.youtube.com/embed/${url}"
        title="YouTube video player"
        allow="accelerometer; autoplay; clipboard-write;
  encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen>
</iframe>
<br>
<br>
<hr>
<a href="/startQuiz/${user_id}/${lesson_id}"><button style="background-color: #591983">Start Quiz</button></a>


</body>
</html>
