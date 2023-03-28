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
	<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
	<br><br>
	<form method="post" action="cv?action=edit&id=${cv.id }" style="width:60%;">
	 	<h2 class="title" style="text-transform: uppercase;">EDIT CV</h2>
	    <div class="div">
			<input type="text" name="nom" class="input" placeholder="Enter firstname" value="${cv.nom }">
		</div>
		<div class="div">
			<input type="text" name="prenom" class="input" placeholder="Enter lastname" value="${cv.prenom }">
		</div>
		<div class="div">
			<input type="number" name="age" class="input" placeholder="Enter age" value="${cv.age }">
		</div>
		<div class="div">
			<input type="text" name="adresse" class="input" placeholder="Enter adress" value="${cv.adresse }">
		</div>
		<div class="div">
			<input type="text" name="telephone" class="input" placeholder="Enter phone number" value="${cv.telephone }">
		</div>
		<div class="div">
			<input type="text" name="specialite" class="input" placeholder="Enter speciality" value="${cv.specialite }">
		</div>
		<div class="div">
			<input type="text" name="niveauEtude" class="input" placeholder="Enter level of study" value="${cv.niveauEtude }">
		</div>	
		<div class="div">
			<input type="text" name="experienceProfessionnelle" class="input" placeholder="Enter professional experience" value="${cv.experienceProfessionnelle }">
		</div>
		<div>
			<input type="submit" class="btn" value="Edit">
		</div>
	</form>
</body>
</html>