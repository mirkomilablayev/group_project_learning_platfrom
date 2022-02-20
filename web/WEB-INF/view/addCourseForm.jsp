<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/20/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="user_id" value="${user_id}"/>


<form action="/addCourse/${user_id}" method="post" enctype="multipart/form-data" >
    <input type="text" name="courseName" placeholder="Course name"><br><br>
    <input type="number" name="price" placeholder="Course Price"><br><br>
    <textarea class="form-control" name="description" placeholder="Description" id="floatingTextarea2" style="height: 100px"></textarea><br><br>
    <input type="file" class="file" name="textFile" /><br><br>
    category <br>
    <select name="category">
       <c:forEach var="c" items="${categories}">
           <option value="${c.id}">${c.name}</option>
       </c:forEach>
    </select><br><br>
    <input type="submit" value="+ Add Course" style="background-color: green;">
</form>


</body>
</html>
