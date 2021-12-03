<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">List all the users in the user table</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/unvaccinatedStudents'/>" target="body">List all unvaccinated students</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/nonNegativeTests'/>" target="body">List all covid tests with non-negative results</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/arcResidents'/>" target="body">List all residents in ARC</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/testResultPercentages'/>" target="body">List test result percentages in db</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/numMembersPerOrg'/>" target="body">List number of members in orgs (orgs larger than 1 member)</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/numTests2021'/>" target="body">List number of covid tests done in 2021</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/vaxStatusResidents'/>" target="body">List vaccination statuses of UIC dorm residents</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/studentsInOrgs'/>" target="body">List UINs of students in orgs of size 2+</a>&nbsp;&nbsp;
	<br>
    <a href="<c:url value='/unvaxxedStudentsInOrgs'/>" target="body">List UINs of unvaccinated students in orgs</a>&nbsp;&nbsp;
	<br>
    
  </body>
</html>
