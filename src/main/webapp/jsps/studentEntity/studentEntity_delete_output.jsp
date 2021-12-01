<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete Entity</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form action="<c:url value='/StudentServletDelete'/>" method="post">
		<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="uin" value="${student.uin }"/>
		
		UIN: <input type="text" name="uin" value="${student.uin }" disabled/>
		<br/>
		Vaccination Status：<input type="text" name="vaccination_status" value="${student.vaccination_status }" disabled/>
		<br/>
		First Name	：<input type="text" name="first_name" value="${student.first_name }" disabled/>
		<br/>
		Last Name	：<input type="text" name="last_name" value="${student.last_name }" disabled/>
		<br/>
		Major	：<input type="text" name="student_major_name" value="${student.student_major_name }" disabled/>
		<br/>
		Dorm	：<input type="text" name="dorm_id" value="${student.dorm_id }" disabled/>
		<br/>
		<input type="submit" value="Delete Student"/>
	</form>

</body>
</html>
