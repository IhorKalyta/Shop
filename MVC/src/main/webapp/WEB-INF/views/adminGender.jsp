<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/admin">Back to admin page</a>
	<form:form action="/admin/gender" method="post" modelAttribute="gender">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		<g:forEach items="${genders.content}" var="gender">
			<tr>
				<td>${gender.id}</td>
				<td>${gender.name}</td>
				<td><a href="/admin/gender/delete/${gender.id}">delete</a></td>
				<td><a href="/admin/gender/update/${gender.id}">update</a></td>
			</tr>
		</g:forEach>
		<tr>
				<g:if test="${!genders.isFirst()}">
					<td><a href="?page=${genders.number}&size=${genders.size}&sort=${param['sort']}">Previous</a></td>
				</g:if>
				<g:if test="${!genders.isLast()}">
					<td><a href="?page=${genders.number+2}&size=${genders.size}&sort=${param['sort']}">Next</a></td>
				</g:if>
			</tr>
			<tr>
				<td><a href="?page=1&size=1&sort=${param['sort']}">1</a></td>
				<td><a href="?page=1&size=5&sort=${param['sort']}">5</a></td>
				<td><a href="?page=1&size=10&sort=${param['sort']}">10</a></td>
				<td><a href="?page=1&size=20&sort=${param['sort']}">20</a></td>
			</tr>
			<tr>
				<td><a href="?page=1&size=${genders.size}&sort=name">Name asc</a></td>
				<td><a href="?page=1&size=${genders.size}&sort=name,desc">Name desc</a></td>
			</tr>
	</table>
</body>
</html>