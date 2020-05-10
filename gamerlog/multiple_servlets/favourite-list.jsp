<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Gamerlog - Browse Favourites</title>
</head>
<body>
	<center>
		<h1>Favourite Management</h1>
        <h2>
			<a href="http://localhost:8080/gamerlog_project/newfavourite">Add New Fave</a>
        	&nbsp;&nbsp;&nbsp;
			<a href="http://localhost:8080/gamerlog_project/listfavourites">Add New Fave</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Favourites</h2></caption>
            <tr>
                <th>ID</th>
                <th>userID</th>
                <th>gameID</th>

                
                <th>Actions</th>
            </tr>
            <c:forEach var="favourite" items="${listFavourite}">
                <tr>
                    <td><c:out value="${favourite.id}" /></td>
                    <td><c:out value="${favourite.userID}" /></td>
                    <td><c:out value="${favourite.gameID}" /></td>
                    
                    <td>
                    	<a href="editfavourite?id=<c:out value='${favourite.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletefavourite?id=<c:out value='${favourite.id}' />">Delete</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletefavourite?id=<c:out value='${favourite.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
