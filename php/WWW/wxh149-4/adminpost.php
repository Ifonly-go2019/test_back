<?php
session_start();
require_once('conn.php');
$name = $_POST['name'];
$password = $_POST['password'];
$sql = "select * from admin where name='".$name."'";
$result = mysql_query($sql);
$num = mysql_num_rows($result);
if (strrpos($name,"<")!==false || strrpos($name,">")!==false||strrpos($name,"@")!==false||strrpos($name,"\"")!==false||strrpos($name,"'")!==false||strrpos($name,"_")!==false)
{
echo "<script>alert('�����������ַ���');location.href='admin.php';</script& gt;";
}
if($num)
{//����û����ڣ��ͼ�������Ƿ���ȷ
$rs = mysql_fetch_array($result);
if($rs[2]!=$password)
{
echo "<script>alert('���벻��ȷ����ȷ�Ϻ����룡');location.href='admin.php';< /script>";
}
else
{//�û��������붼��ȷ��ע��SESSION������Ȼ����ת����ҳ
$_SESSION["key"]=1;
echo "<script>alert('��¼�ɹ�����ӭ��+�Լ�����');location.href='index.php';</script& gt;";
}
}
else
{//���û������û�
echo "<script>alert('û������û�����ȷ�Ϻ����룡');location.href='admin.php';< /script>";
}
?>