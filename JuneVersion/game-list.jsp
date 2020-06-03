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
	.topnav a:not
	 (:first-child ) {
		display: none;
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
			<a href="http://localhost:8080/gamerlog_project/homepage.jsp">MY PROFILE</a>
			<a href="#news">BROWSE GAMES</a>
			<a href="#about">ABOUT</a>
			<a href="http://localhost:8080/gamerlog_project/login.jsp">SIGN OUT</a>
		</div>
		<a href="javascript:void(0);" class="icon" onclick="myFunction()">
			<i class="fa fa-bars"></i>
		</a>
	</div>

	<center>
		<h1>Game Management</h1>
		<h2>
			<a href="newgame">Add New Game</a> &nbsp;&nbsp;&nbsp; <a
				href="listgames">List All Games</a>

		</h2>
	</center>
	<div align="center">
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
				<th>Image Path</th>

				<th>Actions</th>
			</tr>
			<c:forEach var="game" items="${listGame}">
				<tr>
					<td><c:out value="${game.id}" /></td>
					<td><c:out value="${game.title}" /></td>
					<td><c:out value="${game.yearReleased}" /></td>
					<td><c:out value="${game.developers}" /></td>
					<td><c:out value="${game.publishers}" /></td>
					<td><img src="<c:out value="${game.image}" />"></td>

					<td><a href="editgame?id=<c:out value='${game.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deletegame?id=<c:out value='${game.id}' />">Delete</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deletegame?id=<c:out value='${game.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
