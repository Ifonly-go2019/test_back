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
conn.open "Provider=microsoft.jet.oledb.4.0; Data Source="+server.mappath("/db.asa")
sqlstr="SELECT * FROM data Where uname='" & inname & "'"
Set rs=conn.Execute(sqlstr)

response.write("������Ϣ########################################################<br>")
response.write("�����û���Ϊ��" & inname & "<br>")
response.write("���յ�����Ϊ��" & inpass & "<br>")
response.write("�����ѯ��䣺" & sqlstr & "<br>")
response.write("��ѯ�������룺" & rs("upass") & "<br>")
response.write("���Խ���########################################################<p>")

if inpass=rs("upass") then	
  response.write("<h3>��¼�ɹ���</h3>")
  response.write("�û���ţ�" & rs("uid") & "<br>")
else
  response.write("��¼ʧ�ܣ�")
end if

Set rs=Nothing
conn.close
%>
</body>
</html>