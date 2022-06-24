<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入狀態</title>
</head>
<body>
	<%
		String com="巨匠電腦";
		pageContext.setAttribute("com", com);
	%>
	<h1>100x50=${ 100*50 }</h1>
	<h1>區域變數: ${ com }</h1>
	<h1>message資料:${ requestScope.message }</h1>
	<h1>Session狀態: ${ sessionScope.cred }</h1>
	<h1>應用系統範圍: ${ applicationScope.datasource }</h1>
	<!-- 前面Scope皆可簡寫不打，因為只有一個 -->
</body>
</html>