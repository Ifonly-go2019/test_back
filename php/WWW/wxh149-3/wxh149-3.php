<?php 

class wxh{
	var a;
	var b;
	var c;
	function __construct() {
   $this->a = 0;
   $this->b = 0;
   $this->c = 0;
}
	function  getMax($a, $b, $c){
		var maxn;
		if(a>b){
			maxn=a;
		}else{
			maxn=b;
		}
		if(maxn>c){
			maxn=maxn;
		}else{
			maxn=c;
		}
		return maxn;
	}
}



$c = new wxh();
echo "�������Ƚ�ʾ����";
echo $c->getMax(12,26)."<br>";
?>