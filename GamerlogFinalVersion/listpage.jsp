<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="css/homepagestyle.css" rel="stylesheet" type="text/css"> 

<title>Gamerlog - Browse Games</title>
</head>
<body>

	<div class="topnav" id="myTopnav">

		<a href="homepageServlet?id=<c:out value='${loggedID}' />"
			class="active">GAMERLOG</a>

		<div class="signoutbtn">
			<a href="#about">${loggedUsername}</a>
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
		<h1>${loggedUsername}'s ${listnamespaces} List</h1>
		<h2>${gamesNum} games in this list</h2>
		<table border="1" cellpadding="5">
			<c:forEach var="game" items="${listGame}">
				
				<tr>
					<td> 
						<img src="<c:out value="${game.image}" />">
					</td>
					<td class="titlecell"><p class="title">
						<c:out value="${game.title}" /></p>
						<br>
						<c:out value="${game.yearReleased}" />
					</td>
					<td>
						<p class ="header">Developers</p><c:out value="${game.developers}" />
						<p class ="header">Publishers</p><c:out value="${game.publishers}" />
						<p class ="header">Genres</p><c:out value="${game.genres}" />
					</td>
					<td>
						<a href="deletelistentry?user=<c:out value='${loggedID}' />&game=<c:out value='${game.id}' />&listname=<c:out value='${listname}' />">Remove</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
