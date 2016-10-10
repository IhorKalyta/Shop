<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="">
					<ul class="nav navbar-nav">
						<li><a href="/admin/user">Users</a></li>
						<li><a href="/admin/country">Country</a></li>
						<li><a href="/admin/category">Category</a></li>
						<li><a href="/admin/color">Color</a></li>
						<li><a href="/admin/gender">Gender</a></li>
						<li class="active"><a href="/admin/type">Type</a><span
							class="sr-only">(current)</span></li>
						<li><a href="/admin/product">Product</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>

<a href="/admin">Back to admin page</a>
<div class="col-md-3 col-xs-12">
	<div class="col-md-12 col-xs-12">
		<form:form action="/admin/type" class="form-inline" method="get"
			modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search" />
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<label></label>
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	</div>
</div>

<div class="col-md-7 col-xs-12">
	<div class="col-md-12 col-xs-12">
		<form:form action="/admin/type" method="post" class="form-inline"
			modelAttribute="type">

			<form:hidden path="id" />
			<custom:hiddenInputs excludeParams="name, id" />
			<div class="form-group">
				<form:input id="name" path="name" placeholder="type name"
					class="form-control" />
				<label for="name"><form:errors path="name" /></label>
				<button type="submit" class="btn btn-primary">Create type</button>
			</div>
		</form:form>
	</div>
	<div class="col-md-4 col-xs-4">
		<h4>Type name</h4>
	</div>
	<div class="col-md-4 col-xs-4">
		<h4>Delete</h4>
	</div>
	<div class="col-md-4 col-xs-4">
		<h4>Update</h4>
	</div>
	<t:forEach items="${types.content}" var="type">
		<div class="col-md-4 col-xs-4">${type.name}</div>
		<div class="col-md-4 col-xs-4">
			<a href="/admin/type/delete/${type.id}<custom:allParams/>">delete</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a href="/admin/type/update/${type.id}<custom:allParams/>">update</a>
		</div>
	</t:forEach>
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${types}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
<div class="col-md-2 col-xs-12">
	<div class="col-md-6 col-xs-6 text-center">
		<div class="dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Sort <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<custom:sort innerHtml="Name asc" paramValue="name" />
				<custom:sort innerHtml="Name desc" paramValue="name,desc" />
			</ul>
		</div>
	</div>
	<div class="col-md-6 col-xs-6 text-center">
		<custom:size posibleSizes="1,2,5,10" size="${types.size}"
			title="Page size" />
	</div>
</div>