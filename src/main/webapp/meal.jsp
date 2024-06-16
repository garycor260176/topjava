<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h3>${ param.action == "edit" ? 'Edit meal' : 'New meal'}</h3>

<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
<form method="POST" action='meals'>
    <input type="hidden" name="id" value="${meal.id}"/>
    <table>
        <tr>
            <td>DateTime:</td>
            <td>
                <input type="datetime-local" name="dateTime" value="${meal.dateTime}"/>
            </td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" size="100" value="${meal.description}"/></td>
        </tr>
        <tr>
            <td>Calories:</td>
            <td><input type="number" name="calories" value="${meal.calories}"/></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
    <button type="button" onclick="window.location.href='meals'">Cancel</button>
</form>
</body>
</html>