<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册页面</title>
		<link rel="stylesheet" type="text/css" href="css/regist.css" />
		<style type="text/css">


		</style>
	</head>
	<body>
		<div id="main">
			<div id="show">
				<a>请填写注册信息</a>
			
			<div class="drop">
				
				<form action="<%=path %>/servlet/StudentRegistServlet" method="get">
					<div>
						<p>学号<p><input type="text" name="sNo">
						<p>姓名</p><input type="text" name="sName">						
						<p>密码</p><input type="password" name="sPwd">
						<p>性别</p><input type="text" name="sGender">
						<p>专业</p><input type="text" name="sMajor">
						<p>系别</p><input type="text" name="sDepart">
					</div>
					<input type="submit" value="点击注册" id="button">
				</form>

			</div>
              </div>

		</div>
	</body>
</html>

