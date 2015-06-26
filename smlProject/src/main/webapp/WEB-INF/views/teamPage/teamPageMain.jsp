<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>팀페이지</title>
</head>
<body>
	<c:if test="${team!=null}">
		<c:set var="teamId" value="${teamId}" scope="session"/>
		<c:set var="teamGrade" value="${teamGrade }" scope="session"/>
		<c:set var="teamName" value="${teamName }" scope="session"/>
	</c:if>
	
	<div>
		<a href="${root}/start.jsp"><img alt="logo" src=""></a>
		<a href="${root}/start.jsp">SML Korea</a>
	</div>
	
	<c:if test="${team==null}">
		<div style="text-align:center;">
			<h1>SML KOREA</h1>
			<br/>
			<h6>해당 팀이 존재하지 않습니다.</h6>
		</div>
	</c:if>
	
	<div>
		<a href="${root}/start.jsp"><img alt="logo" src=""></a>
		<a href="${root}/start.jsp">SML Korea</a>
	</div>
	
	<c:if test="${team==null}">
	<div style="text-align:center;">
		<h1>SML KOREA</h1>
		<br/>
		<h6>해당 팀이 존재하지 않습니다.</h6>
	</div>
		
	</c:if>
	
	<c:if test="${team!=null}">
	<div>
		SML KOREA 
		<ul>
			<c:if test="${teamGrade != null }">
				<li>${teamId }님</li>
				<li><a href="${root }/teamPage/teamPageMain.do?teamName=${team.teamName}">메인</a></li>
				<li><a href="${root }/teamPage/viewTeamBoard.do?teamName=${team.teamName}">팀 공지사항</a></li>
				<li><a href="${root }/teamPage/teamMemberInfo.do?teamName=${team.teamName}">팀원소개</a></li>
				<li><a href="${root }/teamPage/teamSchedule.do">팀 스케쥴</a></li>

				<li><a href="${root }/viewTeamRecord">팀 기록</a></li>
				<li><a href="${root }/viewSchedule.do">팀 스케쥴</a></li>

				<li>----------</li>
				<li><a href="${root }/viewTeamBoard.do">공지사항관리</a></li>
				<li><a href="${root }/manageTeamMember.do">팀원관리</a></li>
				<li><a href="${root }/teamPage/teamScheduleEdit.do">스케쥴관리</a></li>
				<li><a href="${root }/startMatching.do">매칭관리</a></li>
				<li>-----------</li>
				<li><a href="${root}/teamPage/logout.do?teamId='${teamId}'">로그아웃</a></li>
		  	</c:if>
		  	
		  	<c:if test="${teamGrade == null }">
				<li><a href="${root }/teamPage/teamPageMain.do?teamName=${team.teamName}">메인</a></li>
				<li><a href="${root }/teamPage/viewTeamBoard.do?teamName=${team.teamName}">팀 공지사항</a></li>
				<li><a href="${root }/teamPage/teamMemberInfo.do?teamName=${team.teamName}">팀원소개</a></li>

				<li><a href="${root }/teamMemberInfo.do">팀원소개</a></li>
				<li><a href="${root }/viewSchedule.do">팀 기록</a></li>
				<li><a href="${root }/viewSchedule.do">팀 스케쥴</a></li>

			</c:if>

		</ul>
	</div>
	
	<div>
		<img alt="팀 로고 이미지 넣어야함" src=""/>
		<h3>팀 이름 : ${team.teamName}</h3>
		<input type="button" value="매칭대기중">
	</div>
	
	<div>
		팀소개 넣는칸
	</div>
	
	<div>
		공지사항 넣는칸
	</div>
	
	<div>
		달력 넣는칸
	</div>
	
	<div>
		<div>
			기록실 넣는칸
		</div>
		
		<div>
			자기팀에관한 정보 넣는칸
		</div>
	</div>
	
	<div>
		<div>
			<label>닉네임</label> <input type="text" name="nickName"/>
			<label>비밀번호</label> <input type="text" name="password"/>
			<input type="text" placeholder="한마디 남겨주세요" name="content"/>
			<input type="button" value="작성"/>
		</div>
		
		<div>
			댓글 리스트 나오는창
		</div>
	</div>	
	</c:if>
</body>
</html>
