<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<link rel="stylesheet" href="/resources/css/form.css">
<link rel="stylesheet" href="/resources/css/product.css">


<div class="head-bread">
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="/">Home</a></li>
			<li class="active">PRODUCTS</li>
		</ol>
	</div>
</div>


<div class="products-gallery">
	<div class="container">


		<div class="col-md-9 grid-gallery">
			<c:forEach items="${product.content}" var="product">
				<div class="col-md-4 grid-stn simpleCart_shelfItem">
					<div class="img">
						<img
							src="/images/product/${product.id}${product.path}?version=${product.version}"
							class="img-responsive gri-wid">
					</div>
					<div class="info">
						<div class="pull-left styl-hdn">
							<h3>${product.name}</h3>
						</div>
						<div class="pull-right styl-price">
							<p>
								<a href="#" class="item_add"><span
									class="glyphicon glyphicon-shopping-cart grid-cart"
									aria-hidden="true"></span> <span class=" item_price">&#36;${product.price}</span></a>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="quick-view">
						<a href="/single/${product.id}">Quick view</a>
					</div>
				</div>
			</c:forEach>
		</div>



		<div class="col-md-3 grid-details">

			<section class="sky-form">
				<form:form action="/product" class="form-inline" method="get"
					modelAttribute="filter">
					<custom:hiddenInputs excludeParams="search" />
					<div class="form-group">
						<form:input path="search" placeholder="search"
							class="form-control" />

						<button type="submit" class="btn btn-success">OK</button>
					</div>
				</form:form>
			</section>

			

			<form:form action="/product" method="get" class="form-inline"
				modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="min, max,categoryIds, colorIds, countryIds, genderIds, genderoIds ,typeIds _categoryIds, _colorIds, _countryIds, _genderIds, _typeIds,_genderoIds" />
				<section class="sky-form" hidden="hidden">
					<h4>
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Gender
					</h4>
					<div class="col col-4">
						<form:checkboxes items="${gender}" path="genderIds"
							itemLabel="name" itemValue="id" />
					</div>
				</section>
				
				<section class="sky-form">
					<form:input path="min" placeholder="min price" class="form-control" />
					<form:input path="max" placeholder="max price" class="form-control" />
				</section>

				<section class="sky-form">
					<h4>
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Category
					</h4>

					<div class="col col-4">
						<form:checkboxes items="${category}" path="categoryIds"
							itemLabel="name" itemValue="id" />
					</div>
				</section>

				<section class="sky-form">
					<h4>
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Color
					</h4>

					<div class="col col-4">
						<form:checkboxes items="${color}" path="colorIds" itemLabel="name"
							itemValue="id" />
					</div>
				</section>

				<section class="sky-form">
					<h4>
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Country
					</h4>

					<div class="col col-4">
						<form:checkboxes items="${countries}" path="countryIds"
							itemLabel="name" itemValue="id" />
					</div>
				</section>

				<section class="sky-form">
					<h4>
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>Type
					</h4>

					<div class="col col-4">
						<form:checkboxes items="${types}" path="typeIds" itemLabel="name"
							itemValue="id" />
					</div>
				</section>

				<div class="form-group">
					<button type="submit" class="btn btn-success">OK</button>
				</div>

			</form:form>
		</div>
	</div>
	<div class="col-md-12 text-center">

		<custom:pageable page="${product}" cell="<li></li>"
			container="<ul class='pagination pagination-sm'></ul>" />
	</div>
</div>

