<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form action="<%=path %>/servlet/loginServlet" name="Login" method="get">
�û���:<input type="text" name="Name">
���룺<input type="password" name="Password">
<input type="submit" value="��¼">
</form>
