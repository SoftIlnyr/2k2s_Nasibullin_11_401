<%--
  Created by IntelliJ IDEA.
  User: softi
  Date: 03.04.2016
  Time: 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <form action="/students/${id}" method="post">
        <input type="text" name="name">
        <input type="submit" value="save">


    </form>
</body>
</html>
