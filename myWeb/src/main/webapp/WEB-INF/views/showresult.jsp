<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.gjun.beans.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊成功</title>
</head>
<body>
	<!-- 取出傳遞進來的users(Request帶來的) -->
	<!-- scriptlet 要下分號 -->
	<%
	//Scriptlet 找出HttpServletRequest物件
	Users users = (Users) request.getAttribute("users");
	%>
	<div>註冊成功</div>
	<div>資訊如下:</div>
	<div>
		使用者帳號:<%=users.getUserName()%></div>
	<!-- expression運算式，不用下分號 -->
</body>
</html>