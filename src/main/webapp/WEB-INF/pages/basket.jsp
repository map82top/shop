<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 22.04.2020
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
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

    <h2>Товары в корзине</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Наименование</th>
            <th>Цена</th>
            <th>Количество</th>
            <th>Сумма</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="goods" items="${basketGoods}">
            <tr>
                <td>${goods.id} </td>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td><input type="number"id="quantity" min="1" max="3" value="1"></td>
                <td>
                    <div id="sum${goods.id}"></div>
                    <script>
                        let sum${goods.id} = document.getElementById("sum${goods.id}");
                        sum${goods.id}.innerText = ${goods.price} * document.getElementById("quantity").value;
                    </script>
                </td>
                <td><a href="/basket/delete/${goods.id}">Убрать</a></td>
            </tr>
        </c:forEach>

    </table>

    <c:if test="${!empty buyer.name}">
        <h2>Оформление</h2>
        <c:url value="/goods/addGoods" var="add"/>
        <a href="${add}">Оформить заказ</a>
    </c:if>
    <c:if test="${empty buyer.name}">
        <h2>Заполните профиль!</h2>
    </c:if>

</body>
</html>
