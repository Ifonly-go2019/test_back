<%@ page language="java" import="java.util.*,javaBean.*,DB.*,com.servlet.*" pageEncoding="gb2312"%><%@page import="Dao.Admindao"%><%@page import="Dao.GradeDao"%>



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
					<form action="lookingGrade.jsp" class="searchButton">
					   <input type="text" name="sId"  placeholder="������ѧ�Ų�ѯ" >
					   <input type="submit" value="��ѯ" >
					</form>
					<table>
							<tr>
							    <th class="ffirst_th" style="width:20px;">�ɼ����</th>
								<th class="first_th">ѧ��</th>
								<th class="second_th">�γ̱��</th>
								<th class="third_th">�ɼ�</th>
								<th class="frouth_th">�༶</th>
								<th class="fiveth_th style="width=60px;"">����</th>
							</tr>
						<%
						GradeDao gd=new GradeDao();
						String sNo=request.getParameter("sId");
						String sql=null;
						if( sNo==null){
						 sql="select * from grade";
						}else{
							sql = "select * from grade where sId like '%" + sNo + "%'";
						}
						List<gradeBean> newlist= gd.findall(sql);
						for(gradeBean admin:newlist){
							out.println("<tr>");
							out.println("<td>"+admin.getgId()+"</td>");
							out.println("<td>"+admin.getsId()+"</td>");
							out.println("<td>"+admin.getcId()+"</td>");
							out.println("<td>"+admin.getGrade()+"</td>");
							out.println("<td>"+admin.getClasses()+"</td>");
							out.println("<td><a href=changeGrade.jsp?sId="+admin.getsId()+"&gId="+admin.getgId()+"&cId="+admin.getcId()+"&grade="+admin.getGrade()+"&sclasses="+admin.getClasses()+">�޸�</a><a href=deleateGrade.jsp?sId="+admin.getsId()+"&cId="+admin.getcId()+">|  ɾ��</a></td>");
							out.println("</tr>");
							/*out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">�޸�|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  ɾ��</a></td></tr>");*/
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

