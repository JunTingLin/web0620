<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>國家別查詢</title>
</head>
<body>
	
	<form>
		<div>國家數量: ${countries.size()}</div>
		<div>國家陣列:
			<c:out value="${ requestScope.countries }"></c:out>
		</div>
		<div>國家別</div>
		<select>
			<!-- 走回圈將傳遞進來的attribute 國家別清單逐一產生option標籤內容 -->
			<c:forEach var="country" items="${ requestScope.countries }">
				<option value="${ country.toString() }">${ country.toString() }</option>
			</c:forEach>
		</select>
	</form>
</body>
</html>