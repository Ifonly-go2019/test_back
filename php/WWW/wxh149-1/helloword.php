<html>
<?php
header("Content-Type:text/html;charset=gb2312");
$today=date("Y年m月d日H时i分s秒"); //利用系统自带的date函数将时间赋值到变量中
echo "Hello World " ;//返回helloword
echo "<p>班级:信安174</p> <p>学号:2017122149</p> <p>姓名:王晓辉</p> ";//嵌套h5代码，换行输出个人信息
echo "<p>$today</p>"//输出时间信息
?>

</html>