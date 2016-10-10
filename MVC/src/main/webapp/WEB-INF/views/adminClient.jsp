<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/admin/client">Client</a><span
							class="sr-only">(current)</span></li>
						<li><a href="/admin/country">Country</a></li>
						<li><a href="/admin/category">Category</a></li>
						<li><a href="/admin/color">Color</a></li>
						<li><a href="/admin/gender">Gender</a></li>
						<li><a href="/admin/type">Type</a></li>
						<li><a href="/admin/product">Product</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>


	
	
	<div class="row-fluid">
		<div class="col-md-3 col-xs-12">
		<a href="/admin"><button type="button" class="btn btn-defaul">Back to admin page</button></a>
		
		<form:form action="/admin/client" class="form-inline" method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search"/>
				<div class="form-group">
					<form:input path="search" placeholder="search" class="form-control" />
					<label></label>
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			</form:form>
		</div>
		
	<div class="col-md-7 col-xs-12">
		<div class="col-md-12 col-xs-12">
			<form:form action="/admin/client" method="post" class="form-inline" 
				modelAttribute="client">
				<form:hidden path="id" />
				<custom:hiddenInputs excludeParams="username, firstName, lastName, email, age, id"/>
				<div class="form-group">
					<form:input id="username" path="username" placeholder="client username" class="form-control" />
					<label for="username"><form:errors path="username" /></label>
					</div>
					<div class="form-group">
					<form:input id="firstName" path="firstName" placeholder="firstName" class="form-control" />
					<label for="firstName"><form:errors path="firstName" /></label>
					</div>
					<div class="form-group">
					<form:input id="lastName" path="lastName" placeholder="lastName" class="form-control" />
					<label for="lastName"><form:errors path="lastName" /></label>
					</div>
					<div class="form-group">
					<form:input id="email" path="email" placeholder="email" class="form-control" />
					<label for="email"><form:errors path="email" /></label>
					</div>
					<div class="form-group">
					<form:input id="age" path="age" placeholder="age" class="form-control" />
					<label for="age"><form:errors path="age" /></label>
					</div>
					<div class="form-group">
					<button type="submit" class="btn btn-success">Create client</button>
				</div>
			</form:form>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2"><h4>userName</h4></div>
			<div class="col-md-2 col-xs-2"><h4>firstName</h4></div>
			<div class="col-md-2 col-xs-2"><h4>lastName</h4></div>
			<div class="col-md-2 col-xs-3"><h4>e-mail</h4></div>
			<div class="col-md-1 col-xs-1"><h4>age</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Delete</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Update</h4></div>
		</div>
			<c:forEach items="${clients.content}" var="client">
			<div class="row">
				<div class="col-md-2 col-xs-2">${client.username}</div>
				<div class="col-md-2 col-xs-2">${client.firstName}</div>
				<div class="col-md-2 col-xs-2">${client.lastName}</div>
				<div class="col-md-2 col-xs-3">${client.email}</div>
				<div class="col-md-1 col-xs-1">${client.age}</div>
				
				<div class="col-md-1 col-xs-1">
					<a href="/admin/client/delete/${client.id}<custom:allParams/>">delete</a>
				</div>
				<div class="col-md-1 col-xs-1">
					<a href="/admin/client/update/${client.id}<custom:allParams/>">update</a>
				</div>
			</div>
			</c:forEach>
			<div class="col-md-12 col-xs-12 text-center">
				<custom:pageable page="${clients}" cell="<li></li>" container="<ul class='pagination'></ul>" />
			</div>
		</div>
	<div class="col-md-2 col-xs-12">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="username"/>
						<custom:sort innerHtml="Name desc" paramValue="username,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${clients.size}" title="Page size"/>
			</div>
		</div>
	</div>
	
	