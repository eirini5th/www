<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gamerlog: Your online log for video games</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<form action="<%=request.getContextPath()%>/login" method="post">


			<h1>GAMERLOG</h1>

			<h2>Find your next favourite games and keep track of what you
				are playing</h2>

			<h3>Login</h3>


			<div class="form-group">
				<label for="uname">Username:</label> <input type="text"
					class="form-control" id="username" placeholder="Username"
					name="username" required>
			</div>

			<div class="form-group">
				<label for="uname">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password" required>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

		<h4>Are you new?</h4>
		<form action="http://localhost:8080/gamerlog/signup.jsp">
			<input type="submit" class="btn btn-primary" value="Sign up" />
		</form>



	</div>
</body>
</html>