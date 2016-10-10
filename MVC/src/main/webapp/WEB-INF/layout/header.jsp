<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<link href='//fonts.googleapis.com/css?family=Fredoka+One'
	rel='stylesheet' type='text/css'>
<!--coustom css-->
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" />
<!--shop-kart-js-->
<script src="/resources/js/simpleCart.min.js"></script>
<!--default-js-->
<script src="/resources/js/jquery-2.1.4.min.js"></script>




<div class="header">
	<div class="container">
		<div class="header-top">
			<div class="logo">
				<a href="/">SHOP</a>
			</div>

			<div class="login-bars">


				<security:authorize access="isAuthenticated()">

					<form:form action="/logout" method="post"
						class="navbar-form navbar-right">
						<%-- <a>${authUser.login}</a> --%>
						<button type="submit" class="btn btn-default log-bar">Logout
							(${authUser.login})</button>
					</form:form>
					<div class="cart box_1">
						<a href="/cart">
							<h3>
								<div class="total">
									<span class="simpleCart_total"></span>(<span
										id="simpleCart_quantity" class="simpleCart_quantity"></span>)
								</div>
							</h3>
						</a>
						<p>
							<a href="javascript:;" class="simpleCart_empty">Empty Cart</a>
						</p>
						<div class="clearfix"></div>
					</div>
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
					<form:form action="/login" method="get"
						class="navbar-form navbar-right">
						<a class="btn btn-default log-bar" href="registration"
							role="button">Sign up</a>
						<a class="btn btn-default log-bar" href="login" role="button">Login</a>
						<!-- <button type="submit" role="button" class="btn btn-default log-bar">Login</button> -->
					</form:form>

				</security:authorize>

			</div>
			<div class="clearfix"></div>
		</div>



		<!---menu-----bar--->
		<div class="header-botom">
			<div class="content white">
				<nav class="navbar navbar-default nav-menu" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="clearfix"></div>
					<!--/.navbar-header-->

					<div class="collapse navbar-collapse collapse-pdng"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav nav-font">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Shop<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/product">Shoes</a></li>

									<li><a href="/product?genderIds=1&_genderIds=on&_categoryIds=on&_colorIds=on&_countryIds=on&_typeIds=on">Man</a></li>
									<li><a href="/product?genderIds=2&_genderIds=on&_categoryIds=on&_colorIds=on&_countryIds=on&_typeIds=on">Womam</a></li>

								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Men<b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-3">
									<div class="row">
										<div class="col-sm-4 menu-img-pad">
											<ul class="multi-column-dropdown">
												
												<li><a href="product?genderIds=1&_genderIds=on&categoryIds=2&_categoryIds=on&_colorIds=on&_countryIds=on&_typeIds=on">Trainers</a></li>
												
												<c:forEach items="${categories.content}" var="category">
													<li><a href="/product?genderIds=1&_genderIds=on&categoryIds=${category.id}&_categoryIds=on&_colorIds=on&_countryIds=on&_typeIds=on">${category.name}</a></li>
												</c:forEach>
												
											</ul>
										</div>
										<div class="col-sm-4 menu-img-pad">
											<a href="#"><img src="/resources/image/menu1.jpg" alt="/"
												class="img-rsponsive men-img-wid" /></a>
										</div>
										<div class="col-sm-4 menu-img-pad">
											<a href="#"><img src="/resources/image/menu2.jpg" alt="/"
												class="img-rsponsive men-img-wid" /></a>
										</div>
									</div>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Women<b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-2">
									<div class="row">
										<div class="col-sm-6">
											<ul class="multi-column-dropdown">
												<li><a href="/product?genderIds=2&_genderIds=on&categoryIds=2&_categoryIds=on&_colorIds=on&_countryIds=on&_typeIds=on">Trainers</a></li>
												<li><a href="/product?genderIds=2&_genderIds=on&categoryIds=4&_categoryIds=on&_colorIds=on&_countryIds=on&_typeIds=on">Sneakers</a></li>
												<li><a href="/">Formal shoes</a></li>
												<li class="divider"></li>
												<li><a href="/">Sports</a></li>
												<li class="divider"></li>
												<li><a href="/">Gym</a></li>
											</ul>
										</div>
										<div class="col-sm-6">
											<a href="#"><img src="/resources/image/menu3.jpg" alt="/"
												class="img-rsponsive men-img-wid" /></a>
										</div>
									</div>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">kids<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="/">Tees</a></li>
									<li><a href="/">Shorts</a></li>
									<li><a href="/">Gear</a></li>
									<li class="divider"></li>
									<li><a href="/">Watches</a></li>
									<li class="divider"></li>
									<li><a href="/">Shoes</a></li>
								</ul></li>
							<li><a href="/contact">Catch</a></li>
							<div class="clearfix"></div>
						</ul>
						<div class="clearfix"></div>
					</div>
					<!--/.navbar-collapse-->
					<div class="clearfix"></div>
				</nav>
				<!--/.navbar-->
				<div class="clearfix"></div>
			</div>
			<!--/.content--->
		</div>
		<!--header-bottom-->
	</div>
</div>









<%-- <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"><img class="img-thumbnail" width="80" src="/resources/image/grid11.jpg?version=1" /></a>
    </div>
    <ul class="nav navbar-nav">
<!--       	<li><a>Home</a></li> -->
<!--       	<li><a>Page 1</a></li> -->
<!--       	<li><a>Page 2</a></li> -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<li><a>${authUser.login}</a></li>
    <security:authorize access="isAuthenticated()">
			<li>
				<form:form action="/logout" method="post"
					class="navbar-form navbar-right">
					<button type="submit" class="btn btn-default">Logout</button>
				</form:form>
			</li>
		</security:authorize>
		<security:authorize access="!isAuthenticated()">
			<li>
				<form:form action="/login" method="get"
					class="navbar-form navbar-right">
					<button type="submit" class="btn btn-default">Login</button>
				</form:form>
			</li>
	</security:authorize>
    </ul>
  </div>
</nav> --%>


