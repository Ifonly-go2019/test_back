<?php
require_once("conn.php");
require_once("header.php");
session_start();
//分页代码开始
$pagesize = 5;//设置每页显示条数
$rs = mysql_query("select count(*) from lo");//取得记录总数，计算总页数用
$myrow = mysql_fetch_array($rs);
$numrows = $myrow[0];//计算总记录
$pages = intval($numrows/$pagesize);
if($numrows%$pagesize)$pages++;// 设置页数
if(isset($_GET['page']))
{
$page = intval($_GET['page']);
}
else
{
$page = 1;//设为第一页
}
$offset = $pagesize*($page-1);//计算记录偏移量
//分页代码结束

$sql = "select id,username,sex,qq,email,info,ip,DATE_FORMAT(submit_time, '%Y年%m月%d日 %T' ) from lo order by id desc limit $offset,$pagesize";//用到了DATE-FORMAT格式化日期格式
$result = mysql_query($sql);
$num = mysql_num_rows($result);
if($num>0){
while($row = mysql_fetch_array($result))
{
//echo print_r($row);
if($row[2]=="男"){
$sex = "帅哥";
}
else
{
$sex = "美女";
}
?>
<div id="show">
<p class="num">第 [<?= $row[0] ?>] 条留言<p>
<p class="unline">留言人:<span class="blue"><?= $row[1]?></span>&nbsp;&nbsp;性别:<?= $sex ?>&nbsp;&nbsp;留言时间：<?= $row[7] ?>&nbsp;<? if($row[3]) {?>&nbsp;<a href="http://wpa.qq.com/msgrd?V=1&Uin=<?= $row[3] ?>&Site=http://www.loai.cn&Menu=yes"><img src="img/qq.gif" alt="<?= $row[3]?>" /></a><? } ?><? if($row[4]){ ?>&nbsp;<a href="mailto:<?= $row[4] ?>"><img src="img/email.gif" alt="<?= $row[4]?>" /></a>&nbsp;<? }?><? if($_SESSION["key"]==1){ ?>&nbsp;IP:<?= $row[6] ?>&nbsp;&nbsp;<a href="update.php?wuleying&id=<?= $row[0]?>">更改</a>&nbsp;<a href="delete.php?wuleying&id=<?= $row[0]?>">删除</a><?}?></a></p>
<p class="blue">留言内容:</p>
<div id="show_info"><?= nl2br(htmlspecialchars($row[5])) ?></div>
</div>
<?php
}
}
else
{
echo "<div id=\"show\">无数据......</div>";
}
?>
<div id="show_page">
<p>
<?php
$first=1;
$prev=$page-1;
$next=$page+1;
$last=$pages;
if($page==1&&$pages>1)
{
echo "首页&nbsp;|&nbsp;";
echo "上一页&nbsp;|&nbsp;";
echo "<a href=\"index.php?page=".$next."\">下一页</a>&nbsp;|& nbsp;";
echo "<a href=\"index.php?page=".$last."\">尾页</a>&nbsp;|&nbsp;";
}
elseif($page>=1&&$page!=$pages&&$num>0)
{
echo "<a href=\"index.php?page=".$first."\">首页</a>&nbsp;|& nbsp;";
echo "<a href=\"index.php?page=".$prev."\">上一页</a>&nbsp;|& nbsp;";
echo "<a href=\"index.php?page=".$next."\">下一页</a>&nbsp;|& nbsp;";
echo "<a href=\"index.php?page=".$last."\">尾页</a>&nbsp;|&nbsp;";
}
elseif($page==$pages&&$page!=1)
{
echo "<a href=\"index.php?page=".$first."\">首页</a>&nbsp;|& nbsp;";
echo "<a href=\"index.php?page=".$prev."\">上一页</a>&nbsp;|& nbsp;";
echo "下一页&nbsp;|&nbsp;";
echo "尾页&nbsp;|&nbsp;";
}
elseif($page==$pages)
{
echo "首页&nbsp;|&nbsp;";
echo "上一页&nbsp;|&nbsp;";
echo "下一页&nbsp;|&nbsp;";
echo "尾页&nbsp;|&nbsp;";    
}
else
{
echo "首页&nbsp;|&nbsp;";
echo "上一页&nbsp;|&nbsp;";
echo "下一页&nbsp;|&nbsp;";
echo "尾页&nbsp;|&nbsp;";
}
?>
共&nbsp;<span><?= $pages ?></span>&nbsp;页&nbsp;|&nbsp;当前 第&nbsp;<span><?= $page ?></span>&nbsp;页&nbsp;|&nbsp; 共&nbsp;<span><?=$numrows ?></span>&nbsp条留言</p>
</div>

<?php
mysql_close();
?>
<?php
require_once("footer.php");
?>