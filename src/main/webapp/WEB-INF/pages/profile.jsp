<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 21.04.2020
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Данные пользователя</title>
</head>
<body>
    <a href="/goods">Товары</a>
    <a href="/orders">Заказы</a>
    <a href="/basket">Корзина</a>
    <c:if test="${empty buyer.name}">
        <a href="/addProfile">Профиль</a>
    </c:if>
    <c:if test="${!empty buyer.name}">
        <a href="/profile">Профиль</a>
    </c:if>

    <h2>Данные пользователя</h2>
    <table>
        <tr>
            <td>Имя</td>
            <td>${buyer.name}</td>
        </tr>
        <tr>
        <tr>
            <td>Почта</td>
            <td>${buyer.email}</td>
        </tr>
        <tr>
            <td>Телефон</td>
            <td>${buyer.phone}</td>
        </tr>
        <tr>
            <td>Адрес</td>
            <td>${buyer.address}</td>
        </tr>
    </table>
</body>
</html>
