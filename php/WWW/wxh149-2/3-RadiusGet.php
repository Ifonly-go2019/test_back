<?php

	define("PI","3.14");
	if(isset($_POST['submit']))
	{
		
		
		$radius=$_POST['radius'];
		
		if($radius==""|| $radius<=0|| floor($radius)!=$radius ){
			
		header('location:http://localhost/wxh149-2/3-Radius.html');
		}
		else{
							
			$area=PI*$radius*$radius;
			$circle=2*PI*$radius;
		
			echo "圆的面积是". $area . "平方厘米<br>";
			echo "圆的周长是" . $circle . "厘米";
			echo "<p>班级:信安174</p> <p>学号:2017122149</p> <p>姓名:王晓辉</p> ";//嵌套h5代码，换行输出个人信息
			
			}
		}
	
?>