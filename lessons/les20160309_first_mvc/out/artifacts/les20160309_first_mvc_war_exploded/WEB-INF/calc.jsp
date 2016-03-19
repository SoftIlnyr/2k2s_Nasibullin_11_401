<%--
  Created by IntelliJ IDEA.
  User: softi
  Date: 09.03.2016
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calc" method="post">
        <input type="text" name="arg1">
        <input type="text" name="arg2">
        <select name="act">
            <option>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select>
        <input type="submit" value="Calculate!"/>
    </form>
    ${result}
</body>
</html>
