<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.studentsDao"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%><%@page import="Dao.classDao"%>




<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>删除课程信息</title>
</head>
<body>
<%
    String cNo = request.getParameter("cNo");
    String sql = "delete from class where cNo ="+cNo;
    classDao cdao =new classDao();
    int flag=0;
    
    flag=cdao.deleate(sql);
    if (flag>0){
        out.println(sql);
        out.println(cNo+"号课程已成功删除");
    }else {
        out.println(sql);
        out.println(cNo+"号课程删除失败");
    }
%>
<a href="lookingClasses.jsp">返回</a>
</body>
</html>
！