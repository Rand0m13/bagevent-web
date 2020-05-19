<%--
  Created by IntelliJ IDEA.
  User: ROG
  Date: 2020/5/19
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/reg" method="post">
        用户名：<input placeholder="用户名" name="username"><br>
        密码：<input type="password" name="password"><br>
        邮箱：<input type="email" name="email"><br>
        手机号：<input type="text" name="cellphone"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
