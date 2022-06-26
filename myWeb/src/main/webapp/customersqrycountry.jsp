<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料查詢</title>
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
<script type="text/javascript">
	//網頁下載時進行初始化
	function init(){
		//參考出標籤物件 設定為區域變數
		let btnGo=document.getElementById('btnGo');
		//alert(btnGo);
		btnGo.addEventListener('click',
				()=>{
					//alert("我是按鈕")
					let txtKey=document.getElementById('country').value;
					console.log(txtKey);
					let urlString="http://127.0.0.1:8080/myWeb/api/Customers/custqry/rawdata?country="+txtKey;
					let xhr = new XMLHttpRequest();
					xhr.onreadystatechange=function(){
						console.log('非同步處理過程:'+xhr.readyState);
						console.log('Http處理狀態碼:'+xhr.status);
						if(xhr.readyState==4 && xhr.status==200){
							//查詢完成有資料
							let result=xhr.responseText;
							console.log(typeof(result));
							//回應是一個字串 轉換成可以操作的Json物件(array or Object)
							//使用現成JSON class
							let jsonObject=JSON.parse(result);
							console.log(jsonObject);
						}else if(xhr.readyState==4 && xhr.status==400){
							console.log(xhr.responseText);
						}
					}
					console.log(xhr);
					xhr.open('GET',urlString,true);
					xhr.send();
				}
		)
	}
</script>

</head>
<body onload="init()">
	<fieldset id="panel">
		<legend>客戶查詢</legend>
		<div>國家別</div>
		<input type="text" id="country" v-model:text="countryKey"/>
		<button id="btnGo">查詢</button>
		<br>
		<div>您輸入查詢國家別:{{countryKey}}</div>
		<fieldset>
			<legend>查詢結果</legend>
		</fieldset>
	</fieldset>

	<!-- 建構一個個體Vue物件 -->
	<script type="text/javascript">
	//建構Vue物件
	var app=new Vue(
			//settings 多參數 不確定數量 採用JavaScript物件
			{
				//綁定的區塊DOM
				el:'#panel',
				//資料模組屬性
				data:{
					countryKey:'TW',
					//查詢結果
					resultData:[], //是一個陣列
					//查詢結果訊息
					messageData:{}, //JavaScript物件
				}
			}
		);
</script>
</body>
</html>