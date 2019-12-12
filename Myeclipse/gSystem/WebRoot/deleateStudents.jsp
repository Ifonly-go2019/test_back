<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.studentsDao"%><%@page import="javaBean.studentBean"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>删除学生信息</title>
</head>
<body>
<%
    String sNo = request.getParameter("sNo");
    String sql = "delete from students where sNo ="+sNo;
    studentsDao sdao=new studentsDao();
    int flag=0;
    
    flag=sdao.deleate(sql);
    if (flag>0){
        out.println(sql);
        out.println(sNo+"号学生已成功删除");
    }else {
        out.println(sql);
        out.println(sNo+"号学生删除失败");
    }
%>
<a href="lookingStudents.jsp">返回</a>
</body>
</html>
！