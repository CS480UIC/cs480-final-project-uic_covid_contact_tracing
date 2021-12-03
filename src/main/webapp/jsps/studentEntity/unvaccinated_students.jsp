<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Unvaccinated Students </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>uin</th>
		<th>vaccination_status</th>
		<th>first_name</th>
		<th>last_name</th>
		<th>student_living_status</th>
		<th>student_major_name</th>
		<th>dorm_id</th>
	</tr>
<c:forEach items="${StudentList}" var="student">
	<tr>
		<td>${student.uin}</td>
		<td>${student.vaccination_status}</td>
		<td>${student.first_name}</td>
		<td>${student.last_name}</td>
		<td>${student.student_living}</td>
		<td>${student.student_major_name}</td>
		<td>${student.dorm_id}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
