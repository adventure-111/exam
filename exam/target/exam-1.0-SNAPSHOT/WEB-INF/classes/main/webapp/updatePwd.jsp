<%--
  Created by IntelliJ IDEA.
  User: 20188
  Date: 2021/2/26
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form action="/updatePwd" method="post">
    用户名: <input type="text" name="username"><br>
    原密码: <input type="password" name="oldPwd"><br>
    新密码: <input type="password" name="newPwd" placeholder="密码只允许由数字、字母或!、@、#组成"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
