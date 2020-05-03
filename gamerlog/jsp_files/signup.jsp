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
	<div class="container">
		<h1>GAMERLOG</h1>

		<h2>Find your next favourite games and keep track of what you are
			playing</h2>

		<hr>
		<div class="row col-md-10 col-md-offset-3">
			<a></a>
			<div class="card card-body">

				<h2>Sign up</h2>
				<div class="col-md-8 col-md-offset-3">

					<form action="<%=request.getContextPath()%>/signup" method="post">

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
					<h4>Already a member?</h4>
					<form action="http://localhost:8080/gamerlog/login.jsp">
						<input type="submit" class="btn btn-primary" value="Login" />
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>