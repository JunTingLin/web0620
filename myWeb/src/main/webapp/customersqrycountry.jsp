<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料查詢</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
<script  src="https://code.jquery.com/jquery-3.6.0.min.js"  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="  crossorigin="anonymous"></script>
<script  src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"  integrity="sha256-eTyxS0rkjpLEo16uXTS0uVCS4815lc40K2iVpWDvdSY="  crossorigin="anonymous"></script>

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
				let urlString="http://127.0.0.1:8080/myWeb/api/customers/custqry/rawdata?country="+txtKey;
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
						app.resultData=jsonObject;
						app.messageData={}; //reset {}
						app.isShow=true;
					}else if(xhr.readyState==4 && xhr.status==400){
						console.log(xhr.responseText);
						app.messageData=JSON.parse(xhr.responseText);
						app.isShow=false;
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
		<input type="text" id="country" v-model:text="countryKey" />
		<button id="btnGo">查詢</button>
		<br>
		<div>您輸入查詢國家別:{{countryKey}}</div>
		<br>
		<div style="font-size: 24px; color: red;">{{ messageData.message }}</div>
		<fieldset v-if="isShow">
			<legend>查詢結果</legend>
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<td>客戶編號</td>
						<td>公司行號</td>
						<td>聯絡地址</td>
						<td>EMAIL</td>
						<td>國家別</td>
					</tr>
				</thead>
				<tbody>
					<!-- 經由Vue渲染 走訪所有紀錄 -->
					<tr v-for="cust in resultData">
						<td>{{cust.customerId}}</td>
						<td>{{cust.companyName}}</td>
						<td>{{cust.address}}</td>
						<td>{{cust.email}}</td>
						<td>{{cust.country}}</td>
						<td><Button v-on:click="editForm(cust.customerId)">編輯</Button></td>
					</tr>
				</tbody>
			</table>
			<!-- 對話盒 -->
			<div v-if="isEdit">
				<div id="editForm">
					<fieldset>
						<legend>資料編輯</legend>
					</fieldset>
				</div>
			</div>
		</fieldset>
	</fieldset>

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
					isShow:false,
					isEdit:false
				},
				methods:{
					editForm:function(cid){
						//alert(cid);
						app.isEdit=true;
						$('#editForm').dialog();
					}
				}
			}
		);
	
	</script>
</body>
</html>