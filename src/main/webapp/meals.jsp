<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .excess {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals for ${authUserId == 1 ? 'User' : 'Admin'}</h2>

    <form method="get" action="meals">
        <input type="hidden" name="action" value="filter">
        <table>
            <tr>
                <td>Start date:</td>
                <td><input type="date" value="${param.startDate}" name="startDate"></td>
                <td align="right">End date:</td>
                <td><input type="date" value="${param.endDate}" name="endDate"></td>
            </tr>
            <tr>
                <td>Start time:</td>
                <td><input type="time" value="${param.startTime}" name="startTime"></td>
                <td align="right">End time:</td>
                <td><input type="time" value="${param.endTime}" name="endTime"></td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <button type="submit">Set filter</button>
                </td>
            </tr>
        </table>
    </form>

    <br><br>
    <table border="0">
        <tr>
            <td align="right">
                <a href="meals?action=create">Add Meal</a>
            </td>
        </tr>
        <tr>
            <td>
                <table border="1" cellpadding="8" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Description</th>
                        <th>Calories</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <c:forEach items="${requestScope.meals}" var="meal">
                        <jsp:useBean id="meal" type="ru.javawebinar.topjava.to.MealTo"/>
                        <tr class="${meal.excess ? 'excess' : 'normal'}">
                            <td>
                                    <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                                    <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                                    <%--${fn:replace(meal.dateTime, 'T', ' ')}--%>
                                    ${fn:formatDateTime(meal.dateTime)}
                            </td>
                            <td>${meal.description}</td>
                            <td align="right">${meal.calories}</td>
                            <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                            <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</section>
</body>
</html>