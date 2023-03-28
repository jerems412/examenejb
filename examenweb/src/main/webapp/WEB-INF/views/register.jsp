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
	<br><br>
	<form method="post" action="register" style="width:60%;">
	 	<h2 class="title" style="text-transform: uppercase;">REGISTER</h2>
	    <div class="div">
			<input type="text" name="nom" class="input" placeholder="Enter firstname">
		</div>
		<div class="div">
			<input type="text" name="prenom" class="input" placeholder="Enter lastname">
		</div>
		<div class="div">
			<input type="number" name="age" class="input" placeholder="Enter age">
		</div>
		<div class="div">
			<input type="text" name="adresse" class="input" placeholder="Enter adress">
		</div>
		<div class="div">
			<input type="email" name="email" class="input" placeholder="Enter email">
		</div>
		<div class="div">
			<input type="text" name="telephone" class="input" placeholder="Enter phone number">
		</div>
		<div class="div">
			<input type="text" name="specialite" class="input" placeholder="Enter speciality">
		</div>
		<div class="div">
			<input type="text" name="niveauEtude" class="input" placeholder="Enter level of study">
		</div>	
		<div class="div">
			<input type="text" name="experienceProfessionnelle" class="input" placeholder="Enter professional experience">
		</div>
		<div class="div">
			<input type="password" name="password"placeholder="Enter password">
		</div>
		<div>
			<input type="submit" class="btn" value="Register">
		</div>
		<a href="http://localhost:8080/examenweb/">signin</a>
	</form>
</div>
</body>
</html>