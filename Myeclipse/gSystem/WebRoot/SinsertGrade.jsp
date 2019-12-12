<%@ page language="java" import="java.util.*,tools.*" pageEncoding="gb2312"%><%@page import="Dao.*"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%><%@page import="Dao.classDao"%><%@page import="javaBean.gradeBean"%>





<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>录入成绩</title>
</head>
<body>
<%  
   System.out.println("1");
    String sName = MyTools.toChinese( request.getParameter("sName"));
    String sNo = MyTools.toChinese(request.getParameter("sNo")) ;
    String sClasses = MyTools.toChinese( request.getParameter("sClasses"));
    String grade = MyTools.toChinese( request.getParameter("grade"));
    String cId = MyTools.toChinese( request.getParameter("cId"));
    
    gradeBean gb = new gradeBean();
    gb.setsId(sNo);
    gb.setcId(cId);
    gb.setClasses(sClasses);
    gb.setGrade(grade);
    
    
    GradeDao gdao =new GradeDao();
    int flag=0;
    
    flag=gdao.adduser(gb);
    if (flag>0){
        out.println(sNo+"号学生"+cId+"课程成绩已成功添加");
    }else {
      
        out.println("<h1></h1>");
        out.println(sNo+"号学生"+cId+"课程成绩添加失败");
    }
%>
<a href="FinsertGrade.jsp">返回</a>
</body>
</html>
！