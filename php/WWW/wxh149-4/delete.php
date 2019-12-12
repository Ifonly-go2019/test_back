<?php
session_start();
require_once('conn.php');
$id=$_GET['id'];
if($_SESSION["key"]==1)
{
$sql = "delete from lo where id=".$id;
mysql_query($sql);
echo "<script>location.href='index.php'</script>";
}
else
{
header('location:index.php');
}
?>