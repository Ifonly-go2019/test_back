<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>��������Ա�������</title>
		<link rel="stylesheet" type="text/css" href="css/ManagementMain.css"/>
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
		<div class="show">
			<div class="show_continent">
			<p>��ӭ����ѧ���ɼ�����ϵͳ</p>	
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

