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
				       <form action="lookingStudents.jsp" class="searchButton">
					   <input type="text" name="sNo"  placeholder="������ѧ�Ų�ѯ" >
					   <input type="submit" value="��ѯ" >
					   </form>
					  <span id="add"> <a  href="insertStudent.jsp"  >���ѧ��</a></span>
					<table>
						
							<tr>
								<th class="first_th">ѧ��</th>
								<th class="second_th">����</th>
								<th class="third_th">����</th>
								<th class="frouth_th">�Ա�</th>
								<th class="five_th">�༶</th>
								<th class="sixth_th">ѧԺ</th>
								<th class="seventh_th">����</th>	
							</tr>
							<%
						    studentsDao sdo=new studentsDao();
							String sNo=request.getParameter("sNo");
							String sql=null;
							if(sNo==null){
								sql="select * from students";
							}else{
						        sql="select * from students where sNo like '%" + sNo + "%'";
							}
						List<studentBean> newlist= sdo.findall(sql);
					   
						for(studentBean student:newlist){
							out.println("<tr><td>"+student.getsNo()+"</td><td>"+student.getsName()+"</td><td>"
									+student.getsPwd()+"</td><td>"+student.getsGender()+"</td><td>"+student.getsMajor()
									+"</td><td>"+student.getsDepart()+
									"</td><td><a id=change href=changeStudents.jsp?sNo="+student.getsNo()+"&sName="+student.getsName()+"&sPwd="+student.getsPwd()+"&sGender="+student.getsGender()+"&sMajor="+student.getsMajor()+"&sDepart="+student.getsDepart()+" onclick=if(confirm('ȷ����ת��')==false)return href='#';>�޸�|</a><a  id=del href=deleateStudents.jsp?sNo="+student.getsNo()+">ɾ��</a></td></tr>");
						}
						%>	
						
				</div>
	
				
			</div>
			<div class="clear"></div>
			
		</div>
		<div class="bottom">
		
		</div>
			<script>
		  function delete(){
			 var msg = "�����ȷ��Ҫɾ����\n\n��ȷ�ϣ�";
			  if (confirm(msg)==true){ 
              return true; 
             }else{ 
                return false; 
             } 
		};
			</script>
	
	</body>
</html>

