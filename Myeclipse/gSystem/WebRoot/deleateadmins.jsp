<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%><%@page import="Dao.studentsDao"%><%@page import="javaBean.studentBean"%><%@page import="Dao.Admindao"%>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>ɾ��ѧ����Ϣ</title>
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
        out.println(aNo+"�Ź���Ա�ѳɹ�ɾ��");
    }else {
        out.println(sql);
        out.println(aNo+"�Ź���Աɾ��ʧ��");
    }
%>
<a href="lookingadmins.jsp">����</a>
</body>
</html>
��