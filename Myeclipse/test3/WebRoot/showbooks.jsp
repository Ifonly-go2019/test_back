<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% String userName=(String)session.getAttribute("bookName");%>
<% String publisher=(String)session.getAttribute("publisher");%>
<p>������������<%out.println(publisher); %></p>
<p>ͼ��������<%out.println(userName); %></p>
