<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

	<c:if test="${ requestScope.myCustomersList.size()==0 }">
		<p>查無國家別: ${param.country} 資料</p>
	</c:if>
	<c:if test="${ requestScope.myCustomersList.size() > 0 }">
		<p>紀錄筆數: ${requestScope.myCustomersList.size()} 資料</p>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<td>編號</td>
					<td>公司行號</td>
					<td>聯絡地址</td>
					<td>聯絡電話</td>
					<td>EMAIL</td>
					<td>國家別</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ requestScope.myCustomersList }" var="customer">
					<tr>
						<td>${pageScope.customer.customerId}</td>
						<td>${customer.companyName}</td>
						<td>${customer.address}</td>
						<td>${customer.phone}</td>
						<td>${customer.email}</td>
						<td>${customer.country}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

</body>
</html>