<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>



<%

String path = request.getContextPath();

System.out.print(path);

%>



<form  action="<%=path%>/addbook" method="post">

     ͼ�����ƣ� <input type="text" name="bookNAME">

     �����磺 <input type="text" name="publisher">

            <input type="submit" value="�ύ" name="submit">



</form>
