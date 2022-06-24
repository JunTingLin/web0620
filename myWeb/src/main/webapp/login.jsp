<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入作業</title>
</head>
<body>
	<fieldset>
		<legend>登入作業</legend>
		<form method="post" action="LoginValidServlet">
			<div>使用者帳戶</div>
			<input type="text" name="username" />
			<div>使用者密碼</div>
			<input type="password" name="password" /> <input type="submit"
				value="登入" />
		</form>

	</fieldset>
</body>
</html>