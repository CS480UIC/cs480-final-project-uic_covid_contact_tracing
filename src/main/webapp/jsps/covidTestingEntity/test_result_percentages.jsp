<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">  </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>test_result</th>
		<th>percentage</th>
	</tr>
<c:forEach items="${StudentList}" var="student">
	<tr>
		<td>${student.test_result}</td>
		<td>${student.percentage}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
