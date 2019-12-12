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
				
				<form action="<%=path %>/servlet/adminRegistServlet"  method="get">
					<div>
						<p>管理员账号<p><input type="text" name="uNo" >
						<img src="img/adminUser.png" >
						<p>密码</p><input type="password" name="uPwd">
						<img src="img/password.png">
						<p>邀请码</p><input type="text" name="uInumber" placeholder="请输入邀请码">
						<img src="img/inviate.png">
					</div>
					<input type="submit" value="点击注册" id="button">
				</form>

			</div>
              </div>

		</div>
	</body>
</html>


