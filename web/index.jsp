<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>XML parser</title>
</head>
<body>
<div class="maintext">
    <h1 align="center">XML file parser</h1>
    <form action="mainServlet" method="post" enctype="multipart/form-data">
        <h1 align="center">Choose a file:</h1>
        <p align="center"><input type="file" name="file" accept="*.xml"/></p>
        <p align="center">
            <button type="submit" style="width: 200px;height: 100px" name="command" value="DOM">DOM parser</button>
        </p>
        <p align="center">
            <button type="submit" style="width: 200px;height: 100px" name="command" value="SAX">SAX parser</button>
        </p>
        <p align="center">
            <button type="submit" style="width: 200px;height: 100px" name="command" value="STAX">STAX parser</button>
        </p>
    </form>
</div>
</body>
</html>