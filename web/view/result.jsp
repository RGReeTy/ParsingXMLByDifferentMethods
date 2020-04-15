<%--
  Created by IntelliJ IDEA.
  User: RGReeTy
  Date: 15.04.2020
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Result of parsing</title>

</head>
<body>
<h1 align="center">All tourist vouchers: </h1>
<table border="2" align="center" width="80%">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Voucher type</th>
        <th scope="col">Country</th>
        <th scope="col">Date</th>
        <th scope="col">Number Days</th>
        <th scope="col">Transport type</th>
        <th scope="col">Hotel stars</th>
        <th scope="col">Meal type</th>
        <th scope="col">Rooms number</th>
        <th scope="col">Air condition</th>
        <th scope="col">Tv</th>
        <th scope="col">Wifi</th>
        <th scope="col">Parking</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="vouchersSet" items="${resultSet}" varStatus="status">
        <tr align="center">
            <td><c:out value="${vouchersSet.id}"/></td>
            <td><c:out value="${vouchersSet.voucherType}"/></td>
            <td><c:out value="${vouchersSet.country}"/></td>
            <td><c:out value="${vouchersSet.date}"/></td>
            <td><c:out value="${vouchersSet.numberDays}"/></td>
            <td><c:out value="${vouchersSet.transportType}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.starsNumber}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.mealType}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.numberOfRooms}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.airCondition}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.tv}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.wifi}"/></td>
            <td><c:out value="${vouchersSet.hotelSpecification.parking}"/></td>
            <td><c:out value="${vouchersSet.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
