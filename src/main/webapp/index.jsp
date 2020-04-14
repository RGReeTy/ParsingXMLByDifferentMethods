<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Choosing of XML parsers</title>
</head>
<body>
<h2>Choose XML parser:</h2>
<div>
    <FORM ACTION="Controller" METHOD="POST">
        <INPUT TYPE="radio" NAME="parsers" VALUE="DOM" CHECKED>
        DOM
        <BR>
        <INPUT TYPE="radio" NAME="parsers" VALUE="SAX">
        SAX
        <BR>
        <INPUT TYPE="radio" NAME="parsers" VALUE="StAX">
        StAX
        <BR>
        <INPUT TYPE="submit" VALUE="Submit">
    </FORM>
</div>
</body>
</html>
