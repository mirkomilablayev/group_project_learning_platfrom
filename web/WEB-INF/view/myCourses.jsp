<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/26/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<c:set var="user_id" value="${user_id}"/>
<c:set var="courses" value="${courses}"/>

<a href="/backToUserPage/${user_id}"><button style="background-color: aquamarine">Back To User Page</button></a>


<c:choose>
    <c:when test="${courses.size() == 0}">
        <h1>You don't have Any course</h1>
    </c:when>
    <c:otherwise>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Author</th>
                <th scope="col">Button</th>
                <th scope="col">Button</th>
                <th scope="col">Button</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <th scope="row">❤</th>
                    <td>${course.course.name}</td>
                    <td>${course.course.price}</td>
                    <c:forEach items="${course.users}" var="m">
                        <c:choose>
                            <c:when test="${m.user.id == user_id && m.course.id == course.course.id}">
                                <c:choose>
                                    <c:when test="${m._like eq true}">
                                        <td><a href="/likecourse/${user_id}/${m.id}">
                                            <button type="button" class="btn btn-outline-success">Unlike</button>
                                        </a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="/likecourse/${user_id}/${m.id}">
                                            <button type="button" class="btn btn-outline-success">Like</button>
                                        </a></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                    <td><a href="#">
                        <button type="button" class="btn btn-outline-info">Write Comment</button>
                    </a></td>
                    <td><a href="#">
                        <button type="button" class="btn btn-outline-primary">Start Learning</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>


</body>
</html>
