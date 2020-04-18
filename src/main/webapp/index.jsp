<%--
  Created by IntelliJ IDEA.
  User: RGReeTy
  Date: 18.04.2020
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <title>XML parser</title>
</head>
<body>
<div>
    <h1 align="center">Upload yours xml file and then choose a xml-parser</h1>
    <form action="mainServlet" method="post" enctype="multipart/form-data">
        <p align="center"><input type="file" name="file" accept=".xml"/></p>
        <p align="center" >
            <button type="submit" style="width: 25%; height: 25%" name="command" value="SAX_PARSER">SAX parser</button>
            <button type="submit" style="width: 25%; height: 25%" name="command" value="STAX_PARSER">StAX parser</button>
            <button type="submit" style="width: 25%; height: 25%" name="command" value="DOM_PARSER">DOM parser</button>
        </p>
    </form>
</div>
</body>
</html>

