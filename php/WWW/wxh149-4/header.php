<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title> �ҵ����԰� Version 1.0</title>
</head>
<link href="css.css" rel="stylesheet" type="text/css" />
<body>
<div id="head">
<div id="head_l">
<ul>
<li><a href="index.php">��Ҫ������</a></li>
<li><a href="post.php">��Ҫ����</a></li>
<?php
session_start();
if($_SESSION["key"]==1){//�����ȡ��SESSIONΪ1����ʾ������
?>
<li><a href="adminexit.php">�˳�����</a></li>
<?php 
}
else
{
?>
<li><a href="admin.php">��Ҫ����</a></li>
<?php } ?>
</ul>
</div>
<div id="head_r">�ҵ����԰� Version 1.0</div>
</div>