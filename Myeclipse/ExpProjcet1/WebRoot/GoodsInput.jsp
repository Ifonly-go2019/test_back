<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'GoodsInput.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
  </head>
  <body> 
  <%String userName=(String)session.getAttribute("VIPname");%>
   <p> �װ����û�<%out.println(userName); %></p>
   <p>��������Ҫ�������Ʒ</p>
   <form action="show.jsp"  method="get">
   <textarea rows="5" cols="15" id="top1" name="ShoppingCar" fontsize=30px></textarea>
   <input type="submit" value="����">
   </form>  
  </body>
</html>



