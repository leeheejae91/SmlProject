<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
	<!-- 날짜 -->
	<jsp:useBean id="now" class="java.util.Date"/> 
		
	<a href="${root}/start.jsp"><img alt="logo" src=""></a>
	<a href="${root}/start.jsp">SML Korea</a>
	<br/><br/><br/>
	
	<div>
		<form action="${root }/soccer/teamSearch.do" id="search-box" onsubmit="if(this.q.value ==' 팀 검색'){this.q.focus();return false;}">
			<input type="text" name="teamName" style="color: #D2D2D2;" value="팀 검색" onfocus="this.value=''" onblur="if(!this.value) this.value=' 팀 검색';"/>
			<input type="submit" value="검색"/>
		</form>
		
		<h3>날씨 파싱</h3>
	</div>
	
	
	
	
	<div>
		<h3>
			<a href="${root}/soccer/soccerMain.do">홈</a>
			<a href="${root}/soccer/soccerRule.do">경기규칙</a>
			<a href="${root}/soccer/soccerTeamList.do">팀리스트</a>
			<a href="${root}/record/soccerGameScore.do">기록리스트</a>
			<a href="${root}/referee/refereeList.do">심판현황</a>
		</h3>
	</div>	
	
	
	
	<!-- jquery -->
	<div>
		<h3><a href="">금주매치</a></h3>
		<ul>
				<li>
					<span><input type="button" value="<" onclick=""/></span>
					<span><fmt:formatDate value="${now }" type="date" pattern="MM월 dd일" /></span>
					<span><input type="button" value=">"/></span>
				</li>
				
		</ul>	
		
		<ul>				
			<li> 	
				<span id="team1">
					<a href=""><img alt="팀1" src=""/></a>
				</span>
				<span>
					vs
				</span>
				<span id="team2">
					<a href=""><img alt="팀2" src=""/></a>
				</span>
			</li>		
		</ul>
	</div>
	
	
	
	
	<div>
		<h3><a href="">공지사항</a></h3>
		
		<ul>
			<c:forEach var="board" items="${boardList}">					
				<li> 	
					<span id="date">
						<fmt:formatDate value="${board.writeDate }" type="date" />
					</span>
					<span id="title">
						<a href="${root }/board/read.do?boardNumber=${board.boardNumber}">
							${board.subject }
						</a>
					</span>
				</li>								
			</c:forEach>
		</ul>	
	</div>	
		
		
		
		
	<div>
		<h3>리그</h3>
		<ul>
				<li>
					<span><input type="button" value="<"/></span>
					<img alt="리그 이미지 넣어야함" src=""/>
					<span><input type="button" value=">"/></span>
				</li>
		</ul>
		
	</div>	
	
	
	
	
	<div>
		<h3>통계</h3>
	</div>
		
		
		
		
	<div>
		고객센터 부분
		<h3>전화번호 : 02 - 123 - 4567</h3>
		<h3>이메일 : smlKorea@sml.com</h3>
	</div>
</body>
</html>