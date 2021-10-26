<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: red; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">uic_covid_contact_tracing</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/person_entity.jsp'/>" target="_parent">Person</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/student_entity.jsp'/>" target="_parent">Student</a> |&nbsp;
			<a href="<c:url value='/jsps/user/employee_entity.jsp'/>" target="_parent">Employee</a> |&nbsp;
			<a href="<c:url value='/jsps/user/course_entity.jsp'/>" target="_parent">Course</a> |&nbsp;
			<a href="<c:url value='/jsps/user/organization_entity.jsp'/>" target="_parent">Organization</a> |&nbsp;
			<a href="<c:url value='/jsps/user/studentHousing_entity.jsp'/>" target="_parent">Student_housing</a> |&nbsp;
			<a href="<c:url value='/jsps/user/contactInfo_entity.jsp'/>" target="_parent">Contact_information</a> |&nbsp;
			
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

