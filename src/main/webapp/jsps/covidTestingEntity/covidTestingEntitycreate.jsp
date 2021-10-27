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
<form action="<c:url value='/covidTestingEntityCreate'/>" method="post">
	UIN    :<input type="text" name="username" value="${form.uin }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Test Date：<input type="text" name="test_date" value="${form.test_date }"/>
	<span style="color: red; font-weight: 900">${errors.test_date }</span>
	<br/>
	Result Date	：<input type="text" name="result_date" value="${form.result_date }"/>
	<span style="color: red; font-weight: 900">${errors.result_date }</span>
	<br/>
	Test Result	：<input type="text" name="test_result" value="${form.test_result }"/>
	<span style="color: red; font-weight: 900">${errors.test_result }</span>
	<br/>
	<input type="submit" value="Create covidTestingEntity"/>
</form>
  </body>
</html>
