<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% String userName=(String)session.getAttribute("bookName");%>
<% String publisher=(String)session.getAttribute("publisher");%>
<p>出版社名称是<%out.println(publisher); %></p>
<p>图书名称是<%out.println(userName); %></p>
