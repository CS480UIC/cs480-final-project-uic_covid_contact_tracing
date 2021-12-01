<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Student Entity</title>
    
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
  <h1>Update Student</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form>
		UIN    :<input type="text" name="uin" value="${student.uin }" disabled/>
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
	</form>
	
	<h1>Update the values below</h1>
	<form action="<c:url value='/StudentServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="uin" value="${student.uin }"/>
		
		Vaccination Status：<br>
		<input type="radio" id="0" name="vaccstatus0" value="0" ${student.vaccination_status == 0 ? 'checked' : ''} />
		  <label for="0">Not Vaccinated</label><br>
	  	<input type="radio" id="1" name="vaccstatus1" value="1" ${student.vaccination_status == 1 ? 'checked' : ''}>
		  <label for="1">One of Two doses</label><br>
	  	<input type="radio" id="2" name="vaccstatus2" value="2" ${student.vaccination_status == 2 ? 'checked' : ''}>
		  <label for="2">Fully Vaccinated</label>
		<span style="color: red; font-weight: 900">${errors.vaccstatus }</span>
		<br/>
		
		First Name	：<input type="text" name="fName" value="${student.first_name }"/>
		<span style="color: red; font-weight: 900">${errors.fName }</span>
		<br/>
		Last Name	：<input type="text" name="lName" value="${student.last_name }"/>
		<span style="color: red; font-weight: 900">${errors.lName }</span>
		<br/>
		Student Major：<br/>
		<select id="major" name="student_major" size="8">
			<option value="Computer Science" ${student.student_major_name == "Computer Science" ? 'selected' : '' }>Computer Science</option>
			<option value="Biology" ${student.student_major_name == "Biology" ? 'selected' : '' }>Biology</option>
			<option value="Business Administration" ${student.student_major_name == "Business Administration" ? 'selected' : '' }>Business Administration</option>
			<option value="English" ${student.student_major_name == "English" ? 'selected' : '' }>English</option>
			<option value="Integrated Health Science" ${student.student_major_name == "Integrated Health Science" ? 'selected' : '' }>Integrated Health Science</option>
			<option value="Chinese" ${student.student_major_name == "Chinese" ? 'selected' : '' }>Chinese</option>
			<option value="Computer Engineering" ${student.student_major_name == "Computer Engineering" ? 'selected' : '' }>Computer Engineering</option>
			<option value="Physics" ${student.student_major_name == "Physics" ? 'selected' : '' }>Physics</option>
		</select> 
		<span style="color: red; font-weight: 900">${errors.student_major }</span>
		<br/>
		Dorm:<br/>
		<select id="dorm" name="dorm_id" size="4">
			<option value="NULL" ${student.dorm_id == "NULL" ? 'selected' : '' }>NULL</option>
			<option value="JST" ${student.dorm_id == "JST" ? 'selected' : '' }>JST</option>
			<option value="CTY" ${student.dorm_id == "CTY" ? 'selected' : '' }>CTY</option>
			<option value="ARC" ${student.dorm_id == "ARC" ? 'selected' : '' }>ARC</option>
		</select> 
		<span style="color: red; font-weight: 900">${errors.dorm_id }</span>
		<br/>
		<input type="submit" value="Update Student"/>
	</form>

</body>
</html>
