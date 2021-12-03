<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>studentEntity Create</title>
    
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
  <h1>studentEntity Create</h1>
<form action="<c:url value='/StudentServletCreate'/>" method="post">
	UIN    :<input type="text" name="uin" value="${form.uin }"/>
	<span style="color: red; font-weight: 900">${errors.uin }</span>
	<br/>
	
	Vaccination Status：<br>
	<input type="radio" id="0" name="vaccstatus0" value="0">
	  <label for="0">Not Vaccinated</label><br>
  	<input type="radio" id="1" name="vaccstatus1" value="1">
	  <label for="1">One of Two doses</label><br>
  	<input type="radio" id="2" name="vaccstatus2" value="2">
	  <label for="2">Fully Vaccinated</label>
	<span style="color: red; font-weight: 900">${errors.vaccstatus }</span>
	<br/>
	
	First Name	：<input type="text" name="fName" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.fName }</span>
	<br/>
	Last Name	：<input type="text" name="lName" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.lName }</span>
	<br/>
	Student Major：<br/>
	<select id="major" name="student_major" size="8">
		<option value="Computer Science">Computer Science</option>
		<option value="Biology">Biology</option>
		<option value="Business Administration">Business Administration</option>
		<option value="English">English</option>
		<option value="Integrated Health Science">Integrated Health Science</option>
		<option value="Chinese">Chinese</option>
		<option value="Computer Engineering">Computer Engineering</option>
		<option value="Physics">Physics</option>
	</select> 
	<span style="color: red; font-weight: 900">${errors.student_major }</span>
	<br/>
	Dorm:<br/>
	<select id="dorm" name="dorm_id" size="4">
		<option value="NULL">NULL</option>
		<option value="JST">JST</option>
		<option value="CTY">CTY</option>
		<option value="ARC">ARC</option>
	</select> 
	<span style="color: red; font-weight: 900">${errors.dorm_id }</span>
	<br/>
	
	<input type="submit" value="Create studentEntity"/>
</form>
  </body>
</html>
