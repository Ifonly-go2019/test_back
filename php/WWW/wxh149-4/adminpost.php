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
echo "<script>alert('不能有特殊字符！');location.href='admin.php';</script& gt;";
}
if($num)
{//如果用户存在，就检查密码是否正确
$rs = mysql_fetch_array($result);
if($rs[2]!=$password)
{
echo "<script>alert('密码不正确，请确认后输入！');location.href='admin.php';< /script>";
}
else
{//用户名，密码都正确，注册SESSION变量，然后跳转到首页
$_SESSION["key"]=1;
echo "<script>alert('登录成功！欢迎您+自己姓名');location.href='index.php';</script& gt;";
}
}
else
{//如果没有这个用户
echo "<script>alert('没有这个用户，请确认后输入！');location.href='admin.php';< /script>";
}
?>