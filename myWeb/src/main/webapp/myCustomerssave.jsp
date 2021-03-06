<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料儲存</title>
</head>
<body>
	<jsp:useBean id="customers"  class="com.gjun.beans.MyCustomers" scope="session"></jsp:useBean>
	<!-- 自動封存 -->
	<jsp:setProperty property="*" name="customers"/>
	
	<!--<jsp:useBean id="datasource" class="com.mysql.cj.jdbc.MysqlDataSource" scope="application"></jsp:useBean>-->
	<jsp:useBean id="dao" class="com.gjun.domain.MyCustomersDao"></jsp:useBean>
	
	<!-- 因為沒有其他層面有定datasource，所以不寫"applicationScope."也可 -->
	<jsp:setProperty property="dataSource" name="dao" value="${datasource}"/>
	<%
	//dao.setDataSource(datasource);	
	dao.insert(customers);
	%>
	
	<jsp:forward page="myCustomersshowresult.jsp">
		<jsp:param value="新增記錄完成" name="state"/>
	</jsp:forward>
	
	<jsp:getProperty property="customerId" name="customers"/>
</body>
</html>