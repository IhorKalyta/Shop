<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="o"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>ORDERS</p>
<form action="/admin/orders" method="post">
		<table>
		<tr>
				<td><input name="amount" placeholder="amount"></td>
			</tr>
			
			<tr>
				<td>
					<select name="clientId">
						<o:forEach items="${client}" var="client">
							<option value="${client.id}">
								${client.username}
							</option>
						</o:forEach>
					</select>
				</td>
				</tr>
				<tr>
				<td>
					<select name="productId">
						<o:forEach items="${products}" var="product">
							<option value="${product.id}">
								${product.name}
							</option>
						</o:forEach>
					</select>
				</td>
					
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
<table>
		<tr>
			<th>id</th>
			<th>amount</th>
			<th>username</th>
			<th>product</th>
		</tr>
		<o:forEach items="${orders}" var="orders">
			<tr>
				<td>${orders.id}</td>
				<td>${orders.amount}</td>
				<td>${orders.client.username}</td>
				<o:forEach items="${orders.products}" var="product">
				<td>${product.name}</td>
			</o:forEach>	
				
				
				<td>
					<a href="/admin/orders/delete/${orders.id}">delete</a>
				</td>
				<td>
					<a href="/admin/orders/update/${orders.id}">update</a>
				</td>
			</tr>
		</o:forEach>
	</table>
</body>
</html>