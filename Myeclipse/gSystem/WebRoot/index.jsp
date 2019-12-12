<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>学生成绩管理系统</title>
		<link rel="stylesheet" type="text/css" href="css/index.css" charset="utf-8"/>
	</head>
	<body>
		<div id="home">
			
		
		<div class="top">
			
			<div class="navbox">
				
				<ul class="navbox_firstul">
					
					<li><a href="">有关信息</a></li>
					<div class="dropdown" id="dropdown_2">
					 <ul class="subnav">
					 	
					 	<li><a href="Fun.jsp">点击查看</a></li>
					 	<li><a href="about.jsp">关于</a></li>
					 </ul>
					</div>
					<li><a href="">注册</a></li>
					<div class="dropdown" id="dropdown_3">
					 <ul class="subnav">
					 	<li><a href="studentRegist.jsp">学生</a></li>
					 	<li><a href="adminRegist.jsp">管理员</a></li>
					 </ul>
					</div>
					<li><a href="">登录</a></li>
					<div class="dropdown" id="dropdown_4">
					 <ul class="subnav">
					 	<li><a href="studentLogin.jsp">学生</a></li>
					 	<li><a href="adminLogin.jsp">管理员</a></li>
					 </ul>
					</div>
				</ul>
			</div>
			
			<div class="main">
				<p>学生成绩管理系统</p>
			</div>
            <div class="bottom">
				<p>@by：王晓辉2017122149信安174</p>
            	
            </div> 
		</div>
		</div>
	</body>
</html>
