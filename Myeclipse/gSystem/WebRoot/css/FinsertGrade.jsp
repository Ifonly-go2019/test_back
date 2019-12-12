<%@ page language="java" import="java.util.*,javaBean.*,Dao.*" pageEncoding="gb2312"%><%@page import="tools.MyTools"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>adminView</title>
		<link rel="stylesheet" type="text/css" href="../css/changeStudents.css"/>
		<link rel="stylesheet" type="text/css" href="../css/studentsView.css" />
	
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
				      <div id="show" style="top:-20px;left:200px; height:30px;width:300px; opcity:0.5">
				      	
				      <form action="FinsertGrade.jsp" class="searchButton">
					   <input type="text" name="sClasses"  placeholder="请输入班级" >
					   <input type="submit" value="查询" >
					</form>
				     </div>
				     <table>
							<tr>
							    <th  style="width:120px;">姓名</th>
								<th >学号</th>
								<th >班级</th>
								<th >成绩</th>
								<th >课程编号</th>
								<th style="width=60px;">功能</th>
							</tr>
				     <%
						GradeDao gd=new GradeDao();
						String sClasse= MyTools.toChinese( request.getParameter("sClasses"));
						String sql=null;
						
						List<inGradeBean> newlist= gd.findGrade(sClasse);
						for(inGradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td>"+admin.getsName()+"</td>");
							out.println("<td>"+admin.getsNo()+"</td>");
							out.println("<td>"+admin.getsClasses()+"</td>");
							out.println("<td>"+"<input type=text name=grade value="+admin.getGrade()+">"+" </td>");
							
							out.println("<td>"+"<input type=text name=cId value="+admin.getcId()+">"+"</td>");
							out.println("<td><a href=SinsertGrade.jsp?sName="+admin.getsName()+"&sNo="+admin.getsNo()+"&sClasses="+admin.getsClasses()+"&grade="+admin.getGrade()+"&cId="+admin.getcId()+">录入</a></td>");
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