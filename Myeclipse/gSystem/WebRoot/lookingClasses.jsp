<%@ page language="java" import="java.util.*,javaBean.*,DB.*,com.servlet.*" pageEncoding="gb2312"%><%@page import="Dao.Admindao"%><%@page import="Dao.classDao"%>



<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>adminView</title>
		<link rel="stylesheet" type="text/css" href="css/adminView.css"/>
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
					<form action="lookingClasses.jsp" class="searchButton">
					   <input type="text" name="cNo"  placeholder="请输入课程编号查询" >
					   <input type="submit" value="查询" > 
					
					  
					</form>
					<table>
							<tr>
								<th class="first_th">课程编号</th>
								<th class="second_th">课程名称</th>
								<th class="frouth_th">功能</th>	
							</tr>
						<%
						classDao cdo=new classDao();
						String cNo=request.getParameter("cNo");
						String sql=null;
						if( cNo==null){
						 sql="select * from class";
						}else{
							sql = "select * from class where cNo like '%" + cNo + "%'";
						}
						List<classBean> newlist= cdo.findall(sql);
						for(classBean admin:newlist){
							out.println("<tr>");
							out.println("<td>"+admin.getcNo()+"</td>");
							out.println("<td>"+admin.getcName()+"</td>");
							out.println("<td><a href=changeClasses.jsp?cNo="+admin.getcNo()+"&cName="+admin.getcName()+">修改</a><a href=deleateClasses.jsp?cNo="+admin.getcNo()+">|  删除</a></td>");
			
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">修改|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  删除</a></td></tr>");*/
						}
					  
						
						%>
							
						
				</div>
			</div>
			<div class="clear"></div>
			
		</div>
		<div class="bottom">
		
		</div>
	</body>
</html>

