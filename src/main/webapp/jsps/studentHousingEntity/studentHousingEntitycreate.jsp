<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>studentHousingEntity Create</title>
    
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
  <h1>studentHousingEntity Create</h1>
<form action="<c:url value='/StudentHousingServletCreate'/>" method="post">
	UIN	：<input type="text" name="uin" value="${form.uin }"/>
	<span style="color: red; font-weight: 900">${errors.uin }</span>
	<br/>
	dorm_id    :<input type="text" name="dorm_id" value="${form.dorm_id }"/>
	<span style="color: red; font-weight: 900">${errors.dorm_id }</span>
	<br/>
	room_number：<input type="text" name="room_number" value="${form.room_number }"/>
	<span style="color: red; font-weight: 900">${errors.room_number }</span>
	<br/>

	<input type="submit" value="Create studentHousingEntity"/>
</form>
  </body>
</html>
