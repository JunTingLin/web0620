<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="junting" uri="http://www.junting.com.tw/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="myname" value="林俊霆"></c:set>
	<junting:hello/>
	<br>
	<junting:whoHello information="吃飽了沒?" who="${ myname }"/>
	<br>
	<junting:whoLoopHello counter="3" information="累了嗎?" who="${ myname }">testing</junting:whoLoopHello>
	<br>
	<!-- 中間可搭配EL抓進去處理 -->
	<junting:bufferTag>buffer tag ${ myname }!!!</junting:bufferTag>
	<br>
	<junting:includeTag>include tag ${ myname }!!!</junting:includeTag>
</body>
</html>