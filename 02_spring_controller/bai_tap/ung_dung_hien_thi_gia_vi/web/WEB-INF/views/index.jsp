<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/23/2020
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/save" style="text-align: center">
    <h1 style="color: red">What kind of food would you like to eat ?</h1>
    <td style="color: green"><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
    <td style="color: aqua"><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
    <td style="color: chartreuse"><input  type="checkbox" name="condiment" value="Mustard">Mustard</td>
    <td style="color: darkorange"><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
    <td ><input  type="submit" value="save"></td>
</form>
</body>
</html>
