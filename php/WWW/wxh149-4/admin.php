<?php
require_once('conn.php');
require_once('header.php');
?>
<div id="admin">
<form method="post" action="adminpost.php">
<h1>管理员登录</h1>
<p>姓名 : <input type="text" name="name" size="20" class="y" />&nbsp;</p>
<p>密码 : <input type="password" name="password" size="20" class="y" />&nbsp;</p>
<p class="cen"><input type="submit" value="管理员登录" /></p>
<p class="cen1">我的留言板 Version 1.0</p>
</form>
</div>