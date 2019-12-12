<%@ page language="java" import="java.util.*,javaBean.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 
  studentBean student=(studentBean)session.getAttribute("students");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>学生界面</title>
		<link rel="stylesheet" type="text/css" href="css/ManagementMain.css"/>
	</head>
	<body>
		<div class="main">
		<div class="top">
			<div class="topMenue">
				<div class="topMenue_show">
					<ul>
						<li><a href="index.jsp">首页</a></li>
						<li><a href="studentsManagementPage.jsp">管理页面</a></li>
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
				
				  <li><a href=lookingStudents_personal.jsp>学生管理</a></li>
				
			</ul>
			</div>
		    <div class="leftMenue_show">
				<ul class="leftUl">
				<h2>成绩管理</h2>
				<%
				  out.println("<li>");
				  out.println("<a href=lookingGrade_p.jsp?sId="+student.getsNo()+">成绩查询</a>");
				  out.println("</li>");
				 %>				
				</ul>
			</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>课程管理</h2>
							<li><a href="lookingClasses_p.jsp">课程查询</a></li>
						</ul>
					</div>
			</div>
		</div>
		<div class="show">
			<div class="show_continent">
			<p>欢迎进入学生成绩管理系统</p>
			
			<th >
			    
				<td>V0.11</td>
			</th>
			
			</div>	
		</div>
		<div class="bottom">
			
		</div>
		</div>
	</body>
</html>

