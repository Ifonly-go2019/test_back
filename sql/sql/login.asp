<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>登录</title>
</head>
<body>
<%
inname=Request("name")
inpass=Request("pass")

set conn=server.createobject("ADODB.CONNECTION")
conn.open "Provider=microsoft.jet.oledb.4.0; Data Source="+server.mappath("/db.asa")
sqlstr="SELECT * FROM data Where uname='" & inname & "'"
Set rs=conn.Execute(sqlstr)

response.write("调试信息########################################################<br>")
response.write("接收用户名为：" & inname & "<br>")
response.write("接收的密码为：" & inpass & "<br>")
response.write("构造查询语句：" & sqlstr & "<br>")
response.write("查询出的密码：" & rs("upass") & "<br>")
response.write("调试结束########################################################<p>")

if inpass=rs("upass") then	
  response.write("<h3>登录成功！</h3>")
  response.write("用户编号：" & rs("uid") & "<br>")
else
  response.write("登录失败！")
end if

Set rs=Nothing
conn.close
%>
</body>
</html>