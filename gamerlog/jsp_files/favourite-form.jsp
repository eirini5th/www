<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gamerlog - Browse Games</title>
</head>
<body>
	<center>
		<h1>Faves Management</h1>
		<h2>
			<a href="http://localhost:8080/gamerlog_project/newfavourite">Add New Fave</a>
			&nbsp;&nbsp;&nbsp;
			<a href="http://localhost:8080/gamerlog_project/listfavourites">Add New Fave</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${game != null}">
			<form action="updatefavourite" method="post">
		</c:if>
		<c:if test="${game == null}">
			<form action="insertfavourite" method="post">
		</c:if>
		
		<table border="1" cellpadding="5">
		
			<caption>
				<h2>
					<c:if test="${favourite != null}">
            			Edit Favourite
            		</c:if>
					<c:if test="${favourite == null}">
            			Add New Favourite
            		</c:if>
				</h2>
			</caption>
		
			<c:if test="${favourite != null}">
				<input type="hidden" name="id" value="<c:out value='${favourite.id}' />" />
			</c:if>
		
		
			<tr>
				<th>userID:</th>
				<td><input type="text" name="userID" size="45"
					value="<c:out value='${favourite.userID}' />" /></td>
			</tr>
			<tr>
				<th>gameID:</th>
				<td><input type="text" name="gameID" size="45"
					value="<c:out value='${favourite.gameID}' />" /></td>
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
