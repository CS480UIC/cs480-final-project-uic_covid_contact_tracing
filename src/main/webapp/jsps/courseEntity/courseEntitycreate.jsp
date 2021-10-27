<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>courseEntity Create</title>
    
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
  <h1>courseEntity Create</h1>
<form action="<c:url value='/covidTestingEntityCreate'/>" method="post">
	course_id    :<input type="text" name="course_id" value="${form.course_id }"/>
	<span style="color: red; font-weight: 900">${errors.course_id }</span>
	<br/>
	course_location：<input type="text" name="course_location" value="${form.course_location }"/>
	<span style="color: red; font-weight: 900">${errors.course_location }</span>
	<br/>
	UIN	：<input type="text" name="uin" value="${form.uin }"/>
	<span style="color: red; font-weight: 900">${errors.uin }</span>
	<br/>
	<input type="submit" value="Create courseEntity"/>
</form>
  </body>
</html>
