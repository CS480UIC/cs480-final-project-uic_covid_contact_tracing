<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Covid Testing Entity</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	UIN    :<input type="text" name="uin" value="${covid.uin }" disabled/>
	<br/>
	
	Test Date：<input type="text" name="test_date" value="${covid.test_date }" disabled />
	<br/>
	Result Date	：<input type="text" name="result_date" value="${covid.result_date }" disabled/>
	<br/>
	Test Result	：<input type="text" name="test_result" value="${covid.test_result }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/CovidTestingServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="uin" value="${covid.uin }"/>
	Test Date：<input type="text" name="test_date" value="${covid.test_date }"  />
	<br/>
	Result Date	：<input type="text" name="result_date" value="${covid.result_date }" />
	<br/>
	Test Result	：<input type="text" name="test_result" value="${covid.test_result }" />
	<br/>
	<input type="submit" value="Update covidTestingEntity"/>
</form>

</body>
</html>
