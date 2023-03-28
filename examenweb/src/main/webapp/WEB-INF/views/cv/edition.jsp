<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
<link rel="stylesheet" href="style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Examen Ejb</title>
</head>
<style>

	.main {
		background-color: white;
		height: auto;
		width: 650px;
		position: absolute;
		transform: translate(-50%, -50%);
		left: 50%;
		top: 70%;
	}

	.left {
		background-color: #fbb03b;
		width: 200px;
		height: 115vh;
		float: left;
	}

	.right {
		width: 450px;
		float: left;
	}

	.profile-img {
		height: 180px;
		width: 180px;
		background-color: #ddd;
		border-radius: 50%;
		margin-bottom: 20px;
		margin-left: 60px;
		border: 10px solid #fbb03b;
		box-shadow: 6px 7px 9px 5px #fbb03b73;
	}

	.profile-img img {
		width: 100%;
		border-radius: 50%;
	}

	.box-1 {
		position: relative;
	}

	.heading {
		background-color: #4d4d4d;
		padding: 10px;
		color: #fbb03b;
		text-align: left;
		padding-left: 20px;
		margin-right: -15px;
	}

	.heading::after {
		content: "";
		position: absolute;
		width: 21px;
		height: 18px;
		background-color: #5a5959;
		left: 191px;
		top: 26px;
		transform: rotate(56deg);
		z-index: -1;
	}

	.p1 {
		padding: 9px 10px;
		font-size: 11px;
	}

	.icons1 {
		font-size: 16px !important;
		padding-right: 10px !important;
		vertical-align: sub;
	}

	.skill-container {
		width: 90%;
		background-color: #4d4d4d;
		margin: 0px 10px;
	}

	.skill {
		text-align: right;
		padding-top: 2px;
		padding-bottom: 2px;
		color: white;
	}

	.html {
		width: 90%;
		background-color: white;
	}

	.css {
		width: 80%;
		background-color: white;
	}

	.js {
		width: 85%;
		background-color: white;
	}

	.jquery {
		width: 80%;
		background-color: white;
	}

	.web {
		width: 85%;
		background-color: white;
	}

	.gra {
		width: 70%;
		background-color: white;
	}

	.icons2 {
		padding: 18px 10px;
	}

	.name-div {
		padding: 86px 0px 60px 55px;
		text-align: center;
		letter-spacing: 3px;
	}

	.name-div h1 {
		margin-bottom: 10px;
	}

	.box-2 {
		padding: 0px 50px;
		margin-top: 30px;
	}

	.p2 {
		font-size: 15px;
		font-weight: 300;
		letter-spacing: 1px;
		word-spacing: 2px;
		line-height: 18px;
		margin-top: 5px;
	}

	h2 {
		font-size: 16px;
		margin-bottom: 15px;
	}

	.icons3 {
		vertical-align: bottom;
		font-size: 21px !important;
		color: #4d4d4d;
	}

	.p3 {
		font-size: 13px;
		word-spacing: 1px;
		letter-spacing: 0px;
		margin-top: 10px;
	}

	.p3 span {
		color: #ff9b00;
		padding-left: 20px;
	}
</style>
<body>
	<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
	<br><br><br>
	<div class="main">
		<div class="left">
			<br>
			<div class="profile-img"></div>

			<div class="box-1">
				<div class="heading">
					<p>CONTACT</p>
				</div>
				<p class="p1"><i class="material-icons icons1">call</i>${cvs.telephone }</p>
				<p class="p1"><i class="material-icons icons1">email</i>${cvs.email }</p>
				<p class="p1"><i class="material-icons icons1">perm_identity</i>${cvs.age } years old</p>
				<p class="p1"><i class="material-icons icons1">perm_identity</i>${cvs.adresse }</p>
			</div>
			<br>

			<div class="box-1">
				<div class="heading">
					<p>HOBBIES</p>
				</div>

				<div class="h-div">
					<i class="material-icons icons2">camera_roll</i>
					<i class="material-icons icons2">music_note</i>
					<i class="material-icons icons2">motorcycle</i>
					<i class="material-icons icons2">border_color</i>
				</div>

			</div>

		</div>


		<div class="right">
			<div class="name-div">
				<h1 style="text-transform: uppercase;">${cvs.nom } ${cvs.prenom }</h1>
				<p>${cvs.specialite }</p>
			</div>
			<div class="box-2">
				<h2>ABOUT ME <i class="material-icons icons3" style="font-size: 28px!important; ">perm_identity</i></h2>
				<p class="p2">

				</p>
			</div>
			<div class="box-2">
				<h2>EDUCATION <i class="material-icons icons3">border_color</i></h2>
				<p class="p2">
					${cvs.niveauEtude }
				</p>
			</div>
			<div class="box-2">
				<h2>WORK EXPERIENCE <i class="material-icons icons3">folder</i></h2>
				<p class="p2">
					${cvs.experienceProfessionnelle }
				</p>
			</div>

		</div>
	</div>
</body>
</html>