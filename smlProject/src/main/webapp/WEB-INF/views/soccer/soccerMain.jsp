<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${root }/js/startPage.js"></script>
</head>
<body>	
	<!-- 날짜 -->
	<jsp:useBean id="now" class="java.util.Date"/> 
		
	<a href="${root}/start.jsp"><img alt="logo" src=""></a>
	<a href="${root}/start.jsp">SML Korea</a>
	<br/><br/><br/>
	
	<div>
		<h5>팀명으로 검색 (팀페이지로 이동)</h5>
		<form name="form">
			<input type="text" placeholder="teamName" name="teamName"><input type="button" value="검색" onclick="teamSearch(form,'${root}')"/>
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
		
		<c:forEach var="todayMatch" items="${todayMatchList }">
		<ul>				
			<li> 	
				<span id="teamCode">
					<a href="${root }/teamPage/teamPageMain.do?teamName=${todayMatch.TEAMNAME1 }" target="_blank"><img alt="팀엠블럼1:${todayMatch.EMBLEM1 }" src="${todayMatch.EMBLEM1 }"/></a>
				</span>
				<span>${todayMatch.TEAMNAME1 }</span>
				
				<span>
					vs
				</span>
				
				<span id="teamcode2">
					<a href="${root }/teamPage/teamPageMain.do?teamName=${todayMatch.TEAMNAME2 }" target="_blank"><img alt="팀엠블럼2:${todayMatch.EMBLEM2 }" src="${todayMatch.EMBLEM2 }"/></a>
				</span>
				<span>${todayMatch.TEAMNAME2 }</span>
				
				<a href=""><span>${todayMatch.GAMEPLACE }</span></a>
			</li>		
		</ul>
		</c:forEach>
	</div>
	
	
	
	
	<div>
		<h3><a href="${root }/soccer/commonBoard.do">공지사항</a></h3>
		
		<ul>
			<c:forEach var="commonBoard" items="${commonBoardList}">					
				<li> 	
					<span id="date">
						<fmt:formatDate value="${commonBoard.boardDate }" type="date" pattern="MM-dd"/>
					</span>
					<span id="title">
						<a href="${root }/soccer/soccerCommonBoardRead.do?boardNumber=${commonBoard.boardNumber}">
							${commonBoard.boardTitle }
						</a>
					</span>
				</li>								
			</c:forEach>
		</ul>	
		
		<c:if test="${count>0 }">
			<c:set var="pageBlock" value="${1}"/>
			
			<fmt:parseNumber var="pageCount" value="${count/boardSize+ (count/boardSize==0 ? 0:1) }" integerOnly="true"/>
			
			<fmt:parseNumber var="rs" value="${(currentPage-1)/pageBlock }" integerOnly="true"/>
			<c:set var="startPage" value="${rs*pageBlock+1 }"/>
			<c:set var="endPage" value="${startPage+pageBlock-1 }"/>			
			<c:if test="${endPage>pageCount }">
				<c:set var="endPage" value="${pageCount }"/>
			</c:if>
			
			<c:if test="${startPage>pageBlock }">
				<a href="${root}/soccer/soccerMain.do?pageNumber=${startPage-pageBlock }"> < </a>
			</c:if>
		
			<c:if test="${endPage<pageCount }">
				<a href="${root}/soccer/soccerMain.do?pageNumber=${startPage+pageBlock }"> > </a>
			</c:if>
		</c:if>
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