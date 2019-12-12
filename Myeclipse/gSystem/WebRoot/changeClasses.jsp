<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="tools.*"%>


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
			<div class="clear"></div>
			<div class="show">
				<div class="show_continent">
				      <div id="show">
				      	<a>请填入课程信息</a>
				      
				      <div class="drop">
				      	
				      	<form action="<%=path %>/servlet/classesUpdateServlert" method="get">
				      		<div>
				      			
				      			<p>原课程编号</p><input type="text" name="cNo" value="<%=request.getParameter("cNo") %>">						
				      			<p>课程名称</p><input type="text" name="cName" value="<%=MyTools.toChinese(request.getParameter("cName")) %>">
				      			<p>改后课程编号</p><input type="text" name="cNoc" ">
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