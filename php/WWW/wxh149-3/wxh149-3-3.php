<?php 

if (isset($_COOKIE["user"]["NameWXH"]) && isset($_COOKIE["user"]["pwd"])){

if (($_FILES["file"]["type"] == "image/jpeg")&& ($_FILES["file"]["size"] < 20000))
{
    if ($_FILES["file"]["error"] > 0)
    {
        echo "����: " . $_FILES["file"]["error"] . "<br/>";
    }
    else
    {	
		$name=rand(0, 99999);
		$pathinfo="D:\\use\\phpstudy\\PhpStudy2018\\PHPTutorial\\WWW\\img\\upload\\";
		move_uploaded_file($_FILES["file"]["tmp_name"], "$pathinfo" . "$name.jpg" );
        
		list($width, $height, $type, $attr) = getimagesize("$pathinfo" . "$name.jpg");
		
		if($width<=120||$height<=150){
        echo "�ϴ��ļ���: " . $_FILES["file"]["name"] . "<br>";
        echo "�ļ�����: " . $_FILES["file"]["type"] . "<br>";
        echo "�ļ���С: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
		echo "�ļ���ȣ�"
        echo "�ļ���ʱ�洢��λ��: " . $_FILES["file"]["tmp_name"] . "<br>";
		echo "�ļ��洢��: " . "img/upload/" . "$name.jpg" . "<br>";
   
		echo "<img src='/img/upload/$name.jpg'>";	
        }
		else{
			echo "�ļ���С����";
		}
       
    }
}
else
{
    echo "�Ƿ����ļ���ʽ";
}

	
}else{
	header('http://localhost/WXH149-3/WXH149-3-1.php');
}
?>