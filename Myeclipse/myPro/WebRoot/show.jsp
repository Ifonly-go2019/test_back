<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <jsp:useBean id="Test" scope="session" class="tom.jiafei.sBean">
    <jsp:setProperty name="Test" property="*"/>
    </jsp:useBean>

<%=Test.getsName() %>
<%=Test.getsNumber() %>