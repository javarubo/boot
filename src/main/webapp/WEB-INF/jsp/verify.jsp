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




<form action="/v2/user/verify" method="post">
    <b>
        email
    </b></br>
    <input type="email" name="email" size="40" >
    </br>
    <b>
        code
    </b></br>
    <input type="text" name="code" size="40" >
    </br>

    <input type="submit" value="verify"/>
</form>


<c:if test="${not empty message}">
    <p id="panel">${message}</p>
</c:if>
</body>
</html>
