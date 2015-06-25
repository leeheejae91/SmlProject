<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매칭페이지</title>
</head>
<body>
	<form action="${root }/searchMatching.do" method="POST"> 
		<div>
			이곳에 매칭에 관한 소개 및 설명을 작성
		</div>
		
		<input type="button" value="매칭시작"/>
		
		<%--매칭시작 누르면 페이지 변경 --%>
		<div>
			지역설정 이곳에서 하자
			<input type="text" />
		</div>
		<input type="button" value="다음"/>
		<%--다음 누르면 페이지변경 --%>
		<div>
			<h3>희망 요일</h3><input type="text"/>
			<h3>희망 경기시간</h3><input type="text" />
			<h3>최대 검색거리</h3><input type="text" />
			<input type="button" value="검색시작"/>
		</div>
		
		<%--검색시작누르면 페이지변경 --%>
		<div>
			매칭 완료!!
			<input type="button" value="확인!" />
		</div>
	</form>
</body>
</html>