<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			*{
			
				padding: 0;
			}
		
			body{
				background-color: azure;
			}
			
			#wrap{
				width: 500px;
				height: 500px;
				margin: 0 auto;
				border: 1px solid black;
				position: relative;
			}
			#ball1{
				width: 100px;
				height: 100px;
				background: #FF0000;
			    position: absolute;	
				top: 300px;
				
			}
			#ball2{
				width: 100px;
				height: 100px;
				background: #1E90FF;
			    position: absolute;
				bottom: 300px;
				right: 0px;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<div id="ball1"></div>
			<div id="ball2"></div>
		</div>
		<script type="text/javascript">
			var warp=document.getElementById("wrap");
			var ball1=document.getElementById("ball1");
			var ball2=document.getElementById("ball2");
			// 
			var speedx1=5;
			var speedx2=-3;
			var speedy1=2;
			var speedy2=-5;
			
			setInterval(function(){
				ball1.style.left=ball1.offsetLeft+speedx1+"px";
				ball2.style.left=ball2.offsetLeft+speedx2+"px";
				
				
				ball1.style.top=ball1.offsetTop+speedy1+"px";
				ball2.style.top=ball2.offsetTop+speedy2+"px";
				
				
				/*用于判断两个方块是否到达边界*/
				if(ball1.offsetLeft+ball1.offsetWidth>=warp.offsetWidth-2||ball1.offsetLeft<=0){
					speedx1*=-1;
				}
				if(ball2.offsetLeft+ball2.offsetWidth>=warp.offsetWidth-2||ball2.offsetLeft<=0){
					speedx2*=-1;
				}
				
				
				if(ball1.offsetTop+ball1.offsetHeight>=warp.offsetHeight-2||ball1.offsetTop<=0){
					speedy1*=-1;
				}
				
				if(ball2.offsetTop+ball2.offsetHeight>=warp.offsetHeight-2||ball2.offsetTop<=0){
					speedy2*=-1;
				}
			
				
				/*用于判断两方块相撞时*/
				
				
				
				
				if(ball1.offsetLeft>ball2.offsetLeft){                   /*ball1在ball12的左边*/
					if(ball1.offsetLeft-ball2.offsetLeft<ball1.offsetWidth){    /*ball1与ball2的相交*/
					
					// -------------------------------判断开始
					if(ball1.offsetTop<ball2.offsetTop){	/*ball1在ball2的上边*/
					if(ball2.offsetTop-ball1.offsetTop<=ball1.offsetHeight){
						speedx1*=-1;
						speedx2*=-1;
						speedy1*=-1;
						speedy2*=-1;
					}
					}else if(ball1.offsetTop>ball2.offsetTop){
					if(ball1.offsetTop-ball2.offsetTop<=ball2.offsetHeight){
						speedx1*=-1;
						speedx2*=-1;
						speedy1*=-1;
						speedy2*=-1;
					}
					}
					// ----------------------------------------判断结束
					}	
				}
					if(ball1.offsetLeft<ball2.offsetLeft){
						if(ball2.offsetLeft-ball1.offsetLeft<ball1.offsetWidth){
						
						// -------------------------------判断开始
						if(ball1.offsetTop<ball2.offsetTop){	
						if(ball2.offsetTop-ball1.offsetTop<=ball1.offsetHeight){
							speedx1*=-1;
							speedx2*=-1;
							speedy1*=-1;
							speedy2*=-1;
						}
						}else if(ball1.offsetTop>ball2.offsetTop){
						if(ball1.offsetTop-ball2.offsetTop<=ball2.offsetHeight){
							speedx1*=-1;
							speedx2*=-1;
							speedy1*=-1;
							speedy2*=-1;
						}
						}
						
						
						
					}
				
				}
				
			},20)
		</script>
	</body>
</html>
