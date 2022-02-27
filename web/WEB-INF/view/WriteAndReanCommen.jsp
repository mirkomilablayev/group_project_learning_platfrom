<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/27/2022
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/stylee.css" type="text/css">
</head>

<style>
    * {
        margin: 0;
        padding: 0;
        font-family: Tahoma, sans-serif;
        box-sizing: border-box;
    }

    body {
        background: #1ddced;
    }

    .chatbox {
        width: 500px;
        min-width: 390px;
        height: 600px;
        background: #fff;
        padding: 25px;
        margin: 20px auto;
        box-shadow: 0 3px #ccc;
    }

    .chatlogs {
        padding: 10px;
        width: 100%;
        height: 450px;
        background: #eee;
        overflow-x: hidden;
        overflow-y: scroll;
    }


    .chatlogs::-webkit-scrollbar {
        width: 10px;
    }


    .chatlogs::-webkit-scrollbar-thumb {
        border-radius: 5px;
        background: rgba(0, 0, 0, .1);
    }

    .chat {
        display: flex;
        flex-flow: row wrap;
        align-items: flex-start;
        margin-bottom: 10px;
    }

    .chat .user-photo {
        width: 60px;
        height: 60px;
        background: #ccc;
        border-radius: 50%;
    }

    .chat .chat-message {
        width: 70%;
        padding: 15px;
        margin: 5px 15px 0;
        border-radius: 10px;
        color: #fff;
        font-size: 20px;
    }

    .friend .chat-message {
        background: #1adda4;
    }

    .self .chat-message {
        background: #1ddced;
        order: -1;
    }


    .chat-form {
        margin-top: 20px;
        display: flex;
        align-items: flex-start;
    }

    .chat-form textarea {
        background: #fbfbfb;
        width: 75%;
        height: 50px;
        border: 2px solid #eee;
        border-radius: 3px;
        resize: none;
        padding: 10px;
        font-size: 18px;
        color: #333;
    }


    .chat-form textarea:focus {
        background: #fff;
    }

    .chat-form button {
        background: #1ddced;
        padding: 5px 15px;
        font-size: 30px;
        color: #fff;
        border: none;
        margin: 0 9px;
        border-radius: 3px;
        box-shadow: 0 3px 0 #0eb2c1;
        cursor: pointer;

        -webkit-transition: background .2s ease;
        -moz-transition: background .2s ease;
        -o-transition: background .2s ease;
    }

    .chat-form button:hover {
        background: #13c8c9;
    }
</style>

<body>

<c:set value="${comments}" var="comments" scope="session"/>
<c:set scope="session" var="user_id" value="${user_id}"/>
<c:set scope="session" var="course_id" value="${course_id}"/>


<div class="chatbox">
    <div class="chatlogs">
        <c:forEach var="message" items="${comments}">
            <c:choose>
                <c:when test="${message.user.id == user_id}">
                    <div class="chat self">
                        <div class="user-photo"></div>
                        <p class="chat-message">${message.title}</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="chat friend">
                        <div class="user-photo"></div>
                        <p class="chat-message">${message.title}</p>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
    <div class="chat-form">
        <form action="/writeComment/${user_id}/${course_id}" method="post">
        <textarea name="message"></textarea>
        <button>send</button>
        </form>
    </div>

</div>


</body>
</html>
