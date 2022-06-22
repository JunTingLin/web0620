<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊</title>
</head>
<body>
	<!-- 表單頁面 -->
	<form method="post" action="RegisterSaveServlet">
		<div>使用者帳號</div>
		<input type="text" name="username" />
		<div>使用者密碼</div>
		<input type="password" name="password" />
		<div>真實姓名</div>
		<input type="text" name="realname" />
		<div>EMAIL</div>
		<input type="text" name="email" /> <br /> <input type="submit"
			value="註冊" />
	</form>
</body>
</html>