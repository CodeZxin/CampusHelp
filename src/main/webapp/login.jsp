<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<p><%
    String msg=(String) request.getAttribute("msg");
    if (msg!=null)out.print(msg);
%></p>
<form action="login" method="post">
    账户<input type="text" name="stuNumber"><br/>
    密码<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
<a href="register.jsp">注册</a>
</body>
</html>
