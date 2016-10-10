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
						<li class="active"><a href="/admin/user">Users</a><span
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
	
		<form:form action="/admin/user" class="form-inline" method="get"
			modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search" />
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<label></label>
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	
</div>

<div class="col-md-7 col-xs-12">
<%-- <div class="row">
			<div class="col-md-2 col-xs-2"><h4>login</h4></div>
			<div class="col-md-2 col-xs-2"><h4>e-mail</h4></div>
			<div class="col-md-2 col-xs-2"><h4>role</h4></div>
			
		</div>
			<c:forEach items="${users.content}" var="user">
			<div class="row">
				<div class="col-md-2 col-xs-2">${user.login}</div>
				<div class="col-md-2 col-xs-2">${user.mail}</div>
				<div class="col-md-2 col-xs-2">${user.role}</div>
				
				
				
			</div>
			</c:forEach>
			<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${users}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div> --%>
	
	
	
	<table class="table table-striped">
    <thead>
      <tr>
      	<th><h4>Login</h4></th>
        <th><h4>E-mail</h4></th>
        <th><h4>Role</h4></th>
      </tr>
    </thead>
    <c:forEach items="${users.content}" var="user">
    <tbody>
      <tr>
        <td>${user.login}</td>
        <td>${user.mail}</td>
        <td>${user.role}</td>
      </tr>      
    </tbody>
    </c:forEach>
  </table>
  

	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${users}" cell="<li></li>"
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
				<custom:sort innerHtml="Login asc" paramValue="login" />
				<custom:sort innerHtml="Login desc" paramValue="login,desc" />
			</ul>
		</div>
	</div>
	<div class="col-md-6 col-xs-6 text-center">
		<custom:size posibleSizes="1,2,5,10"  size="${users.size}"
			title="Page size" />
	</div>
</div>
</div>