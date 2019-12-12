<?php
header("content-type:text/html;charset=gb2312");
 /**
用户自定义str_rev_gb()函数的作用是反转中文字符串
mb_strlen() 获取字符的长度
mb_substr() 获取字符的单个元素
krsort() 按照键值逆序排序数组
implode() 将数组拼接为字符串
explode() 使用字符串分隔字符串
count()......
 */
 

$str1 = "English";  
$str2 = "English中国";  
$str3 = "Eng中lish国";  
$str4 = "中华人民共和国"; 
$str5 = "中<h1>华人民共</h1>和国"; 

function str_rev_gb($str){
	//在此处补齐代码
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

if(strcmp($str4,'中华人民共和国')){
	echo "字符串不相等";
}else{
	echo "字符串相等";
}
echo '<hr>';  
echo htmlspecialchars($str5,ENT_IGNORE,"gb2312");
echo '<hr>'; 
echo strip_tags($str5);
?>