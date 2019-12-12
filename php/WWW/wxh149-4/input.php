<?php
require_once("conn.php");
$username = $_POST['name'];
$sex = $_POST['sex'];
$qq = $_POST['qq'];
$email = $_POST['email'];
$info = $_POST['info'];
if (strrpos($username,"<")!==false || strrpos($username,">")!==false||strrpos($username,"@")!==false||strrpos($username,"\"")!==false||strrpos($username,"'")!==false||strrpos($username,"_")!==false)
{
echo "<script>alert('名称不能有特殊字符！');location.href='post.php';</script& gt;";
exit();
}
if (!ereg("^[0-9]{0,}$",$qq))//用正则检查QQ格式
{
echo "<script>alert('OICQ信息有错误！必须是数字！');location.href='post.php';< /script>";
exit();
}
if($email)
{//如果填写了邮箱就用正则检查邮箱格式
if (!ereg("^[a-zA-Z0-9_\-\.]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$",$email))
{
echo "<script>alert('email格式不正确！');location.href='post.php';< /script>";
exit();
}
}
if(!$username)
{
echo "<script>alert('名称不能为空哦！');location.href='post.php';</script& gt;";
exit();
}
elseif(!$info)
{
echo "<script>alert('留言不能为空哦！');location.href='post.php';</script& gt;";
exit();
}
else
{
$ip = getenv('REMOTE_ADDR');//获取客户端IP地址
??? $sql = "insert into lo (username,sex,qq,email,info,ip,submit_time) values ('$username','$sex','$qq','$email','$info','$ip',NOW())";
??? $result = mysql_query($sql);
??? mysql_close();
??? echo "<script>alert('提交成功！返回首页');location.href='index.php';</script& gt;";
}
?>