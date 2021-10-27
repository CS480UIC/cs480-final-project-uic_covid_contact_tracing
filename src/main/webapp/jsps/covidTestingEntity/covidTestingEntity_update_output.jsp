<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	UIN    :<input type="text" name="uin1" value="${covidTestingEntity.uin }" disabled/>
	<br/>
	
	Test Date：<input type="text" name="test_date1" value="${covidTestingEntity.test_date1 }" disabled />
	<br/>
	Result Date	：<input type="text" name="result_date1" value="${covidTestingEntity.result_date1 }" disabled/>
	<br/>
	Test Result	：<input type="text" name="test_result1" value="${covidTestingEntity.test_result1 }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/covidTestingEntityUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${covidTestingEntity.username }"/>
	Test Result：<input type="text" name="test_result" value="${form.test_result }"/>
	<span style="color: red; font-weight: 900">${errors.test_result }</span>
	<br/>
	<!--   
	Email	：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/> 
	-->
	<input type="submit" value="Update covidTestingEntity"/>
</form>

</body>
</html>
