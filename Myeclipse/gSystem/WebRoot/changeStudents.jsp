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
							<li><a href="index.jsp">��ҳ</a></li>
							<li><a href="superAdminManagementpage.jsp">����ҳ��</a></li>
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
							<li><a href="lookingadmins.jsp">����Ա����</a></li>
							<li><a href="lookingStudents.jsp">ѧ������</a></li>
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>�ɼ�����</h2>
							<li><a href="insertGrade.jsp">�ɼ�¼��</a></li>
							<li><a href="lookingGrade.jsp">�ɼ���ѯ</a></li>
							<li><a href="changeGrade.jsp">�ɼ��޸�</a></li>
							
						</ul>
					</div>
					<div class="leftMenue_show">
						<ul class="leftUl">
							<h2>�γ̹���</h2>
							<li><a href="insertClasses.jsp">�γ�¼��</a></li>
							<li><a href="lookingClasses.jsp">�γ̲�ѯ</a></li>
						    <li><a href="changeClasses.jsp">�γ��޸�</a></li>
						</ul>
					</div>
					
				</div>
			</div>
			<div class="clear"></div>
			<div class="show">
				<div class="show_continent">
				      <div id="show">
				      	<a>���޸�ѧ����Ϣ</a>
				      
				      <div class="drop">
				      	
				      	<form action="<%=path %>/servlet/StudentUpdateServlet" method="get">
				      		<div>
				      			<p>ѧ��<p><input type="text" name="sNo" value="<%=request.getParameter("sNo") %>">
				      			<p>����</p><input type="text" name="sName" value="<%=MyTools.toChinese(request.getParameter("sName")) %>">						
				      			<p>����</p><input type="text" name="sPwd" value="<%=request.getParameter("sPwd") %>">
				      			<p>�Ա�</p><input type="text" name="sGender" value="<%=MyTools.toChinese(request.getParameter("sGender")) %>">
				      			<p>רҵ</p><input type="text" name="sMajor" value="<%=MyTools.toChinese(request.getParameter("sMajor")) %>">
				      			<p>ϵ��</p><input type="text" name="sDepart" value="<%=MyTools.toChinese(request.getParameter("sDepart")) %>">
				      		</div>
				      		<input type="submit" value="����޸�" id="button">
				      	
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

