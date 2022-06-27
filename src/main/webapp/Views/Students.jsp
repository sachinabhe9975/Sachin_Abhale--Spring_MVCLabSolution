<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page </title>
</head>
<body>
<h1 align="center"  >Welcome To 2022 Debate Event</h1>
<form>
	<table align="center" >
		<tr>
		
			<td ><a href="addStudent?id=-1"><input type="button" value="Register New Student"  /> </a>
			
			
			</td>
	</table>
</form>

	<form action="search" method="post">

		<table align="center" weight="70%" height="70%">

			<tr>
				
				<td><input type="text" name="student_department"
					placeholder="Search by department.." /></td>
						<td colspan="2"><input type="submit"  value="search"/></td>
					
			
			   </tr>
		
			

		</table>
	</form>

	${error}

	<table border="1" align="center" bgcolor="#E8FDFF" weight="70%"
		height="70%">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Student Department</th>
			<th>Student Country</th>
			<th>Action</th>
		</tr>


		<c:forEach items="${student}" var="b">
			<tr>
				<td>${b.student_id}</td>
				<td>${b.first_name}</td>
				<td>${b.last_name}</td>
				<td>${b.student_department }</td>
				<td>${b.student_country }</td>
				
				<td><a href="addStudent?id=${b.student_id}">Update |</a><a
					href="deleteStudent?id=${b.student_id}"> Delete</a></td>
				
			</tr>

		</c:forEach>
	</table>
</body>
</html>
