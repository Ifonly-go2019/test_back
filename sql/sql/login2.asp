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
conn.open "DRIVER={Microsoft Access Driver (*.mdb)};DBQ="+server.mappath("db.asa")

set rs=Server.CreateObject("ADODB.Recordset")
sqlstr="select * from data where uname='" & inname & "' and upass='" & inpass & "'"
rs.open sqlstr,conn,1

response.write("<p>调试信息########################################################<br>")
response.write("接收用户名为：" & inname & "<br>")
response.write("接收的密码为：" & inpass & "<br>")
response.write("构造查询语句：" & sqlstr & "<br>")
response.write("调试结束########################################################</p>")

if rs.recordcount>0 then	
  response.write("<h3>登录成功！</h3>")
  response.write("查询出的用户编号为：" & rs("uid"))
else
  response.write("<h3>登录失败！</h3>")
end if

set rs=nothing
conn.close
%>
</body>
</html>