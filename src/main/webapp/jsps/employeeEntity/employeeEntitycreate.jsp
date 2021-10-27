<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>employeeEntity Create</title>
    
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
  <h1>employeeEntity Create</h1>
<form action="<c:url value='/studentEntityServletCreate'/>" method="post">
	UIN    :<input type="text" name="uin" value="${form.uin }"/>
	<span style="color: red; font-weight: 900">${errors.uin }</span>
	<br/>
	
	Vaccination Status：<br>
	<input type="radio" id="0" name="vaccstatus0" value="${form.vaccstatus0 }">
	  <label for="0">Not Vaccinated</label><br>
  	<input type="radio" id="1" name="vaccstatus1" value="${form.vaccstatus1 }">
	  <label for="1">One of Two doses</label><br>
  	<input type="radio" id="2" name="vaccstatus2" value="${form.vaccstatus2 }">
	  <label for="2">Fully Vaccinated</label>
	<span style="color: red; font-weight: 900">${errors.vaccstatus }</span>
	<br/>
	
	First Name	：<input type="text" name="fName" value="${form.fName }"/>
	<span style="color: red; font-weight: 900">${errors.fName }</span>
	<br/>
	Last Name	：<input type="text" name="lName" value="${form.lName }"/>
	<span style="color: red; font-weight: 900">${errors.lName }</span>
	<br/>
	Department Name	：<input type="text" name="deptName" value="${form.deptName }"/>
	<span style="color: red; font-weight: 900">${errors.deptName }</span>
	<br/>
	<input type="submit" value="Create employeeEntity"/>
</form>
  </body>
</html>
