<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="javaBean.LoginBean"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginUrl =basePath+"login.jsp";
/*HttpSession session1 =request.getSession();
String VIP=(String)session1.getAttribute("VIP");*/
/** 可以直接使用 String VIP = (String) session.getAttribute("VIP")来调取loginServlet中的session对象VIP，
因为JSP中有伪对象的概念
*/

LoginBean login =(LoginBean) session.getAttribute("LoginUsers");

if(login.getName()==null){
	response.setHeader("refresh","0;URL="+loginUrl);
}else{
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>留言板</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="留言板">

	<style type="text/css">
            body{
              font-size:12px;
            }
            #main{
              width:100%;
              height:400px;
              display: flex;
			  justify-content: space-around;
            }	
			#top1{
				width:600px;
				height: 200px;
				border-color:1px solid rgba(60,60,60,0.5);
				border-radius:5px;
			}
			#top2{
			 border-radius: 5px;
			}
			#top3{
			  float:left;
			}
			#留言板{
			 font-size:14px;
			 color:rgba(60,60,60,0.5);
			}
		</style>
  </head>
 

  <body>
  <div id="main">
  <form action="<%=path %>/servlet/test2Servlet" name="talking" method="get" id="top3">
  
       <p id="留言板">留言板：<p>
		<textarea rows="20" cols="20" id="top1" name="userSpeaking"></textarea>
		<div>
		标题：<input type="text" name="tittle">
               用户名:<input type="text" name="Name" id="top2">
        <input type="submit" value="上载">
        </div>
</form>
</div>
  </body>
</html>
     
<%}%>>