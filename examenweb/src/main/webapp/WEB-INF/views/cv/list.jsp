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
	<table>
	<caption><h2>LIST CV</h2></caption>
	<tr>
		<th>ID</th>
		<th>FIRSTNAME</th>
		<th>LASTNAME</th>
		<th>ACTIONS</th>
	</tr>
	<c:forEach items ="${cvs }" var="cv">
		<tr>
			<td>${cv.id}</td>
			<td>${cv.nom }</td>
			<td>${cv.prenom }</td>
			<td>
				<a href="cv?action=delete&id=${cv.id}" style="font-size: 25px;" role="button"><ion-icon name="trash-outline"></ion-icon></a>
				<a href="cv?action=edit&id=${cv.id}" style="font-size: 25px;" role="button"><ion-icon name="create-outline" ></ion-icon></a>
				<a href="cv?action=imprimer&id=${cv.id}" style="font-size: 25px;" role="button"><ion-icon name="print-outline"></ion-icon></a>
				<a href="cv?action=edition&id=${cv.id}" style="font-size: 25px;" role="button"><ion-icon name="clipboard-outline"></ion-icon></a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</html>