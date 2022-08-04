<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">--%>
    <style>

    </style>
</head>
<body class="border-black">
<div align="center">
    <h1>Create new staff</h1>
</div>
<div align="center" >
<%--<p>--%>
<%--    <c:if test='${requestScope["message"] != null}'>--%>
<%--        <span class="message">${requestScope["message"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<p>
    <a href="/staff">Back to staff list</a>
</p>

<form action="/staff?action=create" method="post">
    <fieldset style=" border: #fd7e14 1px;">
        <legend>Staff information</legend>
        <table>
            <%--            <tr>--%>
            <%--                <td>Id:</td>--%>
            <%--                <td><input type="text" name="id" id="id"></td>--%>
            <%--            </tr>--%>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Birth:</td>
                <td><input type="date" name="birth" id="Birth"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Department:</td>
                <td><select name="phongban" id="phongban">
                    <c:forEach var="c" items="${phongban}">
                        <option value="${c.id}">${c.tenPB}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Staff"></td>
            </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
