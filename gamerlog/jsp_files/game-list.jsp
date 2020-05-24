<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        	<a href="listgames">List All Games</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Games</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Year Released</th>
                <th>Developers</th>
                <th>Publishers</th>
                <th>Genres</th>
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
				    <td><c:out value="${game.genres}" /></td>
                    <td><img src="<c:out value="${game.image}" />" ></td>
                    
                    <td>
                    	<a href="editgame?id=<c:out value='${game.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletegame?id=<c:out value='${game.id}' />">Delete</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletegame?id=<c:out value='${game.id}' />">Delete</a>                     	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
