<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Organization</title>
    
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
  <h1>Update Organization</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form>
		UIN    :<input type="text" name="uin" value="${organization.uin }" disabled/>
		<br/>
		
		Organization ID：<input type="text" name="organization_id" value="${organization.organization_id }" disabled />
		<br/>
		Organization Name：<input type="text" name="organization_name" value="${organization.organization_name }" disabled/>
		<br/>
	</form>
	<h1>Update the values below</h1>
	<form action="<c:url value='/OrganizationServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="uin" value="${organization.uin }"/>
		Organization ID：<input type="text" name="organization_id" value="${organization.organization_id }" />
		<br/>
		Organization Name：<input type="text" name="organization_name" value="${organization.organization_name }"/>
		<br/>
		<input type="submit" value="Update Organization"/>
	</form>

</body>
</html>
