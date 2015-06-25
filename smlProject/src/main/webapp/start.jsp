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
	<h3>${root }</h3>
	<div>
		<a href="${root}/"><img alt="logo" src=""></a>
		<a href="${root}/">SML Korea</a>
		<a href="${root }/teamPage.do">teamPage</a>	
	</div>
	
	<h3>about</h3>
	<h3>sport</h3>
	<h3>ground</h3>
	<h3>info</h3>
	
	<div>
		이부분에 이미지 슬라이더 넣어야함
		<input type="button" value="팀생성"/>
		<input type="button" value="로그인" onclick="javascript:test()"/>
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
	
	<form action="${root }/login.do" method="POST">
		<div id="test2">
			<label>아이디</label><input type="text" placeholder="id를 입력하세요" name="id"/><br/>
			<label>비밀번호</label><input type="password" placeholder="비밀번호를 입력하세요" name="password"/><br/>
			<a href="#">아이디를 잊으셨나요?</a><br/>
			<a href="#">비밀번호를 잊으셨나요?</a><br/>
			<input type="button" value="로그인"/>
		</div>
	</form>
	
	<div>
		<a href="${root}/admin/main.do">관리자페이지</a>
	</div>
	
	<div>
		<a href="${root}/board/adminBoard.do">공지사항게시판</a>	
	</div>
</body>
</html>