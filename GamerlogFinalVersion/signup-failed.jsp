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
<style>
body {
	margin: 0;
	font-family: Microsoft Sans Serif;
	background-color: #4d4d4d;
	color: #d9d9d9;
}

h1 {
	margin-top: 60px;
	color: #4CAF50;
	text-align:center;
}

h2 {
	text-align:center;
}

h3 { color: tomato; }
</style>
<body>
		<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
			<form action="<%=request.getContextPath()%>/signup" method="post">

				<h1>GAMERLOG</h1>

				<h2>Find your next favourite games and keep track of what you are playing</h2>
				<h3>This username already exists: please try again</h3>

				<div class="form-group">
					<input type="text"
						class="form-control" id="username" placeholder="Username"
						name="username" required>
				</div>

				<div class="form-group">
					<input type="password"
						class="form-control" id="password" placeholder="Password"
						name="password" required>
				</div>

				<button type="submit" class="btn btn-primary" >Submit</button>

			</form>
			<h4>Already a member?</h4>
			<form action="login.jsp">
				<input type="submit" class="btn btn-primary" value="Login" />
			</form>


		</div>
</body>
</html>