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
		
			echo "Բ�������". $area . "ƽ������<br>";
			echo "Բ���ܳ���" . $circle . "����";
			echo "<p>�༶:�Ű�174</p> <p>ѧ��:2017122149</p> <p>����:������</p> ";//Ƕ��h5���룬�������������Ϣ
			
			}
		}
	
?>