<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��¼</title>
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

response.write("<p>������Ϣ########################################################<br>")
response.write("�����û���Ϊ��" & inname & "<br>")
response.write("���յ�����Ϊ��" & inpass & "<br>")
response.write("�����ѯ��䣺" & sqlstr & "<br>")
response.write("���Խ���########################################################</p>")

if rs.recordcount>0 then	
  response.write("<h3>��¼�ɹ���</h3>")
  response.write("��ѯ�����û����Ϊ��" & rs("uid"))
else
  response.write("<h3>��¼ʧ�ܣ�</h3>")
end if

set rs=nothing
conn.close
%>
</body>
</html>