<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title> 我的留言板 Version 1.0</title>
</head>
<link href="css.css" rel="stylesheet" type="text/css" />
<body>
<div id="head">
<div id="head_l">
<ul>
<li><a href="index.php">我要看留言</a></li>
<li><a href="post.php">我要发表</a></li>
<?php
session_start();
if($_SESSION["key"]==1){//如果获取的SESSION为1则显示管理项
?>
<li><a href="adminexit.php">退出管理</a></li>
<?php 
}
else
{
?>
<li><a href="admin.php">我要管理</a></li>
<?php } ?>
</ul>
</div>
<div id="head_r">我的留言板 Version 1.0</div>
</div>