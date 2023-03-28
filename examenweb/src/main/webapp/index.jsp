<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<link rel="stylesheet" href="style.css">
<title>Examen Ejb</title>
</head>
<body>
<div class="container">
	<br><br><br><br>
	<form method="post" action="login" style="width:60%;">
	 	<h2 class="title" style="text-transform: uppercase;">SIGN IN</h2>
	    <div class="div">
			<input type="text" name="email" class="input" placeholder="Enter email">
		</div>
		<div class="div">
			<input type="password" name="password"placeholder="Enter password">
		</div>
		<div>
			<input type="submit" class="btn" value="Sign In">
		</div>
		<a href="register">register</a>
		<c:if test = "${msg_error}">
		<p style="color:red;">
			${ msg_error }
		</p>
	</c:if>
	</form>
</div>
</body>
</html>