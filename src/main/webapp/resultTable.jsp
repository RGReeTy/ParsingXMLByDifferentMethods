<%--
  Created by IntelliJ IDEA.
  User: RGReeTy
  Date: 18.04.2020
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Result</title>
</head>
<body>
<h1 align="center">Orders list:</h1>
<table border="1" align="center" width="90%">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Firstname</th>
        <th scope="col">Lastname</th>
        <th scope="col">Start Date</th>
        <th scope="col">Tour</th>
        <th scope="col">Tour Type</th>
        <th scope="col">Number Of Days</th>
        <th scope="col">Transport</th>
        <th scope="col">Country</th>
        <th scope="col">Price</th>
        <th scope="col">Visa needed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="TourOrder" items="${OrdersSet}" varStatus="status">
        <tr align="center">
            <td><c:out value="${TourOrder.id}"/></td>
            <td><c:out value="${TourOrder.firstname}"/></td>
            <td><c:out value="${TourOrder.lastname}"/></td>
            <td><c:out value="${TourOrder.date}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.tourDescription}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.tourType}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.numberOfDays}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.transportType}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.country}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.price}"/></td>
            <td><c:out value="${TourOrder.tourSpecification.visaNeeded}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<form action="index.jsp">
    <button type="submit" style="width: 200px; height: 150px">Back to main</button>
</form>
</body>
</html>
