<?php
session_start();
require_once('conn.php');
require_once('header.php');

if($_SESSION["key"]==1)
{
$id = $_GET['id'];
$sql = "select * from lo where id= ".$id;
$result = mysql_query($sql);
$row = mysql_fetch_array($result);
?>
<div id="update">
<form action="updatepost.php?wuleying&id=<?= $row[0] ?>" method="post">
<h1>�޸�����</h1>
<p>������<input type="text" value="<?= $row[1]?>" name="name" class="y"></input></p>
<p>���ԣ�</p>
<p><textarea? name="info" rows="5" cols="35"><?= $row[5] ?></textarea></p>
<p class="cen"><input type="submit" value="��Ҫ�޸�" /></p>
<p class="cen1">�ҵ����԰� Version 1.0</p>
</form>
<div>

<?php
}
else
{
header('location:index.php');
}
?>