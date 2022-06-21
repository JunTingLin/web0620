<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我是首頁</title>
</head>
<body>
	<!-- 一段小小的Java Scriptlet -->
	<%
	for (int s = 1; s <= 3; s++) {
		out.print("hello" + s + "<br>");
	}
	%>
</body>
</html>