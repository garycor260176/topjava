<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style type="text/css">
        table, th, td {
            border: solid black 1px;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table style="border: solid black 1px;">
    <tr>
        <th>DateTime</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>
    <c:forEach var="meal" items="${meals}">
        <tr style="color: ${ meal.excess ? 'red' : 'green'}">
            <td>${f:formatDateTime(meal.dateTime)}</td>
            <td>${meal.description}</td>
            <td align="right">${meal.calories}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>