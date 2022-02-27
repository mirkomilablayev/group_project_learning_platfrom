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
    <c:forEach var="test" items="${tasks}">
        <select class="form-select" name="TEST${test.task.id}" aria-label="Default select example">
            Question:${test.task.task}
            <option value="${test.option.get(0).id}">A ${test.option.get(0).answer}</option>
            <option value="${test.option.get(1).id}">B ${test.option.get(1).answer}</option>
            <option value="${test.option.get(2).id}">C ${test.option.get(2).answer}</option>
            <option value="${test.option.get(3).id}">D ${test.option.get(3).answer}</option>
        </select>
    </c:forEach>
    <input type="submit" style="background-color: cadetblue;" value="Check My Result">
</form>


</body>
</html>
