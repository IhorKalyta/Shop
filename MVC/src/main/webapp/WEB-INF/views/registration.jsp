<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="head-bread">
            <div class="container">
                <ol class="breadcrumb">
                    <li><a href="/">Home</a></li>
                    <li><a href="/login">LOGIN</a></li>
                    <li class="active">REGISTER</li>
                </ol>
            </div>
        </div>
        
<div class="reg-form">
		<div class="container">
			<div class="reg">
				<h3>Register Now</h3>
				<p>Welcome, please enter the following details to continue.</p>
				
				 <form:form action="/registration" class="form-group" method="post" modelAttribute="user">
					
					<ul>
						<li class="text-info">Login: </li>
						<li><input name="login" type="text" class="form-control" /></li>
						
					</ul>
					<h4><label for="login"><form:errors path="login" /></label></h4>
					<ul>
						<li class="text-info">E-mail: </li>
						<li><input name="mail" type="text" class="form-control" /></li>
					</ul>
					<h4><label for="mail"><form:errors path="mail" /></label></h4>
					<ul>
						<li class="text-info">Password: </li>
						<li><input name="password" type="password" class="form-control" /></li>
					</ul>
					<ul><li><h4><label for="password"><form:errors path="password" /></label></h4></li>	</ul>
					
					<input type="submit" value="Register Now">
					<p class="click">By clicking this button, you are agree to my  <a href="#">Policy Terms and Conditions.</a></p> 
				</form:form>
			</div>
		</div>
	</div>

<%-- <div class="container">
	<div class="row">
	<c:if test="${param.fail}">
		<div class="col-md-12 col-xs-12">
			<p style="color: red;">Fail</p>
		</div>
	</c:if>
		<form:form action="/registration" class="form-group" method="post" modelAttribute="user">
				<div class="form-group">
					<input name="login" placeholder="Login" class="form-control" />
					<input name="mail" placeholder="E-mail" class="form-control" />
					<input name="password" type="password" placeholder="Some like ***" class="form-control" />
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
		</form:form>
	</div>
</div> --%>