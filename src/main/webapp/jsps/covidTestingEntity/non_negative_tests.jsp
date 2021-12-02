<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Covid Tests - Not Negative </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>uin</th>
		<th>test_date</th>
		<th>result_date</th>
		<th>test_result</th>

	</tr>
<c:forEach items="${StudentList}" var="student">
	<tr>
		<td>${student.uin}</td>
		<td>${student.test_date}</td>
		<td>${student.result_date}</td>
		<td>${student.test_result}</td>

	</tr>
</c:forEach>
</table>
</body>
</html>
