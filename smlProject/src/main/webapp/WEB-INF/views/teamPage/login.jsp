<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center"> SML Korea </h3> 
	
	<form action="${root }/teamPage/login.do" method="POST">
		<div id="test2" align="center">
			<label>���̵�</label><input type="text"  name="id"/><br/>
			<label>��й�ȣ</label><input type="password"  name="password"/><br/>
			<a href="#">���̵�/��й�ȣã��</a><br/>
			
			<input type="submit" value="�α���"/>
			<input type="reset" value="���"/>
		</div>
	</form>
</body>
</html>