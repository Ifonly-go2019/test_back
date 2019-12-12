<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String show=path+"show.jsp";
%>
<form action="show.jsp">
学生姓名:<input type="text" name="sName">
学号：<input type="text" name="sNumber">
<input type="submit" value="注册">
</html>
