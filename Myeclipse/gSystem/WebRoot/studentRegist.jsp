<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>ע��ҳ��</title>
		<link rel="stylesheet" type="text/css" href="css/regist.css" />
		<style type="text/css">


		</style>
	</head>
	<body>
		<div id="main">
			<div id="show">
				<a>����дע����Ϣ</a>
			
			<div class="drop">
				
				<form action="<%=path %>/servlet/StudentRegistServlet" method="get">
					<div>
						<p>ѧ��<p><input type="text" name="sNo">
						<p>����</p><input type="text" name="sName">						
						<p>����</p><input type="password" name="sPwd">
						<p>�Ա�</p><input type="text" name="sGender">
						<p>רҵ</p><input type="text" name="sMajor">
						<p>ϵ��</p><input type="text" name="sDepart">
					</div>
					<input type="submit" value="���ע��" id="button">
				</form>

			</div>
              </div>

		</div>
	</body>
</html>

