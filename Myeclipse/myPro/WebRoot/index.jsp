<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String show=path+"show.jsp";
%>
<form action="show.jsp">
ѧ������:<input type="text" name="sName">
ѧ�ţ�<input type="text" name="sNumber">
<input type="submit" value="ע��">
</html>
