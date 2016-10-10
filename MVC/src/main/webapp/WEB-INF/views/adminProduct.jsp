<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/resources/css/product.css">



<script>
	$(function() {
		$('select[name=country]').chosen();
		$('select[name=color]').chosen();
		$('select[name=category]').chosen();
		$('select[name=gender]').chosen();
		$('select[name=type]').chosen();
		$('select[name=gendero]').chosen();
	});
</script>

<div class="row-fluid">
	<div class="col-md-10">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="">
					<ul class="nav navbar-nav">
						<li><a href="/admin/user">Users</a></li>
						<li><a href="/admin/country">Country</a></li>
						<li><a href="/admin/category">Category</a></li>
						<li><a href="/admin/color">Color</a></li>
						<li><a href="/admin/gender">Gender</a></li>
						<li><a href="/admin/type">Type</a></li>
						<li class="active"><a href="/admin/product">Product</a><span
							class="sr-only">(current)</span></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="col-md-2">
		<div class="col-md-6">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Sort <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<custom:sort innerHtml="Product name asc" paramValue="name" />
					<custom:sort innerHtml="Product name desc" paramValue="name,desc" />
					<custom:sort innerHtml="Price asc" paramValue="price" />
					<custom:sort innerHtml="Price desc" paramValue="price,desc" />
					<custom:sort innerHtml="Color name asc" paramValue="color.name" />
					<custom:sort innerHtml="Color name desc"
						paramValue="color.name,desc" />
					<custom:sort innerHtml="Country name asc" paramValue="country.name" />
					<custom:sort innerHtml="Country name desc"
						paramValue="country.name,desc" />
					<custom:sort innerHtml="Category name asc"
						paramValue="category.name" />
					<custom:sort innerHtml="Category name desc"
						paramValue="category.name,desc" />
					<custom:sort innerHtml="Gender name asc" paramValue="gender.name" />
					<custom:sort innerHtml="Gender name desc"
						paramValue="gender.name,desc" />
					<custom:sort innerHtml="Type name asc" paramValue="type.name" />
					<custom:sort innerHtml="Type name desc" paramValue="type.name,desc" />
				</ul>
			</div>
		</div>
		<div class="col-md-6">
			<custom:size posibleSizes="1,2,5,10" size="${product.size}"
				title="Page sizes" />
		</div>
	</div>
</div>


<div class="row-fluid">




	<div class="col-md-3 col-lg-3 col-xs-12">


		<%-- <form:form action="/admin/product" class="form-inline" method="get"
			modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search" />
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />

				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
		<br> --%>

		<form:form action="/admin/product" class="form-inline" method="get"
			modelAttribute="filter">
			<custom:hiddenInputs
				excludeParams="min, max, categoryIds, colorIds, countryIds, genderIds, genderoIds, search ,typeIds _categoryIds, _colorIds, _countryIds, _genderIds, _typeIds,_genderoIds,_search" />

			

				<div class="form-group">
					<form:input path="search" placeholder="search by name"
						class="form-control" />
				</div>
				<div class="form-group">
					<form:input path="min" placeholder="min price" class="form-control" />
				</div>
				<div class="form-group">
					<form:input path="max" placeholder="max price" class="form-control" />
				</div>
				
				<div class="form-group">
					<h4>Category</h4>
					
					<form:checkboxes items="${category}" path="categoryIds"
						itemLabel="name" itemValue="id" />
				
				
				
					<h4>Color</h4>
					<form:checkboxes items="${color}" name="checkbox" path="colorIds"
						itemLabel="name" itemValue="id" />
				

				
					<h4>Country</h4>
					
					<form:checkboxes items="${countries}" path="countryIds"
						itemLabel="name" itemValue="id" />
				



				
					<h4>Gender</h4>
					
					<form:checkboxes items="${gender}" path="genderIds"
						itemLabel="name" itemValue="id" />
				

				
					<h4>Type</h4>
					
					<form:checkboxes items="${types}" path="typeIds" itemLabel="name"
						itemValue="id" />
				

				
					<h4>Gendero</h4>
					
					<form:checkboxes items="${genderos}" path="genderoIds" />
				

				
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			
		</form:form>

	</div>

	<div class="col-md-9 col-xs-12">
		<form:form action="/admin/product" method="post" modelAttribute="form"
			class="form-inline" enctype="multipart/form-data">
			<form:errors path="*" />
			<form:hidden path="id" />
			<form:hidden path="path" />
			<form:hidden path="version" />
			<custom:hiddenInputs
				excludeParams="name, price, size, description, country, color, category, gender, type, gendero, id, path, version" />
			<div class="form-group">
				<form:input id="name" path="name" placeholder="name"
					class="form-control" />
				<label for="name"><form:errors path="name" /></label>

				<form:input path="size" placeholder="size" class="form-control" />
				<label for="size"><form:errors path="size" /></label>


				<form:input path="description" placeholder="description" class="form-control" />
				<label for="description"></label>
				
				<form:input path="price" class="form-control" />
				<label for="price"><form:errors path="price" /></label>
				<form:select path="country" items="${countries}" itemLabel="name"
					itemValue="id">
				</form:select>
				<form:select path="color" items="${color}" itemLabel="name"
					itemValue="id">
				</form:select>
				<form:select path="category" items="${category}" itemLabel="name"
					itemValue="id">
				</form:select>
				<form:select path="gender" items="${gender}" itemLabel="name"
					itemValue="id">
				</form:select>
				<form:select path="type" items="${types}" itemLabel="name"
					itemValue="id">
				</form:select>
				<form:select path="gendero" items="${genderos}">
				</form:select>
				<input type="file" name="file">
				<button type="submit" class="btn btn-success">Create</button>
			</div>
		</form:form>
		<div class="row">
			<div class="col-md-2">Image</div>
			<div class="col-md-1">Name</div>
			<div class="col-md-1">Price</div>
			<div class="col-md-1">Size</div>
			<div class="col-md-1">Category</div>
			<div class="col-md-1">Country</div>
			<div class="col-md-1">Color</div>
			<div class="col-md-1">Type</div>
			<div class="col-md-1">Gendero</div>
			<div class="col-md-1">
				<h4>Delete</h4>
			</div>
			<div class="col-md-1">
				<h4>Update</h4>
			</div>
		</div>
		<c:forEach items="${product.content}" var="product">
			<div class="row">
				<div class="col-md-2">
					<img class="img-thumbnail" width="100"
						src="/images/product/${product.id}${product.path}?version=${product.version}" />
				</div>
				<div class="col-md-1">${product.name}</div>
				<div class="col-md-1">${product.price}</div>
				<div class="col-md-1">${product.size}</div>
				<div class="col-md-1">${product.category.name}</div>
				<div class="col-md-1">${product.country.name}</div>
				<div class="col-md-1">${product.color.name}</div>
				<div class="col-md-1">${product.type.name}</div>
				<div class="col-md-1">${product.gendero}</div>

				<div class="col-md-1">
					<a href="/admin/product/delete/${product.id}<custom:allParams/>">delete</a>
				</div>
				<div class="col-md-1">
					<a href="/admin/product/update/${product.id}<custom:allParams/>">update</a>
				</div>
			</div>
		</c:forEach>

		<div class="col-md-12 text-center">
			<custom:pageable page="${product}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>


</div>
