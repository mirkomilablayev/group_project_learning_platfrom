<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Take Quiz Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>


<c:set var="tasks" value="${quiz}"/>
<c:set var="user_id" value="${user_id}"/>
<c:set var="lesson_id" value="${lesson_id}"/>


<h1>Quis is Started</h1>

<form action="/checkQuiz/${user_id}/${lesson_id}" method="post">

    <h3>Question:${tasks.get(0).task.task}</h3>
    <select class="form-select" name="TEST1" aria-label="Default select example">
        <option value="${tasks.get(0).option.get(0).answer}">A ${tasks.get(0).option.get(0).answer}</option>
        <option value="${tasks.get(0).option.get(1).answer}">B ${tasks.get(0).option.get(1).answer}</option>
        <option value="${tasks.get(0).option.get(2).answer}">C ${tasks.get(0).option.get(2).answer}</option>
        <option value="${tasks.get(0).option.get(3).answer}">D ${tasks.get(0).option.get(3).answer}</option>
    </select>


    <h3>Question:${tasks.get(1).task.task}</h3>
    <select class="form-select" name="TEST2" aria-label="Default select example">
        <option value="${tasks.get(1).option.get(0).answer}">A ${tasks.get(1).option.get(0).answer}</option>
        <option value="${tasks.get(1).option.get(1).answer}">B ${tasks.get(1).option.get(1).answer}</option>
        <option value="${tasks.get(1).option.get(2).answer}">C ${tasks.get(1).option.get(2).answer}</option>
        <option value="${tasks.get(1).option.get(3).answer}">D ${tasks.get(1).option.get(3).answer}</option>
    </select>

    <h3>Question:${tasks.get(1).task.task}</h3>
    <select class="form-select" name="TEST3" aria-label="Default select example">
        <option value="${tasks.get(1).option.get(0).answer}">A ${tasks.get(1).option.get(0).answer}</option>
        <option value="${tasks.get(1).option.get(1).answer}">B ${tasks.get(1).option.get(1).answer}</option>
        <option value="${tasks.get(1).option.get(2).answer}">C ${tasks.get(1).option.get(2).answer}</option>
        <option value="${tasks.get(1).option.get(3).answer}">D ${tasks.get(1).option.get(3).answer}</option>
    </select>
    <input type="submit" style="background-color: cadetblue;" value="Check My Result">
</form>


</body>
</html>
