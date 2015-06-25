<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
	<a href="${root}/start.jsp"><img alt="logo" src=""></a>
	<a href="${root}/start.jsp">SML Korea</a>
	
	<h3>기록실</h3>
	
	<input type="button" value="전체"/>
	<input type="button" value="경기"/>
	<input type="button" value="강원"/>
	<input type="button" value="전북"/>
	<input type="button" value="전남"/>
	<br/><br/>
	
	
</body>
</html>