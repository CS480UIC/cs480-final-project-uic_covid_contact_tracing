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
			<!-- 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp; 
			-->
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<br>
			<a href="<c:url value='/jsps/studentEntity/studentEntitycreate.jsp'/>" target="body">Create Student</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentEntity/studentEntityread.jsp'/>" target="body">Read Student</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentEntity/studentEntityupdate.jsp'/>" target="body">Update Student</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentEntity/studentEntitydelete.jsp'/>" target="body">Delete Student</a> |&nbsp;&nbsp;
			<br>
			<a href="<c:url value='/jsps/employeeEntity/employeeEntitycreate.jsp'/>" target="body">Create Employee</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/employeeEntity/employeeEntityread.jsp'/>" target="body">Read Employee</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/employeeEntity/employeeEntityupdate.jsp'/>" target="body">Update Employee</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/employeeEntity/employeeEntitydelete.jsp'/>" target="body">Delete Employee</a> |&nbsp;&nbsp;
			<br>
			<a href="<c:url value='/jsps/courseEntity/courseEntitycreate.jsp'/>" target="body">Create Course</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/courseEntity/courseEntityread.jsp'/>" target="body">Read Course</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/courseEntity/courseEntityupdate.jsp'/>" target="body">Update Course</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/courseEntity/courseEntitydelete.jsp'/>" target="body">Delete Course</a> |&nbsp;&nbsp;
			<br>
			<a href="<c:url value='/jsps/contactInformationEntity/contactInformationEntitycreate.jsp'/>" target="body">Create Contact_information</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/contactInformationEntity/contactInformationEntityread.jsp'/>" target="body">Read Contact_information</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/contactInformationEntity/contactInformationEntityupdate.jsp'/>" target="body">Update Contact_information</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/contactInformationEntity/contactInformationEntitydelete.jsp'/>" target="body">Delete Contact_information</a> |&nbsp;&nbsp;
			<br>
			<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntitycreate.jsp'/>" target="body">Create Covid_test</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntityread.jsp'/>" target="body">Read Covid_test</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntityupdate.jsp'/>" target="body">Update Covid_test</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntitydelete.jsp'/>" target="body">Delete Covid_test</a> |&nbsp;&nbsp;
			<br>
			<a href="<c:url value='/jsps/studentHousingEntity/studentHousingEntitycreate.jsp'/>" target="body">Create Student_housing</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentHousingEntity/studentHousingEntityread.jsp'/>" target="body">Read Student_housing</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentHousingEntity/studentHousingEntityupdate.jsp'/>" target="body">Update Student_housing</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/studentHousingEntity/studentHousingEntitydelete.jsp'/>" target="body">Delete Student_housing</a> |&nbsp;&nbsp;
			<br>
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

