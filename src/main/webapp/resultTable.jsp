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
    <c:forEach var="orderSet" items="${resultSet}" varStatus="status">
        <tr align="center">
            <td><c:out value="${orderSet.id}"/></td>
            <td><c:out value="${orderSet.firstname}"/></td>
            <td><c:out value="${orderSet.lastname}"/></td>
            <td><c:out value="${orderSet.startDate}"/></td>
            <td><c:out value="${orderSet.tourSpecificationtour}"/></td>
            <td><c:out value="${orderSet.tourSpecificationtourType}"/></td>
            <td><c:out value="${orderSet.tourSpecificationnumberOfDays}"/></td>
            <td><c:out value="${orderSet.tourSpecificationtransport}"/></td>
            <td><c:out value="${orderSet.tourSpecificationcountry}"/></td>
            <td><c:out value="${orderSet.tourSpecificationprice}"/></td>
            <td><c:out value="${orderSet.tourSpecificationvisaNeeded}"/></td>
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
