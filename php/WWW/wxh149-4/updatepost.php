<?php
require_once('conn.php');
$username = $_POST['name'];
$info = $_POST['info'];
$id = $_GET['id'];
//echo $id;
$sql = "update lo set username= '".$username."',info='".$info."' where id=".$id;
mysql_query($sql);
echo "<script>alert('�޸ĳɹ���');location.href='index.php';</script& gt;";
?>