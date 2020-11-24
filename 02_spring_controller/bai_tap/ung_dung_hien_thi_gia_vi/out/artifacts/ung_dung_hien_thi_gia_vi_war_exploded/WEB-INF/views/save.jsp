<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/23/2020
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form style="text-align: center">
    <h1 style="color: red">List Condiment Of Sandwich :</h1>
<c:forEach items="${condiment}" var="eat">
    <h1 style="color: aqua">${eat}</h1>
</c:forEach>
</form>
</body>
</html>
