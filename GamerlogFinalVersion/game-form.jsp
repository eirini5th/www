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
	.topnav a:not (:first-child ) {
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
</style>
<title>Gamerlog - Browse Games</title>
</head>
<body>

	<div class="topnav" id="myTopnav">
		<a href="#home" class="active">Home</a> <a href="#news">News</a> <a
			href="#contact">Contact</a> <a href="#about">About</a> <a
			href="javascript:void(0);" class="icon" onclick="myFunction()"> <i
			class="fa fa-bars"></i>
		</a>
	</div>

	<div style="padding-left: 16px">
		<h2>Responsive Topnav Example</h2>
		<p>Resize the browser window to see how it works.</p>
	</div>

	<center>
		<h1>Game Management</h1>
		<h2>
			<a href="newgame">Add New Game</a>
			&nbsp;&nbsp;&nbsp;
			<a href="listgames">List All Games</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${game != null}">
			<form action="updategame" method="post">
		</c:if>
		<c:if test="${game == null}">
			<form action="insertgame" method="post">
		</c:if>
		
		<table border="1" cellpadding="5">
		
			<caption>
				<h2>
					<c:if test="${game != null}">
            			Edit Game
            		</c:if>
					<c:if test="${game == null}">
            			Add New Game
            		</c:if>
				</h2>
			</caption>
		
<!-- 			<c:if test="${game != null}">
				<input type="hidden" name="id" value="<c:out value='${game.id}' />" />
			</c:if>
	 -->	
			
			<tr>
				<th>id:</th>
				<td><input type="text" name="id" size="45"
					value="<c:out value='${game.id}' />" /></td>
			</tr>	
			<tr>
				<th>Game Title:</th>
				<td><input type="text" name="title" size="45"
					value="<c:out value='${game.title}' />" /></td>
			</tr>
			<tr>
				<th>Year Released:</th>
				<td><input type="text" name="yearReleased" size="45"
					value="<c:out value='${game.yearReleased}' />" /></td>
			</tr>
			<tr>
				<th>Developers</th>
				<td><input type="text" name="developers" size="45"
					value="<c:out value='${game.developers}' />" /></td>
			</tr>
			<tr>
				<th>Publishers:</th>
				<td><input type="text" name="publishers" size="45"
					value="<c:out value='${game.publishers}' />" /></td>
			</tr>
			<tr>
				<th>Genres:</th>
				<td><input type="text" name="genres" size="45"
					value="<c:out value='${game.genres}' />" /></td>
			</tr>
			<tr>
				<th>Image Path</th>
				<td><input type="text" name="image" size="45"
					value="<c:out value='${game.image}' />" /></td>
			</tr>			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
			
			
		</table>
		</form>
	</div>
</body>
</html>
