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
				      <div id="show" style="top:-20px;left:200px; height:30px;width:300px; opcity:0.5">
				      	
				      <form action="FinsertGrade.jsp" class="searchButton">
					   <input type="text" name="sClasses"  placeholder="������༶" >
					   <input type="submit" value="��ѯ" >
					</form>
				     </div>
				     <table>
							<tr>
							    <th  style="width:120px;">����</th>
								<th >ѧ��</th>
								<th >�༶</th>
								<th >�ɼ�</th>
								<th >�γ̱��</th>
								<th style="width=60px;">����</th>
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
							out.println("<td><a href=SinsertGrade.jsp?sName="+admin.getsName()+"&sNo="+admin.getsNo()+"&sClasses="+admin.getsClasses()+"&grade="+admin.getGrade()+"&cId="+admin.getcId()+">¼��</a></td>");
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