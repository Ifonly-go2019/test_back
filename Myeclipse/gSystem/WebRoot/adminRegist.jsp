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
				
				<form action="<%=path %>/servlet/adminRegistServlet"  method="get">
					<div>
						<p>����Ա�˺�<p><input type="text" name="uNo" >
						<img src="img/adminUser.png" >
						<p>����</p><input type="password" name="uPwd">
						<img src="img/password.png">
						<p>������</p><input type="text" name="uInumber" placeholder="������������">
						<img src="img/inviate.png">
					</div>
					<input type="submit" value="���ע��" id="button">
				</form>

			</div>
              </div>

		</div>
	</body>
</html>


