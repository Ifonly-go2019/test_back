<?php
header("content-type:text/html;charset=gb2312");
 /**
�û��Զ���str_rev_gb()�����������Ƿ�ת�����ַ���
mb_strlen() ��ȡ�ַ��ĳ���
mb_substr() ��ȡ�ַ��ĵ���Ԫ��
krsort() ���ռ�ֵ������������
implode() ������ƴ��Ϊ�ַ���
explode() ʹ���ַ����ָ��ַ���
count()......
 */
 

$str1 = "English";  
$str2 = "English�й�";  
$str3 = "Eng��lish��";  
$str4 = "�л����񹲺͹�"; 
$str5 = "��<h1>������</h1>�͹�"; 

function str_rev_gb($str){
	//�ڴ˴��������
	$length=mb_strlen($str,"gb2312");
	 $array=array();
	
	for($i=0;$i<$length;$i++){
		 $array[]=mb_substr($str,$i,1,'GB2312');
	}
	
	krsort($array);
	$string=implode($array);
    return $string;
}



 
echo $str1 . "->" ;  
echo str_rev_gb($str1) . "<br>";
echo $str2 . "->" ;  
echo  str_rev_gb($str2) . "<br>";
echo $str3 . "->" ;  
echo  str_rev_gb($str3) . "<br>";
echo $str4 . "->" ;  
echo str_rev_gb($str4) . "<br>";
  
echo '<hr>';  
echo iconv_substr($str4,1,-3,"gb2312"); 
echo '<hr>';  

if(strcmp($str4,'�л����񹲺͹�')){
	echo "�ַ��������";
}else{
	echo "�ַ������";
}
echo '<hr>';  
echo htmlspecialchars($str5,ENT_IGNORE,"gb2312");
echo '<hr>'; 
echo strip_tags($str5);
?>