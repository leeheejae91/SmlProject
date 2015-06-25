<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>심판 현황</title>
</head>
<body>
	
	<a href="${root}/start.jsp"><img alt="logo" src=""></a>
	<a href="${root}/start.jsp">SML Korea</a>
	
	<h3>심판현황</h3>
	
	<div>
		<h3>
			<a href="${root}/soccer/soccerMain.do">홈</a>
			<a href="${root}/soccer/soccerRule.do">경기규칙</a>
			<a href="${root}/soccer/soccerTeamList.do">팀리스트</a>
			<a href="${root}/soccer/soccerGameScore.do">기록리스트</a>
			<a href="${root}/referee/refereeList.do/">심판현황</a>
		</h3>
	</div>	
	
	<div>
		<input type="button" value="전체"/>
		<input type="button" value="서울"/>
		<input type="button" value="대전"/>
		<input type="button" value="대구"/>
		<input type="button" value="부산"/>
		<input type="button" value="강원"/>
		
	<div>		
		<div>
			<ul>
				<li><img alt="심판사진" src=""/></li>
				<li>심판이름</li>
				<li>심판나이</li>
				<li>심판지역</li>
			</ul>			
		</div>
		
		<div>
			<ul>
				<li><img alt="심판사진" src=""/></li>
				<li>심판이름</li>
				<li>심판나이</li>
				<li>심판지역</li>
			</ul>			
		</div>													
	</div>
	
	<input type="button" value="심판 지원하기" onclick="location.href='${root}/referee/registerReferee.do'"/>
</body>
</html>