<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>超级管理员管理界面</title>
		<link rel="stylesheet" type="text/css" href="css/ManagementMain.css"/>
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
							<li><a href="changeGrade.jsp">成绩修改</a></li>
							
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
		<div class="show">
			<div class="show_continent">
			<p>欢迎进入学生成绩管理系统</p>	
			<th>
				<td>V0.11</td>
			</th>
			</div>	
		</div>
		<div class="bottom">
			
		</div>
		</div>
	</body>
</html>

