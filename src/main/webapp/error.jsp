<%--
  Created by IntelliJ IDEA.
  User: RGReeTy
  Date: 18.04.2020
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage = "true"%>

<html>
<head>
    <title>Oops..</title>
</head>

<body>
<h1 align="center">Sorry, something went wrong...</h1>
        <div class="error-message-container">
            <p><h2 align="center">Error status: ${pageContext.errorData.statusCode}</h2></p>
            <p><h2 align="center">Request URI: ${pageContext.errorData.requestURI}</h2></p>
        </div>
</body>
</html>