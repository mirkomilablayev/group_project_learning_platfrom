<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/26/2022
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<c:set value="${admin_id}" var="admin_id"/>
<c:set value="${userList}" var="users1"/>


<a href="/backToAdminMenu/${admin_id}">
    <button type="button" class="btn btn-outline-success">Back</button>
</a>
<hr>
<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">name</th>
        <th scope="col">role</th>
        <th scope="col">button</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${userList}">
        <c:choose>
            <c:when test="${!u.role.equals('Admin')}">
                <tr>
                    <th scope="row">❤</th>
                    <td>${u.firstName} ${u.lastName}</td>
                    <td>${u.role}</td>
                    <c:choose>
                        <c:when test="${u.isBlocked eq true}">
                            <td><a href="/blockUnblock/${admin_id}/${u.id}"><button type="button" class="btn btn-outline-success">UnBlock</button></a></td>
                        </c:when>
                        <c:when test="${u.isBlocked eq false}">
                            <td><a href="/blockUnblock/${admin_id}/${u.id}"><button type="button" class="btn btn-outline-danger">Block</button></a></td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:when>
        </c:choose>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
