<html>
<body>
<?php
		//返回开始的语句
		echo "<p>php代码和HTML代码可相互嵌套</p>";
		//开始for循环，将html代码嵌套在php中
		for($i=3;$i<7;$i++){ ?>
		
		<font size="<?php echo "$i" ?>">第<?php echo "$i" ?>次输出</font><br>
<?php
		}//结束for循环
?>
</body>
<?php

echo "<p>班级:信安174</p> <p>学号:2017122149</p> <p>姓名:王晓辉</p> ";//嵌套h5代码，换行输出个人信息
?>
</html>