<?php
/*补充完成一个PHP程序，自己仔细的解读给定的HTML代码，然后获取用户输入的单选框的值。系统根据用户提交的选项，自动按照选项的要求计算出最终的结果。
用户点击“开始计算”按钮后，分别输出“1+2+3+4+...+99+100=xxx”，“1+3+5+...+99=xxx”，“2+4+6+...+100=xxx”以及“系统的初始总和为：xxx”。
*/

function fun_For(){
	//在此处补齐代码
	$value=0;
	for($i=1;$i<101;$i++){
		$value=$i+$value;
		
	}
	echo "1+2+3+4+...+99+100=$value";
	echo "<p>班级:信安174</p> <p>学号:2017122149</p> <p>姓名:王晓辉</p> ";//嵌套h5代码，换行输出个人信息
	
}

function fun_While(){
	//在此处补齐代码
	$value=0;
	$i=1;
	WHILE($i<100){
		$value=$i+$value;
		$i++;
	}
	echo "1+2+3+4+...+99=$value";
	echo "<p>班级:信安174</p> <p>学号:2017122149</p> <p>姓名:王晓辉</p> ";//嵌套h5代码，换行输出个人信息
}

function fun_DoWhile(){
	//在此处补齐代码
	$value=0;
	$i=0;
	DO{
	$value=$i+$value;
	$i=$i+2;	
	}WHILE($i<102);
	echo "2+4+...+98+100=$value";
	echo "<p>班级:信安174</p> <p>学号:2017122149</p> <p>姓名:王晓辉</p> ";//嵌套h5代码，换行输出个人信息
	
}

$sum=0;
if(isset($_POST['submit']))
{
	if(isset($_POST['option']))
		{
			$option=$_POST['option'];
			switch($option)
			{
				case "option_1":
					fun_For();					
					break;
				case "option_2":
					fun_While();
					break;
				case "option_3":
					fun_DoWhile();
					break;
				case "option_4":
					echo "系统的初始总和为:$sum";
					break;
			}
		}
		else	
		{
				echo "请选择一个选项";
		}
}
?>