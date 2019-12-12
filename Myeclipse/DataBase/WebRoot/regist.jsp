<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		
		<style type="text/css">
		body{
				background-color: #7FFFD4;
				display: flex;	
		}
		.top{
			font-size: 20px;
			color: brown;
		}
		.top form{
			font-size: 12px;
			
		}
		#button{
			flex: left;
		}
			
		</style>
	</head>
	<body>

		<div class="top">
           <p>«ÎÃÓ–¥◊¢≤·–≈œ¢</p>
			   
			   <form  action="<%=path %>/servlet/addUserServlet" method="get">
				   
				   <div >
					   <p>Í«≥∆<p><input  type="text" name="uName">
					   <p>√‹¬Î</p><input type="password" name="uPwd">
					   <p>√‹±£” œ‰</p><input type="email" name="uEmail">
					   
				   </div>
				   <input type="submit" value="µ„ª˜◊¢≤·" id="button">
			   </form>
			   
	     </div>
	</body>
</html>
