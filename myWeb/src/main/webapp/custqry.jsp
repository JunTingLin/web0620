<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.sql.DataSource, java.util.*, com.gjun.beans.Customers"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶查詢結果</title>
</head>
<body>
	<jsp:useBean id="dao" class="com.gjun.domain.CustomersDao"></jsp:useBean>
	<jsp:useBean id="datasource" class="com.mysql.cj.jdbc.MysqlDataSource"
	scope="application"></jsp:useBean>
	<%
	String country = request.getParameter("country");
	
	///DataSource datasource = (DataSource)application.getAttribute("datasource"); //改用jsp:useBean
	dao.setDataSource(datasource);
	List<Customers> result = dao.selectForList(country);
	
	%>
	<div>查詢國家:<%=country%></div>
	<div>查詢紀錄筆數:<%=result.size()%></div>
	<!-- 呈現結果 -->
	<table style="width:auto;border:solid;border-width:1;">
		<thead>
			<tr>
				<td>客戶編號</td>
				<td>姓名</td>
				<td>聯絡地址</td>
				<td>聯絡電話</td>
				<td>國家別</td>
			</tr>
		</thead>
		<tbody>
			<%for(Customers customer:result){ %>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getAddress()%></td>
				<td><%=customer.getPhone()%></td>
				<td><%=customer.getCountry()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>