<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>��¼ҳ��</title>
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<style type="text/css">


		</style>
	</head>
	<body>
		
		<div id="main">
			<div id="show">
			<a>����д��¼��Ϣ</a>	
			   <div class="drop">
				    <form action="<%=path %>/servlet/sLoginServlet" method="get">
					<div>
						<p>ѧ��<p><input type="text" name="uNo" style="width: 300px;height: 20px;">
						<img src="img/user.png" >
						<p>����</p><input type="password" name="uPwd"style="width: 300px;height: 20px;">
						<img src="img/password.png">
					</div>
					<input type="submit" value="�����¼" id="button">
                  </form>
			   </div>
            </div>
		</div>
	</body>
</html>
