<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="head-bread">
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="/">HOME</a></li>
			<li class="active">LOGIN</li>
		</ol>
	</div>
</div>


<!-- login-page -->
<div class="login">
	<div class="container">
		<div class="login-grids">
			<div class="col-md-6 log">

				<h3>Login</h3>
				<div class="strip"></div>
				<p>Welcome, please enter the following to continue.</p>
				<p>
					If you have previously Login with us, <a href="#">Click Here</a>
				</p>
				<form:form action="/login" class="form-inline" method="post">
					<c:if test="${param.fail}">
						<div class="col-md-12 col-xs-12">
							<p style="color: red;">Fail</p>
						</div>
					</c:if>
					<h5>User Name:</h5>
					<input name="username" type="text" class="form-control" />
					<br>
					<h5>Password:</h5>
					<input name="password" type="password" class="form-control" />
					<br>
					<input type="submit" value="Login">

				</form:form>
				<a href="#">Forgot Password ?</a>
			</div>
			<div class="col-md-6 login-right">
				<h3>New Registration</h3>
				<div class="strip"></div>
				<p>By creating an account with our store, you will be able to
					move through the checkout process faster, store multiple shipping
					addresses, view and track your orders in your account and more.</p>
				<a href="/registration" class="button">Create An Account</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- //login-page -->

<%-- <div class="container">
	<div class="row">
		<c:if test="${param.fail}">
			<div class="col-md-12 col-xs-12">
				<p style="color: red;">Fail</p>
			</div>
		</c:if>
		<c:if test="${param.expired}">
			<div class="col-md-12 col-xs-12">
				<p style="color: red;">Session expired</p>
			</div>
		</c:if>
		<form:form action="/login" class="form-inline" method="post">
			<div class="form-group">
				<input name="username" placeholder="Login" class="form-control" />
				<input name="password" type="password" placeholder="********"
					class="form-control" />
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	</div>
</div> --%>