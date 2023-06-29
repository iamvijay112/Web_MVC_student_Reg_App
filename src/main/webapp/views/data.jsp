<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Students</title>
</head>
<body>
<a href="/">Add New Students</a>
<h2>Registered Students</h2>
<table border="1">
<thead>
	<tr>
	<th>S.no</th>
	<th>Name</th>
	<th>Email</th>
	<th>Gender</th>
	<th>Courses</th>
	<th>Timings</th>
	</tr>
	</thead>
	<tbody>
			<c:forEach items="${students }" var="student" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.gender}</td>
				<td>${student.course}</td>
				<td>${student.timings}</td>
				
			</tr>
			</c:forEach>
			
	</tbody>
</table>
</body>
</html>