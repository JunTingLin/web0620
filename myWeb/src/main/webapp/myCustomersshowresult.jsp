<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶新增結果</title>
</head>
<body>
	<div>執行狀態:${param.state}</div>
	<!-- 取出Session範圍JavaBean -->
	<jsp:useBean id="customers" class="com.gjun.beans.MyCustomers"
		scope="session"></jsp:useBean>
	<!-- 鋪畫面 -->
	<table>
		<tr>
			<td>客戶編號</td>
			<td>${customers.customerId}</td>
		</tr>
		<tr>
			<td>公司行號</td>
			<td>${customers.companyName}</td>
		</tr>
		<tr>
			<td>聯絡地址</td>
			<td>${customers.address}</td>
		</tr>
		<tr>
			<td>連絡電話</td>
			<td>${customers.phone}</td>
		</tr>
		<tr>
			<td>EMAIL</td>
			<td><%=customers.getEmail() %></td>
		</tr>
		<tr>
			<td>國家別</td>
			<td>${customers.getCountry()}</td>
		</tr>
	</table>
</body>
</html>