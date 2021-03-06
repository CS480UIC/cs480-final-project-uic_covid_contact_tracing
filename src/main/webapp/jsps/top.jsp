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
			<a href="<c:url value='/jsps/initialize/init.jsp'/>" target="body">Initialize Database</a> |&nbsp;&nbsp;	
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<%-- <a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;  --%>
			<!-- <br> -->
			<a href="<c:url value='/jsps/studentEntity/menu.jsp'/>" target="body">CRUD operations for Students</a> |&nbsp;&nbsp;
			<!-- <br> -->
			<a href="<c:url value='/jsps/organizationEntity/menu.jsp'/>" target="body">CRUD operations for Organizations</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/courseEntity/menu.jsp'/>" target="body">CRUD operations for Courses</a> |&nbsp;&nbsp;
			<br>
			<a href="<c:url value='/jsps/contactInformationEntity/menu.jsp'/>" target="body">CRUD operations for Contact Information</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/covidTestingEntity/menu.jsp'/>" target="body">CRUD operations for Covid Tests</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentHousingEntity/menu.jsp'/>" target="body">CRUD operations for Student Housings</a> |&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

