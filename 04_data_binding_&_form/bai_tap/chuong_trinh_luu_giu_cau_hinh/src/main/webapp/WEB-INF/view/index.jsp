<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/24/2020
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1 style="color:aqua;">Settings</h1>
    <form:form method="get" action="/list" modelAttribute="ConfigurationObject">
        <form:label path="language">Language</form:label>
        <form:select path="language">
            <form:option value="English">English</form:option>
            <form:option value="Vietnamese">Vietnamese</form:option>
            <form:option value="Japanese">Japanese</form:option>
            <form:option value="Chinese">Chinese</form:option>
        </form:select>
        <br>
        <br>
        <form:label path="pageSize">Page Size</form:label>
        <form:select path="pageSize">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="25">25</form:option>
            <form:option value="50">50</form:option>
            <form:option value="100">100</form:option>
        </form:select>
        <br>
        <br>
        <form:label path="spamFilter">Spams Filter</form:label>
        <form:checkbox path="spamFilter" value="true"></form:checkbox>
        <label>Enable spams filtter</label>
        <br>
        <br>
        <form:label path="signature">Signature</form:label>
        <form:textarea path="signature"></form:textarea>
        <br>
        <br>
        <form:button>Update</form:button>
    </form:form>
</div>
</body>
</html>
