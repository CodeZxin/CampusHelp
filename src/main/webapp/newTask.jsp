<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新任务</title>
</head>
<body>

<form action="newTask" method="post">
    任务标题<input type="text" name="taskName" placeholder="请输入标题"><br/>
    奖励
    <select name="reward">
        <option value="0" selected="">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="50">50</option>
        <option value="70">70</option>
        <option value="80">80</option>
        <option value="100">100</option>
    </select><br/>
    详细描述<br/><textarea name="taskContext" placeholder="请输入内容"></textarea><br/>
    <input type="submit" value="发布"><a href="/allTask.jsp">返回</a>
</form>
</body>
</html>
