<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.*"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%><%@page import="Dao.classDao"%>




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
    String sId = request.getParameter("sId");
    String cId = request.getParameter("cId");
    String sql = "delete from grade where sId ="+sId+" and cId="+cId;
    GradeDao gdao =new GradeDao();
    int flag=0;
    
    flag=gdao.deleate(sql);
    if (flag>0){
        out.println(sId+"号学生"+cId+"课程成绩已成功删除");
    }else {
        out.println(sql);
        out.println(sId+"号学生"+cId+"课程成绩删除失败");
    }
%>
<a href="lookingGrade.jsp">返回</a>
</body>
</html>
！