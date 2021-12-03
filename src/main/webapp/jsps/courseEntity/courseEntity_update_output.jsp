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
  <h1>Update Course</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	UIN    :<input type="text" name="uin" value="${course.uin }" disabled/>
	<br/>
	
	Course ID：<input type="text" name="course_id" value="${course.course_id }" disabled />
	<br/>
	Course Location：<input type="text" name="course_location" value="${course.course_location }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/CourseServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="uin" value="${course.uin }"/>
	
	Course ID：<input type="text" name="course_id" value="${course.course_id }" />
	<br/>
	Course Location：<input type="text" name="course_location" value="${course.course_location }"/>
	<br/>
	<input type="submit" value="Update Course"/>
</form>

</body>
</html>
