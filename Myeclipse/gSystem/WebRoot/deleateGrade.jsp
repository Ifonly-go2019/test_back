<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.*"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%><%@page import="Dao.classDao"%>




<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>ɾ���γ���Ϣ</title>
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
        out.println(sId+"��ѧ��"+cId+"�γ̳ɼ��ѳɹ�ɾ��");
    }else {
        out.println(sql);
        out.println(sId+"��ѧ��"+cId+"�γ̳ɼ�ɾ��ʧ��");
    }
%>
<a href="lookingGrade.jsp">����</a>
</body>
</html>
��