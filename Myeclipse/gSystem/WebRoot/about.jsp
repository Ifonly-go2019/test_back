<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>留言</title>
		<style type="text/css">
			body{
			}
		/* 	li{
				list-style: none;
				
			} */
			#warring{
				font-size: 12px;
				color: red;
			}
			#btnSent{
			flex: left;
			width: 100px;
			height: 30px;
			border-width: 0px;
			border-radius: 3px;
			background: #1E90FF;
			cursor: pointer;
			outline: none;
			font-family: Microsoft YaHei;
			color: white;
			font-size: 17px;
		
			}
			#listMeg li{
				font-size: 14px;
			}
			#textkey{
				width: 300px;
				height: 25px;
				
			}
			
		</style>
	
	</head>
	<body>
		<div class="main">
				<input type="text"  id="textkey" value="" >
				<input type="button"  id="btnSent" value="发布" >
				<span id="warring"></span>
				<ul id="listMeg">
				  
				</ul>
					
				
		</div>
			
	</body>
	<script type="text/javascript">
		function Appendzero(obj)
    {
        if(obj<10) return "0" +""+ obj;
        else return obj;
   }
		
		
		document.getElementById("btnSent").onclick=function(){
			var textkeyValue =document.getElementById("textkey").value;
			if(textkeyValue.length==0){
				document.getElementById("warring").innerText="请输入要发布的留言!!!!";
			}else{
				document.getElementById("warring").innerText="";
				
				var li=document.createElement("li");
				var listMeg_List=document.getElementById("listMeg");
				
				if(listMeg_List.children.length==0){
				listMeg_List.appendChild(li);
				}else{
					listMeg_List.insertBefore(li,listMeg_List.children[0]);	
				}
				
				var dataNow =new Date();
				var y=dataNow.getFullYear();
				var mo=dataNow.getMonth();
				var d=dataNow.getDay();
				var h=dataNow.getHours();
				var m=dataNow.getMinutes();
				var s=dataNow.getSeconds();
				
				var ymd=[y,Appendzero(mo),Appendzero(d)].join("-");
				var time=[h,Appendzero(m),Appendzero(s)].join(":");
				
				var kg="&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;"
				var sn="------------------------------------------------------------"
			    li.innerHTML=textkeyValue+"<br><br>"+kg+
				ymd+"&nbsp"+time+"<input type='button'  id='btnDel' value='删除' class='del' >"+"<br>"+sn;
				
				
				var btnDel=li.getElementsByTagName("input")[0];
			
				btnDel.onclick=function(){
					alert("要删除吗？");
					var delLi=this.parentNode;
					listMeg_List.removeChild(delLi);
					
				}
			}
			
		  document.getElementById("textkey").value=""; 	
		};
	</script>
</html>
