<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gamerlog - Browse Games</title>
</head>
<body>
	<center>
		<h1>Game Management</h1>
		<h2>
			<a href="newgame">Add New Game</a>
			&nbsp;&nbsp;&nbsp;
			<a href="listgame">List All Games</a>

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
		
			<c:if test="${game != null}">
				<input type="hidden" name="id" value="<c:out value='${game.id}' />" />
			</c:if>
		
		
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
