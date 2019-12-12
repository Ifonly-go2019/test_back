<?php
$counterFile="wxh149.xml";  //（改为自己的姓名的声母+学号后三位，比如wjj021.xml）
function displayCounter($counterFile){
$fp  =  fopen($counterFile,"rw");
$num =  fgets($fp,5);
$num += 1;
print "<div id=\"footer\">我的留言板 Version 1.0&nbsp;&nbsp;&nbsp;您是第&nbsp;"."$num"."&nbsp;位访问者</div>";
exec("rm -rf $counterFile");
exec("echo $num > $counterFile");
}
if(!file_exists($counterFile)){
exec("echo 0 > $counterFile");
}
displayCounter($counterFile);
?>
</body>
</html>