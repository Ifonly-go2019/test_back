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
		<title>ѧ������</title>
		<link rel="stylesheet" type="text/css" href="css/ManagementMain.css"/>
	</head>
	<body>
		<div class="main">
		<div class="top">
			<div class="topMenue">
				<div class="topMenue_show">
					<ul>
						<li><a href="index.jsp">��ҳ</a></li>
						<li><a href="studentsManagementPage.jsp">����ҳ��</a></li>
						<li><a href="">ˢ��</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="left">
			<div class="leftMenue">
			<div class="leftMenue_show">
			<ul class="leftUl">	
				<h2>Ȩ�޹���</h2>
				
				  <li><a href=lookingStudents_personal.jsp>ѧ������</a></li>
				
			</ul>
			</div>
		    <div class="leftMenue_show">
				<ul class="leftUl">
				<h2>�ɼ�����</h2>
				<%
				  out.println("<li>");
				  out.println("<a href=lookingGrade_p.jsp?sId="+student.getsNo()+">�ɼ���ѯ</a>");
				  out.println("</li>");
				 %>				
				</ul>
			</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>�γ̹���</h2>
							<li><a href="lookingClasses_p.jsp">�γ̲�ѯ</a></li>
						</ul>
					</div>
			</div>
		</div>
		<div class="show">
			<div class="show_continent">
			<p>��ӭ����ѧ���ɼ�����ϵͳ</p>
			
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

