<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 函數庫 函數配合EL去呼叫的 -->
	
	<c:forEach var="language" items='${fn:split("java/c#/python/swift","/")}'>
		<div>${ language }</div>
	</c:forEach>
</body>
</html>