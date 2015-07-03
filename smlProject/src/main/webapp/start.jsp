<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${root }/js/startPage.js"></script>
<script src="${root }/js/external/angular.min.js"></script>
<script src="${root }/js/external/ui-bootstrap-0.13.0.min.js"></script>
<script src="${root }/js/external/ui-bootstrap-tpls-0.13.0.js"></script>
<script src="${root }/js/external/jquery-1.11.3.min.js"></script>
<link type="text/css" href="${root }/css/external/bootstrap.min.css"/>
</head>
<body>
	<div>
		<a href="${root}/start.jsp"><img alt="logo" src=""></a>
		<a href="${root}/start.jsp">SML Korea</a>
	</div>
	
	<h5>팀명으로 검색 (팀페이지로 이동)</h5>
	<form name="form">
		<input type="text" placeholder="teamName" name="teamName"><input type="button" value="검색" onclick="teamSearch(form,'${root}')"/>
	</form>
	
	<h3>about</h3>
	<h3>sport</h3>
	<h3>ground</h3>
	<h3>info</h3>
	
	<div>
		이부분에 이미지 슬라이더 넣어야함
		<input type="button" value="팀등록" onclick="location.href='${root}/member/registerTeam.do'"/>
		<input type="button" value="로그인" onclick="location.href='${root}/teamPage/login.do'"/>
	</div>
	
	<div>
		<h3><a href="${root}/soccer/soccerMain.do">축구</a></h3>
		<h3>풋살</h3>
		<h3>야구</h3>
		<h3>족구</h3>
	</div>
	
	<div>
		이부분에 지도 넣어야함
	</div>
	
	<div>
		고객센터 부분
		<h3>전화번호 : 02 - 123 - 4567</h3>
		<h3>이메일 : smlKorea@sml.com</h3>
	</div>
	
	
</body>
</html>