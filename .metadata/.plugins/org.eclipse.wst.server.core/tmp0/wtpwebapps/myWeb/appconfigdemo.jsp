<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.gjun.entity.AppConfig"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>取得應用系統初始化資料庫組態</title>
</head>
<body>
	<%
	AppConfig con = (AppConfig) application.getAttribute("appConfig");
	String company = con.getCompanyName();
	out.println(company);
	%>
</body>
</html>