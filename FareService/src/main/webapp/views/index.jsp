<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	Hello!! Welcome Ravi !!
	
	<br><h2>Please Click below for all Aliens in database</h2>
	<form action="getAliens">
		<input type="submit" value="Show All Aliens">
	</form>
	
	<h2>Please enter details to add alien in database</h2>
	<form action="addAlien" method="post">
		Enter your ID : <input type="text" name="aid"><br><br>
		Enter your Name : <input type="text" name="aname"><br><br>
		<input type="submit">
	</form>
	
	<h2>Please Enter the ID of the Alien to find in the database</h2>
	<form action="getAlien">
		Enter the ID : <input type="text" name="aid"><br><br>
		<input type="submit">
	</form>
	
	<h2>Please Enter the ID of the Alien to remove in the database</h2>
	<form action="removeAlien">
		Enter the ID : <input type="text" name="aid"><br><br>
		<input type="submit">
	</form>
</body>
</html>