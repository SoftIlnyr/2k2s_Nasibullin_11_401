<%--
  Created by IntelliJ IDEA.
  User: softi
  Date: 20.03.2016
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Symbolizer</title>
</head>
<body>
<form action="/process" method="post">
    <p><textarea style="width: 50%; height: 80%" name="text"></textarea></p>
    <p>Count of <select size="1" name="act">
        <option>Symbols</option>
        <option>Words</option>
        <option>Sentences</option>
        <option>Articles</option>
    </select></p>
    <p><input type="submit" value="Check"></p>
</form>
<h2>${result}</h2>
</body>
</html>
