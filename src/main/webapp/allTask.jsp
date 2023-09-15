<%@ page import="njust.pojo.User" %>
<%@ page import="njust.utils.PageBean" %>
<%@ page import="njust.pojo.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>任务中心</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("nowuser");
    if (user != null) out.print("当前用户：" + user.getName());
%>
<a href="/newTask.jsp">发布新任务</a>
<a href="/login.jsp">退出系统</a>
<%
    PageBean<Task> pageBean = (PageBean<Task>) session.getAttribute("pageBean");
    if (pageBean == null) return;
    List<Task> taskList = pageBean.getData();
    SimpleDateFormat fdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (Task task:taskList){
%>
<dl>
    <dt>任务：<%=task.getTaskName()%>
    </dt>
    <dd>状态：<%=task.getState()%>
    </dd>
    <dd>发布者：<%=task.getPublishName()%>
    </dd>
    <dd>发布时间：<%=fdt.format(task.getAddTime())%>
    </dd>
    <dd>详细描述：<%=task.getTaskContext()%>
    </dd>
    <dd>奖励：<%=task.getReward()%>
    </dd>
</dl>
<%
    }
    long pageTotal = pageBean.getTotal() / pageBean.getPageSize();
    if (pageBean.getTotal() % pageBean.getPageSize() != 0) pageTotal++;
%>
<div>
    <a href="/allTask/<%=pageBean.getPageSize()%>/1">首页</a>&emsp;
    <a href="/allTask/<%=pageBean.getPageSize()%>/<%=pageBean.getCurrentPage()-1%>">上一页</a>&emsp;
    [<%=pageBean.getCurrentPage()%>/<%=pageTotal%>]&emsp;
    <a href="/allTask/<%=pageBean.getPageSize()%>/<%=pageBean.getCurrentPage()+1%>">下一页</a>&emsp;
    <a href="/allTask/<%=pageBean.getPageSize()%>/<%=pageTotal%>">末页</a>&emsp;
</div>
</body>
</html>
