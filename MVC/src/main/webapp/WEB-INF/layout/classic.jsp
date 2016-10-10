<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Fredoka+One'
	rel='stylesheet' type='text/css'>

<!--fonts-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/style.css" />
<link rel="stylesheet" href="/resources/css/chosen.css">
<script type="text/javascript" src="/resources/js/chosen.jquery.min.js"></script>
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<tiles:insertAttribute name="header" />

	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>

	<tiles:insertAttribute name="footer" />

</body>
</html>