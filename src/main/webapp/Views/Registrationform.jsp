<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> College Fest Management</h1>
<form action="save" method="post">
<table>
<tr>
<td> First Name</td><td><input type="text" value="${student.first_name}" name="first_name" required/> </td></tr>
<tr>
<td> Last Name </td><td><input type="text" value="${student.last_name}" name="last_name" required /> </td>
</tr>
<tr>
<td> Department</td><td><input type="text" value="${student.student_department}" name="student_department" required /> </td>
</tr>
<tr>
<tr>
<td>  Country</td><td><input type="text" value="${student.student_country}" name="student_country" required /> </td>
</tr>
<tr>
<td colspan="2"><input type="hidden" value='${student.student_id}' name="student_id"/><input type="submit"/></td></tr>
</table>

</form>
</body>
</html>
