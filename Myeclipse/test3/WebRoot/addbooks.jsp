<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>



<%

String path = request.getContextPath();

System.out.print(path);

%>



<form  action="<%=path%>/addbook" method="post">

     图书名称： <input type="text" name="bookNAME">

     出版社： <input type="text" name="publisher">

            <input type="submit" value="提交" name="submit">



</form>
