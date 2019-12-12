<?php
session_start();
$_SESSION["key"] = 0;//使SESSION不为1，0为游客，1为管理员
header('location:index.php');
?>