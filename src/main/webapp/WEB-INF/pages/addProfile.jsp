<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 21.04.2020
  Time: 11:22
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
    <a href="/addProfile">Профиль</a>

    <c:url value="/addProfile" var="var"/>

    <form action="${var}" method="POST">
        <table>
            <tr>
               <td><label for="name">Имя</label>
                   <input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td><label for="email">Почта</label>
                    <input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td><label for="phone">Телефон</label>
                    <input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td><label for="address">Адрес</label>
                    <input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Сохранить"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
