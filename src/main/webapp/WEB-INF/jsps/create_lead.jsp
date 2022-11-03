<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
	<h2>Create New Lead</h2>
	<form action="saveLead" method="post">
		<table>
			<tr>
				<td>FirstName<input type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>LastName<input type="text" name="lastname"></td>
			</tr>
			<tr>
				<td>Email<input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Mobile<input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td><input type="submit" name="save"></td>
			</tr>
		</table>
	</form>
	${msg} 
</body>
</html>