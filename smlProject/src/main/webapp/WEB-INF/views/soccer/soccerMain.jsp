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
<script src="${root }/js/external/jquery-1.11.3.min.js"></script>
</head>
<body>	
	<script type="text/javascript">
		//geolocation API 지원 탐지
		if (navigator.geolocation) {  
  			/* geolocation is available */  
		} else {  
			alert("I'm sorry, but geolocation services are not supported by your browser.");  
		}  
	
		
		//현재 위치 탐지 		
		navigator.geolocation.getCurrentPosition(showMap);
		function showmap(position) {
			latitude = position.coords.latitude;
			longitude = position.coords.longitude;
			
			//기상청 위도/경도 계산
			var rs = dfs_xy_conv("toXY",latitude,longitude);
		    // 위도/경도 -> 기상청 좌표x / 좌표 y 변환
		     
		    //위치에 맞는 실황 정보 API 불러오기
			xml2jsonCurrentWth(rs.nx, rs.ny);
		}
		
		
		//기상청 위도/경도 계산///////////////////////
		// LCC DFS 좌표변환을 위한 기초 자료
	    //
	    var RE = 6371.00877; // 지구 반경(km)
	    var GRID = 5.0; // 격자 간격(km)
	    var SLAT1 = 30.0; // 투영 위도1(degree)
	    var SLAT2 = 60.0; // 투영 위도2(degree)
	    var OLON = 126.0; // 기준점 경도(degree)
	    var OLAT = 38.0; // 기준점 위도(degree)
	    var XO = 43; // 기준점 X좌표(GRID)
	    var YO = 136; // 기1준점 Y좌표(GRID)
	    //
	    // LCC DFS 좌표변환 ( code : "toXY"(위경도->좌표, v1:위도, v2:경도), "toLL"(좌표->위경도,v1:x, v2:y) )
	    //
		function dfs_xy_conv(code, v1, v2) {
		    var DEGRAD = Math.PI / 180.0;
		    var RADDEG = 180.0 / Math.PI;
		 
		    var re = RE / GRID;
		    var slat1 = SLAT1 * DEGRAD;
		    var slat2 = SLAT2 * DEGRAD;
		    var olon = OLON * DEGRAD;
		    var olat = OLAT * DEGRAD;
		 
		    var sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
		    sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
		    var sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
		    sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
		    var ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
		    ro = re * sf / Math.pow(ro, sn);
		    var rs = {};
		    if (code == "toXY") {		 
		        rs['lat'] = v1;
		        rs['lng'] = v2;
		        var ra = Math.tan(Math.PI * 0.25 + (v1) * DEGRAD * 0.5);
		        ra = re * sf / Math.pow(ra, sn);
		        var theta = v2 * DEGRAD - olon;
		        if (theta > Math.PI) theta -= 2.0 * Math.PI;
		        if (theta < -Math.PI) theta += 2.0 * Math.PI;
		        theta *= sn;
		        rs['nx'] = Math.floor(ra * Math.sin(theta) + XO + 0.5);
		        rs['ny'] = Math.floor(ro - ra * Math.cos(theta) + YO + 0.5);
		    }
		    else {
		        rs['nx'] = v1;
		        rs['ny'] = v2;
		        var xn = v1 - XO;
		        var yn = ro - v2 + YO;
		        ra = Math.sqrt(xn * xn + yn * yn);
		        if (sn < 0.0) - ra;
		        var alat = Math.pow((re * sf / ra), (1.0 / sn));
		        alat = 2.0 * Math.atan(alat) - Math.PI * 0.5;
		 
		        if (Math.abs(xn) <= 0.0) {
		            theta = 0.0;
		        }
		        else {
		            if (Math.abs(yn) <= 0.0) {
		                theta = Math.PI * 0.5;
		                if (xn < 0.0) - theta;
		            }
		            else theta = Math.atan2(xn, yn);
		        }
		        var alon = theta / sn + olon;
		        rs['lat'] = alat * RADDEG;
		        rs['lng'] = alon * RADDEG;
		    }
			return rs;
		}
		// dfs_xy_conv
		
		//위치에 맞는 실황 정보 API 불러오기
		function xml2jsonCurrentWth(nx, ny){
			var today = new Date();
		    var dd = today.getDate();
		    var mm = today.getMonth()+1;
		    var yyyy = today.getFullYear();
		    var hours = today.getHours();
		    var minutes = today.getMinutes();
		    console.log("time " + minutes)
		 
		    if(minutes < 30){
		        // 30분보다 작으면 한시간 전 값
		        hours = hours - 1;
		        if(hours < 0){
		            // 자정 이전은 전날로 계산
		            today.setDate(today.getDate() - 1);
		            dd = today.getDate();
		            mm = today.getMonth()+1;
		            yyyy = today.getFullYear();
		            hours = 23;
		        }
		    }
		    if(hours<10) {
		        hours='0'+hours
		    }
		    if(mm<10) {
		        mm='0'+mm
		    }
		    if(dd<10) {
		        dd='0'+dd
		    } 
		 
		    var _nx = nx, _ny = ny,
		    apikey = "Emz8CfMLIHnIeD7Hl6qDBtzOB5Mpt3Sgh8G9ol07R4yzQ3ffyNDX%2BTdekwX6KD2utTd7q8UbAik%2B8pgk7w3bug%3D%3D",
		    today = yyyy+""+mm+""+dd,
		    basetime = hours + "00",
		    fileName = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib";
		    fileName += "?ServiceKey=" + apikey;
		    fileName += "&base_date=" + today;
		    fileName += "&base_time=" + basetime;
		    fileName += "&nx=" + _nx + "&ny=" + _ny;
		    fileName += "&pageNo=1&numOfRows=6";
		    fileName += "&_type=json";
		 
		    $.ajax({
			    url: fileName,
			    // dataType: "jsonp",
			    type: 'GET',
			    cache: false,
			    success: function(data) {
			        var myXML = rplLine(data.responseText);
			        var indexS = myXML.indexOf(""),
			            indexE = myXML.indexOf(""),
			            result = myXML.substring(indexS + 3, indexE);
			        var jsonObj = $.parseJSON('[' + result + ']'),
			            rainsnow = jsonObj[0].response.body.items.item[0].obsrValue,
			            sky = jsonObj[0].response.body.items.item[4].obsrValue,
			            temp = jsonObj[0].response.body.items.item[5].obsrValue;
			            var contentText = document.getElementById('content');
			            contentText.innerHTML = sky + " / " + rainsnow + " / " + temp;
			    },
			    error:function(request,status,error){
			        alert("다시 시도해주세요.\n" + "code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
		    });		 
		}
		// xml2jsonCurrentWth
		 
		function rplLine(value){
		    if (value != null && value != "") {
		        return value.replace(/\n/g, "\\n");
		    }else{
		        return value;
		    }
		}
		// rplLine
		
		
		/* $(function(){
			$.ajax({
				url:'http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108',
				dataType:'xml',
				success:function(response){
					console.log(response);
					$(response).find('location').each(function(){
						var city=$(this).find('city').text();
						if(city=='서울'){
							$('body').append(city+'<br>');
							$(this).find('data').each(function(){
								var output=$(this).find('tmEf').text() + ' ' + $(this).find('wf').text();
								$('body').append(output+'<br>');
							})
						}
					})
				}
			});
		}); */
	</script>

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
	
	<script type="text/javascript">
		var date = new Date(); // 날짜 객체 생성
		var y = date.getFullYear(); // 현재 연도
		var m = date.getMonth(); // 현재 월
		var d = date.getDate(); // 현재 일
			//7/2
		    // 현재 년(y)월(m)의 1일(1)의 요일을 구합니다.
		var theDate = new Date(y,m,1);
		    // 그 날의 요일은?
		var theDay = theDate.getDay();
	
		/* 현재 월의 마지막 일을 구합니다. */
		    // 1월부터 12월까지의 마지막 일을 배열로 만듭니다.
		var last = [31,28,31,30,31,30,31,31,30,31,30,31];
		    // 4년마다 있는 윤년을 계산합니다.(100년||400년 주기는 제외)
		if (y%4 && y%100!=0 || y%400===0) {
		    lastDate = last[1] = 29;
		}
		    // 현재 월의 마지막 일이 며칠인지 구합니다.
		var lastDate = last[m];
		
		$(function() {			    
			$("#matchingList").children("span:eq(1)")
		});
		
	</script>
		
	<form action="" name="someform">
		<select id="daydropdown"></select> 
		<select id="monthdropdown"></select> 
		<select id="yeardropdown">
		</select>
	</form>
	
	<script type="text/javascript">
		window.onload = function() {
			populatedropdown("yeardropdown", "monthdropdown",
					"daydropdown")
		}
	</script>	
	
	
	<div id="matchingList">
		<h3><a href="">금주매치</a></h3>
		<ul>
			<li>
				<span><input type="button" value="<" onclick=""/></span>
				<span><fmt:formatDate value="${now }" type="date" pattern="MM월 dd일" /></span>
				<span>요일</span>
				<span><input type="button" value=">"/></span>
			</li>				
		</ul>	
		
		<c:if test="${todayMatchList==null }">
			<span>매치 없음</span>
		</c:if>
		
		<c:if test="${todayMatchList!=null }">
			<c:forEach var="todayMatch" items="${todayMatchList }">
			<ul>				
				<li> 	
					<span id="teamCode">
						<a href="${root }/teamPage/teamPageMain.do?teamName=${todayMatch.TEAMNAME1 }" target="_blank"><img alt="팀엠블럼1:${todayMatch.EMBLEM1 }" src="${root }/img/soccer/emblem/${todayMatch.EMBLEM1 }"/></a>
					</span>
					<span>${todayMatch.TEAMNAME1 }</span>
					
					<span>vs</span>
					
					<span id="teamcode2">
						<a href="${root }/teamPage/teamPageMain.do?teamName=${todayMatch.TEAMNAME2 }" target="_blank"><img alt="팀엠블럼2:${todayMatch.EMBLEM2 }" src="${root }/img/soccer/emblem/${todayMatch.EMBLEM2 }"/></a>
					</span>
					<span>${todayMatch.TEAMNAME2 }</span>
					
					<a href=""><span>${todayMatch.GAMEPLACE }</span></a>
				</li>		
			</ul>
			</c:forEach>
		</c:if>
	</div>
	
		
	<div>
		<h3><a href="${root }/soccer/commonBoard.do">공지사항</a></h3>
		<c:if test="${commonBoardList==null }">
			<span>공지사항 없음</span>
		</c:if>
		
		<c:if test="${commonBoardList!=null}">
			<ul>
				<c:forEach var="commonBoard" items="${commonBoardList}">					
					<li> 	
						<span id="date">
							<fmt:formatDate value="${commonBoard.boardDate }" type="date" pattern="MM-dd"/>
						</span>
						<span id="title">
							<a href="#"
								onclick="window.open('${root }/soccer/readCommonBoard.do?boardNumber=${commonBoard.boardNumber}', '공지사항','width=400, height=200');return false;" target="_blank">										
								${commonBoard.boardTitle }
							</a>
						</span>
					</li>								
				</c:forEach>
			</ul>	
		</c:if>
		
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