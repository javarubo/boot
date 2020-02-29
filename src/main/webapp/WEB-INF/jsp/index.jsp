<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: georgi.bagiryan
  Date: 12/26/2019
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>




<form action="/login" method="post">
    <b>
        login
    </b></br>
    <input type="text" name="username" size="40" >
    </br>
    <b>
        password
    </b></br>
    <input type="password" name="password" size="40" >
    </br>
    <input type="checkbox" name="remember" value="true"> Remember me    </br>
    <input type="submit" value="Log in"/>
</form>
<button onclick="window.location.href = '/goto-register';">Register</button> </br>

<button onclick="window.location.href = '/goto-verify';">verify</button> </br>

<button onclick="window.location.href = '/goto-recovery';">forgotpassword</button> </br>

<c:if test="${not empty message}">
    <p id="panel">${message}</p>
</c:if>
</body>
</html>
