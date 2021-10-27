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
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	UIN    :<input type="text" name="username" value="${form.uin }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Vaccination Status：<input type="password" name="password" value="${form.vaccstatus }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	First Name	：<input type="text" name="email" value="${form.fName }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Last Name	：<input type="text" name="email" value="${form.lName }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Department Name	：<input type="text" name="email" value="${form.deptName }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	<input type="submit" value="Create studentEntity"/>
</form>
  </body>
</html>
