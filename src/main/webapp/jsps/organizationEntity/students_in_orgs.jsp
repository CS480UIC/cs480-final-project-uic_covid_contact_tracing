<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Students in Organizations (2+ members) </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>uin</th>
		<th>organization_id</th>
		<th>organization_name</th>

	</tr>
<c:forEach items="${StudentList}" var="student">
	<tr>
		<td>${student.uin}</td>
		<td>${student.organization_id}</td>
		<td>${student.organization_name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
