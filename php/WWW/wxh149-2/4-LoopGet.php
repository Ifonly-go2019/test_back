<?php
/*�������һ��PHP�����Լ���ϸ�Ľ��������HTML���룬Ȼ���ȡ�û�����ĵ�ѡ���ֵ��ϵͳ�����û��ύ��ѡ��Զ�����ѡ���Ҫ���������յĽ����
�û��������ʼ���㡱��ť�󣬷ֱ������1+2+3+4+...+99+100=xxx������1+3+5+...+99=xxx������2+4+6+...+100=xxx���Լ���ϵͳ�ĳ�ʼ�ܺ�Ϊ��xxx����
*/

function fun_For(){
	//�ڴ˴��������
	$value=0;
	for($i=1;$i<101;$i++){
		$value=$i+$value;
		
	}
	echo "1+2+3+4+...+99+100=$value";
	echo "<p>�༶:�Ű�174</p> <p>ѧ��:2017122149</p> <p>����:������</p> ";//Ƕ��h5���룬�������������Ϣ
	
}

function fun_While(){
	//�ڴ˴��������
	$value=0;
	$i=1;
	WHILE($i<100){
		$value=$i+$value;
		$i++;
	}
	echo "1+2+3+4+...+99=$value";
	echo "<p>�༶:�Ű�174</p> <p>ѧ��:2017122149</p> <p>����:������</p> ";//Ƕ��h5���룬�������������Ϣ
}

function fun_DoWhile(){
	//�ڴ˴��������
	$value=0;
	$i=0;
	DO{
	$value=$i+$value;
	$i=$i+2;	
	}WHILE($i<102);
	echo "2+4+...+98+100=$value";
	echo "<p>�༶:�Ű�174</p> <p>ѧ��:2017122149</p> <p>����:������</p> ";//Ƕ��h5���룬�������������Ϣ
	
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
					echo "ϵͳ�ĳ�ʼ�ܺ�Ϊ:$sum";
					break;
			}
		}
		else	
		{
				echo "��ѡ��һ��ѡ��";
		}
}
?>