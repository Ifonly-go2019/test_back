<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.studentsDao"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%><%@page import="Dao.classDao"%>




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
    String cNo = request.getParameter("cNo");
    String sql = "delete from class where cNo ="+cNo;
    classDao cdao =new classDao();
    int flag=0;
    
    flag=cdao.deleate(sql);
    if (flag>0){
        out.println(sql);
        out.println(cNo+"�ſγ��ѳɹ�ɾ��");
    }else {
        out.println(sql);
        out.println(cNo+"�ſγ�ɾ��ʧ��");
    }
%>
<a href="lookingClasses.jsp">����</a>
</body>
</html>
��