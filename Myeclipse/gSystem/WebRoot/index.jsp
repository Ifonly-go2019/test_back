<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>ѧ���ɼ�����ϵͳ</title>
		<link rel="stylesheet" type="text/css" href="css/index.css" charset="utf-8"/>
	</head>
	<body>
		<div id="home">
			
		
		<div class="top">
			
			<div class="navbox">
				
				<ul class="navbox_firstul">
					
					<li><a href="">�й���Ϣ</a></li>
					<div class="dropdown" id="dropdown_2">
					 <ul class="subnav">
					 	
					 	<li><a href="Fun.jsp">����鿴</a></li>
					 	<li><a href="about.jsp">����</a></li>
					 </ul>
					</div>
					<li><a href="">ע��</a></li>
					<div class="dropdown" id="dropdown_3">
					 <ul class="subnav">
					 	<li><a href="studentRegist.jsp">ѧ��</a></li>
					 	<li><a href="adminRegist.jsp">����Ա</a></li>
					 </ul>
					</div>
					<li><a href="">��¼</a></li>
					<div class="dropdown" id="dropdown_4">
					 <ul class="subnav">
					 	<li><a href="studentLogin.jsp">ѧ��</a></li>
					 	<li><a href="adminLogin.jsp">����Ա</a></li>
					 </ul>
					</div>
				</ul>
			</div>
			
			<div class="main">
				<p>ѧ���ɼ�����ϵͳ</p>
			</div>
            <div class="bottom">
				<p>@by��������2017122149�Ű�174</p>
            	
            </div> 
		</div>
		</div>
	</body>
</html>
