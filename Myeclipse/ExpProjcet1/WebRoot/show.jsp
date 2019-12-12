<%-- 系统首页 --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ page import="tools.MyTools" %>


<%
String ShoppingCar =MyTools.toChinese(request.getParameter("ShoppingCar")) ;
String name=(String)session.getAttribute("VIPname");

session.setAttribute("ShoppingCar", ShoppingCar);
String car = (String) session.getAttribute("ShoppingCar");
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		
		<style type="text/css">
		body{
				
				display: flex;	
				font-size: 22px;
		}
		#car{
		font-size: 15px ;
		font-style: oblique;
		outline: 3px  solid rgba(60,60,60,0.5);
		}
		</style>
	</head>
	<body>
		<div class="top">
           <p>亲爱的用户<%=name %></p>
			<p>您选购的<div id="car">
			<%=car %>
			</div>
			已放入购物车</p>    	   
	     </div>
	</body>
</html>

