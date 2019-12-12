<?php 

if (isset($_COOKIE["user"]["NameWXH"]) && isset($_COOKIE["user"]["pwd"])){

if (($_FILES["file"]["type"] == "image/jpeg")&& ($_FILES["file"]["size"] < 20000))
{
    if ($_FILES["file"]["error"] > 0)
    {
        echo "错误：: " . $_FILES["file"]["error"] . "<br/>";
    }
    else
    {	
		$name=rand(0, 99999);
		$pathinfo="D:\\use\\phpstudy\\PhpStudy2018\\PHPTutorial\\WWW\\img\\upload\\";
		move_uploaded_file($_FILES["file"]["tmp_name"], "$pathinfo" . "$name.jpg" );
        
		list($width, $height, $type, $attr) = getimagesize("$pathinfo" . "$name.jpg");
		
		if($width<=120||$height<=150){
        echo "上传文件名: " . $_FILES["file"]["name"] . "<br>";
        echo "文件类型: " . $_FILES["file"]["type"] . "<br>";
        echo "文件大小: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
		echo "文件宽度："
        echo "文件临时存储的位置: " . $_FILES["file"]["tmp_name"] . "<br>";
		echo "文件存储在: " . "img/upload/" . "$name.jpg" . "<br>";
   
		echo "<img src='/img/upload/$name.jpg'>";	
        }
		else{
			echo "文件大小有误";
		}
       
    }
}
else
{
    echo "非法的文件格式";
}

	
}else{
	header('http://localhost/WXH149-3/WXH149-3-1.php');
}
?>