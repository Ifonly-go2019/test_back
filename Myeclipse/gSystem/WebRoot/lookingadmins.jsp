<%@ page language="java" import="java.util.*,javaBean.*,DB.*,com.servlet.*" pageEncoding="gb2312"%><%@page import="Dao.Admindao"%>


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
					<form action="lookingadmins.jsp" class="searchButton">
					   <input type="text" name="aNo"  placeholder="�������˺Ų�ѯ" >
					   <input type="submit" value="��ѯ" >
					</form>
					<table>
							<tr>
								<th class="first_th">����Ա�˺�</th>
								<th class="second_th">����</th>
								<th class="third_th">������</th>
								<th class="frouth_th">����</th>	
							</tr>
						<%
						Admindao ado=new Admindao();
						String aNo=request.getParameter("aNo");
						String sql=null;
						if( aNo==null){
						 sql="select * from admins";
						}else{
							sql = "select * from admins where aNo like '%" + aNo + "%'";
						}
						List<adminBean> newlist= ado.findall(sql);
						for(adminBean admin:newlist){
							/**out.println("<tr>");
							out.println("<td>"+admin.getuNo()+"</td>");
							out.println("<td>"+admin.getuPwd()+"</td>");
							out.println("<td>"+admin.getuInumber()+"</td>");
							out.println("<td><a href=index.jsp>�޸�</a></td>");
							out.println("</tr>");*/
							out.println("<tr><td>"+admin.getuNo()+"</td><td>"+admin.getuPwd()+"</td><td>"+admin.getuInumber()+"</td><td><a href=changeadmins.jsp?aNo="+admin.getuNo()+"&aPwd="+admin.getuPwd()+"&aInumber="+admin.getuInumber()+">�޸�|</a><a href=deleateadmins.jsp?aNo="+admin.getuNo()+">|  ɾ��</a></td></tr>");
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

