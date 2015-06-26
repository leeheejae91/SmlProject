<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath }"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${root}/js/external/jquery-1.11.3.min.js"></script>
	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	
	<title>팀목록보기</title>
	<script type="text/javascript">
	$(function() {
	    $( "#startLeagueDate" ).datepicker({
	    });
	    
	    $( "#endLeagueDate" ).datepicker({
	    });
	});
	</script>
</head>
<body>	
	<form>
	<div align="center">
	
	<h2>리그개설</h2>
	<br/><br/><br/>
	
	
	<span>리그명</span>	
	<input type="text" id="leagueName"></input>	
	<br/><br/>
	
	<span>종목</span>	
	<select name="sportCode" >
				<option>종목선택</option>			
				<option value="0">전체</option>
				<option value="1">축구</option>
				<option value="2">야구</option>
				<option value="3">족구</option>
				<option value="4">풋살</option>	
	</select>
	<br/><br/>
	
	<span>리그기간</span>
	<input type="text" id="startLeagueDate">
	<span>~</span>
	<input type="text" id="endLeagueDate">
	
	<br/><br/>
	
	<span>개최지</span>
	
	<input type="text" id="leagueLocation1"></input>
	<br/><br/>
	<input type="text" id="leagueLocation2"></input>
	
	
	<br/><br/>
	<span>리그요일</span>
	<span>Sat</span>
	<input type="radio" id="leagueDay1" value="sat">
	<span>Sun</span>
	<input type="radio" id="leagueDay2" value="sun">
	<br/><br/>
	
	<span>리그시간</span>
	<input type="text" id="startLeagueTime"></input>
	<br/><br/>
	
	<span>리그이미지</span>
	<input type="file" id="leagueImageUpload" value="파일첨부"></input> <img src=""></img>
	
	<br/><br/>	
	
	<input type="submit" id="createLeague" value="리그개설"></input>
	
	</div>
	</form>
</body>
</html>