<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>Covid Testing CRUD</title>
    
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
    <h1>CRUD operations for Covid Testing </h1>
    <br>
	<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntitycreate.jsp'/>" target="_parent">Create covidTestingEntity</a> |&nbsp; 
	<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntityread.jsp'/>" target="_parent">Read covidTestingEntity</a> |&nbsp;
	<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntityupdate.jsp'/>" target="_parent">Update covidTestingEntity</a> |&nbsp;	 
	<a href="<c:url value='/jsps/covidTestingEntity/covidTestingEntitydelete.jsp'/>" target="_parent">Delete covidTestingEntity</a>	
	    
  </body>
</html>
