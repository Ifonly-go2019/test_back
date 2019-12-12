<?php 
error_reporting(0);
if (isset($_COOKIE["user"])){
	if($_POST['NameWXH']=="wxh"&&$_POST['PW149']=="149"||$_POST['NameWXH']==""||$_POST['PW149']==""){
	//foreach($_COOKIE["user"] as $key=>$value){
	//echo $key . '=>' . $value . ' ';
	echo "姓名:" . $_COOKIE["user"]["NameWXH"];
	echo  "学号:" . $_COOKIE["user"]["pwd"]. '<br>'  ;
	//}
	
	
	echo'<html><body>
<div style="border:1px solid #06f; background:#bbdeff; width:600px; height:200px; ">
 
 <form method="post" action="WXH149-3-3.php" enctype="multipart/form-data">
  <h1 style="color:red;">可以上传2*3厘米的图像(image/jpeg)</h1>
   <label for="file">文件名：</label><br>
    <input type="file" name="file" id="file"><br>
    <input type="submit" name="submit" value="提交">
 
 </form></div></body></html>';
	}else if($_POST['NameWXH']==""||$_POST['PW149']==""){
		header('http://localhost/WXH149-3/WXH149-3-1.php');
	}
}
else
	if($_POST['NameWXH']=="wxh"&&$_POST['PW149']=="149"){
	    setcookie("user[NameWXH]",$_POST["NameWXH"],time()+3600*intval($_POST['Save']));
		setcookie("user[pwd]",$_POST["PW149"],time()+3600*intval($_POST['Save']));
		setcookie("user[dt]",date("Y-m-d h:i:s"),time()+3600 * intval($_POST['Save']));
		setcookie("user[num]",1,time()+3600*intval($_POST['Save']));
		setcookie("user[expire]",$_POST['Save'],time()+3600*intval($_POST['Save']));
		echo $_POST["NameWXH"].":欢迎光临";
	}
		else{
			echo "<script>alert('用户名或密码不对');location.herf='gch120-3-1.php';</script>";
			header('http://localhost/WXH149-3/WXH149-3-1.php');
		}
?>