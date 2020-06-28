<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

.topnav .icon {
	display: none;
}

@media screen and (max-width: 600px) {
	.topnav a:not (:first-child)
	{
		display:none;	
	}

	.topnav a.icon {
		float: right;
		display: block;
	}
}

@media screen and (max-width: 600px) {
	.topnav.responsive {
		position: relative;
	}
	.topnav.responsive .icon {
		position: absolute;
		right: 0;
		top: 0;
	}
	.topnav.responsive a {
		float: none;
		display: block;
		text-align: left;
	}
}

.signoutbtn {
	float: right;
	display: block;
}
</style>
<title>Gamerlog - Browse Games</title>
</head>
<body>

	<div class="topnav" id="myTopnav">

		<a href="http://localhost:8080/gamerlog_project/homepage.jsp"
			class="active">GAMERLOG</a>

		<div class="signoutbtn">
			<a href="#about">${loggedUsername}</a>
<!-- 		<a href="homepageServlet">BROWSE</a>											 -->
			<a href="homepageServlet?id=<c:out value='${loggedID}' />"> BROWSE</a>
			<a href="displayuserlist?id=<c:out value='${loggedID}' />&listname=favourites">Favourites</a>
			<a href="displayuserlist?id=<c:out value='${loggedID}' />&listname=wanttoplay">Want To Play</a>
			<a href="displayuserlist?id=<c:out value='${loggedID}' />&listname=currplaying">Currently Playing</a>
			<a href="displayuserlist?id=<c:out value='${loggedID}' />&listname=hasplayed">Has Played</a>
			<a href="http://localhost:8080/gamerlog_project/login.jsp">SIGN OUT</a>
		</div>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
			<i class="fa fa-bars"></i>
		</a>
	</div>
	<h2></h2>
	<div align="center">
		<h1>Welcome ${loggedUsername}!</h1>
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Games</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Year Released</th>
				<th>Developers</th>
				<th>Publishers</th>
				<th>Genres</th>
				<th>Image Path</th>

				<th>Add to</th>
			</tr>
			<c:forEach var="game" items="${listGame}">
				<tr>
					<td><c:out value="${game.id}" /></td>
					<td><c:out value="${game.title}" /></td>
					<td><c:out value="${game.yearReleased}" /></td>
					<td><c:out value="${game.developers}" /></td>
					<td><c:out value="${game.publishers}" /></td>
					<td><c:out value="${game.genres}" /></td>
					<td><img src="<c:out value="${game.image}" />"></td>

					<td><a href="newlistentry?user=<c:out value='${loggedID}' />&game=<c:out value='${game.id}' />&listname=favourites">Favourites</a>
						<br>
						<a href="newlistentry?user=<c:out value='${loggedID}' />&game=<c:out value='${game.id}' />&listname=wanttoplay">Want to Play</a>
						<br>
						<a href="newlistentry?user=<c:out value='${loggedID}' />&game=<c:out value='${game.id}' />&listname=currplaying">Currently Playing</a>
						<br>
						<a href="newlistentry?user=<c:out value='${loggedID}' />&game=<c:out value='${game.id}' />&listname=hasplayed">Has Played</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
