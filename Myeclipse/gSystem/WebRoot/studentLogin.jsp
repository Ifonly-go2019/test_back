<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<style type="text/css">


		</style>
	</head>
	<body>
		
		<div id="main">
			<div id="show">
			<a>请填写登录信息</a>	
			   <div class="drop">
				    <form action="<%=path %>/servlet/sLoginServlet" method="get">
					<div>
						<p>学号<p><input type="text" name="uNo" style="width: 300px;height: 20px;">
						<img src="img/user.png" >
						<p>密码</p><input type="password" name="uPwd"style="width: 300px;height: 20px;">
						<img src="img/password.png">
					</div>
					<input type="submit" value="点击登录" id="button">
                  </form>
			   </div>
            </div>
		</div>
	</body>
</html>
