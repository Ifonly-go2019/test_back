<?php
session_start();
$_SESSION["key"] = 0;//ʹSESSION��Ϊ1��0Ϊ�οͣ�1Ϊ����Ա
header('location:index.php');
?>