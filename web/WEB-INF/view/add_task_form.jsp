<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/23/2022
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set value="${module_id}" var="module_id"/>
<c:set value="${lesson_id}" var="lesson_id"/>

<form action="/addLessonTask/${module_id}/${lesson_id}" method="post" style="width: 600px" class="col-6 offset-3">
        <h1>Creating Question</h1>

    <div class="form-floating">
        <textarea class="form-control" name="question"  id="floatingTextarea"></textarea>
        <label for="floatingTextarea">Question</label>
    </div>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping2">A</span>
        <input type="text" class="form-control" name="A" placeholder="First answer" aria-label="Username" aria-describedby="addon-wrapping2">
    </div>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping3">B</span>
        <input type="text" class="form-control" name="B" placeholder="Second answer" aria-label="Username" aria-describedby="addon-wrapping3">
    </div>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping4">C</span>
        <input type="text" class="form-control" name="C" placeholder="Third answer" aria-label="Username" aria-describedby="addon-wrapping4">
    </div>
    <div class="input-group flex-nowrap">
        <span class="input-group-text" id="addon-wrapping5">D</span>
        <input type="text" class="form-control" name="D" placeholder="Fourth answer" aria-label="Username" aria-describedby="addon-wrapping5">
    </div>
    <p><strong>Which one will be correct ???</strong></p>
    <select name="correct" class="form-select" aria-label="Default select example">
        <option value="A">A will be correct</option>
        <option value="B">B  will be correct</option>
        <option value="C">C  will be correct</option>
        <option value="D">D  will be correct</option>
    </select>
<input type="submit" value="+ Add task" style="background-color: green">
</form>


</body>
</html>
