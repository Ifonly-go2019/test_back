<?php
require_once("conn.php");
$username = $_POST['name'];
$sex = $_POST['sex'];
$qq = $_POST['qq'];
$email = $_POST['email'];
$info = $_POST['info'];
if (strrpos($username,"<")!==false || strrpos($username,">")!==false||strrpos($username,"@")!==false||strrpos($username,"\"")!==false||strrpos($username,"'")!==false||strrpos($username,"_")!==false)
{
echo "<script>alert('���Ʋ����������ַ���');location.href='post.php';</script& gt;";
exit();
}
if (!ereg("^[0-9]{0,}$",$qq))//��������QQ��ʽ
{
echo "<script>alert('OICQ��Ϣ�д��󣡱��������֣�');location.href='post.php';< /script>";
exit();
}
if($email)
{//�����д��������������������ʽ
if (!ereg("^[a-zA-Z0-9_\-\.]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$",$email))
{
echo "<script>alert('email��ʽ����ȷ��');location.href='post.php';< /script>";
exit();
}
}
if(!$username)
{
echo "<script>alert('���Ʋ���Ϊ��Ŷ��');location.href='post.php';</script& gt;";
exit();
}
elseif(!$info)
{
echo "<script>alert('���Բ���Ϊ��Ŷ��');location.href='post.php';</script& gt;";
exit();
}
else
{
$ip = getenv('REMOTE_ADDR');//��ȡ�ͻ���IP��ַ
??? $sql = "insert into lo (username,sex,qq,email,info,ip,submit_time) values ('$username','$sex','$qq','$email','$info','$ip',NOW())";
??? $result = mysql_query($sql);
??? mysql_close();
??? echo "<script>alert('�ύ�ɹ���������ҳ');location.href='index.php';</script& gt;";
}
?>