<%@ page language="java" import="java.util.*,javaBean.*,DB.*,com.servlet.*,tools.*" pageEncoding="gb2312"%><%@page import="Dao.Admindao"%><%@page import="Dao.studentsDao"%>



<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>adminView</title>
		<link rel="stylesheet" type="text/css" href="css/changeStudents.css"/>
		<link rel="stylesheet" type="text/css" href="css/studentsView.css" />
	</head>
	<body>
		<div class="main">
			<div class="top">
				<div class="topMenue">
					<div class="topMenue_show">
						<ul>
							<li><a href="index.jsp">首页</a></li>
							<li><a href="superAdminManagementpage.jsp">管理页面</a></li>
							<li><a href="">刷新</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="left">
				<div class="leftMenue">
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>权限管理</h2>
							<li><a href="lookingadmins.jsp">管理员管理</a></li>
							<li><a href="lookingStudents.jsp">学生管理</a></li>
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>成绩管理</h2>
							<li><a href="insertGrade.jsp">成绩录入</a></li>
							<li><a href="lookingGrade.jsp">成绩查询</a></li>
							<li><a href="">成绩修改</a></li>
							
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>课程管理</h2>
							<li><a href="insertClasses.jsp">课程录入</a></li>
							<li><a href="lookingClasses.jsp">课程查询</a></li>
						    <li><a href="changeClasses.jsp">课程修改</a></li>
						</ul>
					</div>
					
				</div>
			</div>
			<div class="clear"></div>
			<div class="show">
				<div class="show_continent">
				      <div id="show">
				      	<a>请修改管理员信息</a>
				      
				      <div class="drop">
				      	
				      	<form action="<%=path %>/servlet/adminUpdateServlet" method="get">
				      		<div>
				      	<p>管理员账号<p><input type="text" name="uNo" value="<%=request.getParameter("aNo") %>" >
						
						<p>密码</p><input type="password" name="uPwd" value="<%=request.getParameter("aPwd") %>">
						
						<p>邀请码</p><input type="text" name="uInumber" value="<%=request.getParameter("aInumber") %>">
					
				      		</div>
				      		<input type="submit" value="点击修改" id="button">
				      	
				      	</form>
				      
				      </div>
				        </div>
				</div>
			</div>
			<div class="clear"></div>
			
		</div>
		<div class="bottom">
		
		</div>
	</body>
</html>

