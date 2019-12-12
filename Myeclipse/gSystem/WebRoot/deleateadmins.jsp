<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.studentsDao"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%>



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
    String aNo = request.getParameter("aNo");
    String sql = "delete from admins where aNo ="+aNo;
    Admindao adao =new Admindao();
    int flag=0;
    
    flag=adao.deleate(sql);
    if (flag>0){
        out.println(sql);
        out.println(aNo+"号管理员已成功删除");
    }else {
        out.println(sql);
        out.println(aNo+"号管理员删除失败");
    }
%>
<a href="lookingadmins.jsp">返回</a>
</body>
</html>
！