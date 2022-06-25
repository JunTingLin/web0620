<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://www.junting.com.tw/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>測試自訂函數庫</title>
</head>
<body>
	<c:set var="names" value="eric,linda,bill,tony,sam,helen"></c:set>
	<c:forEach items='${ fn:separate(names,",") }' var="name">
		<div>${ fn:upper(name) }</div>
	</c:forEach>
</body>
</html>