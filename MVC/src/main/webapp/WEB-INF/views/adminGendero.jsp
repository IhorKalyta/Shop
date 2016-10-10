<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		<g:forEach items="${gendero}" var="gender">
			<tr>
				
				<td>${gender.name}</td>
				<td><a href="/admin/gender/delete/${gender.id}">delete</a></td>
				<td><a href="/admin/gender/update/${gender.id}">update</a></td>
			</tr>
		</g:forEach>
	</table>
</body>
</html>