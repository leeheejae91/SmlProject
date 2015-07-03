<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="${root }/css/sml.css" type="text/css" />
<link rel="stylesheet" href="${root }/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" type="text/css"  href="${root}/css/member/jquery-ui.css"/>

<script src="${root }/js/jquery-1.11.3.min.js"></script>
<script src="${root }/js/bootstrap.js"></script>
<script src="${root }/js/sml.js"></script>
<script src="//apis.daum.net/maps/maps3.js?apikey=1442260e0c6af86974001269a7312e42&libraries=services"></script>
<script src="${root }/js/test.js"></script>
<script src="${root }/js/mainPage.js"></script>
<script type="text/javascript" src="${root}/js/member/jquery-ui.js"></script>
<script type="text/javascript" src="${root}/js/member/member.js"></script>
<script type="text/javascript" src="${root}/js/xhr/xhr.js"></script>
<title>SML Project</title>
</head>

<body>
	<!-- 전체 감싸는 div -->
	<div class="container">
		<!-- 로고랑 네비바 있는 div -->
		<br/>
		<div class="row">
			<!-- 로고 -->
			<div class="col-md-5">
				<img alt="Logo" src="${root }/img/smlLogo.png">
			</div>
  			
  			<!-- nav bar -->
  			<div class="col-md-4">
  				<div class="row">
			      <div class="col-xs-8 col-sm-3">
			       	<a class="btn btn-default" href="#smlAbout" role="button">about</a>
			      </div>
			      <div class="col-xs-4 col-sm-3">
			        <a class="btn btn-default" href="#smlService" role="button">sport</a>
			      </div>
			      <div class="col-xs-8 col-sm-3">
			        <a class="btn btn-default" href="#smlMap" role="button">ground</a>
			      </div>
			      <div class="col-xs-8 col-sm-3">
			        <a class="btn btn-default" href="#smlInfo" role="button">info</a>
			      </div>
   			 	</div>
  			</div>
  			
  			<!-- 팀명검색 -->
  			<div class="col-md-3">
  				<form class="form-inline">
  					<div class="form-group">
					    <input type="text" class="form-control" id="searchTeamName" placeholder="search">
 				   </div>
  					<button type="submit" class="btn btn-default">찾기</button>
  				</form>
  			</div>
		</div>
		<br/>
		
		<!-- 이미지슬라이더 및 로그인 회원가입 넣는 div-->
		<div class="row" id="smlAbout">
			<div class="col-lg-2">
				
			</div>
			<div class="col-lg-8">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				  </ol>
					
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox">
				    <div class="item active">
				      <img src="${root }/img/1.jpg" alt="1번그림">
				      <div class="carousel-caption" data-toggle="modal" data-target="#popupJoin">
				        <h3>처음이세요?</h3>
				        <p>여기를 누르시면 간단한 입력으로 팀장이 될 수 있습니다.</p>
				      </div>
				    </div>
				    <div class="item">
				      <img src="${root }/img/2.jpg" alt="2번그림">
				      <div class="carousel-caption" data-toggle="modal" data-target="#popupLogin">
				        <h3>로그인</h3>
				        <p>이미 팀장이신분들은 로그인을 통해 팀관리를 해주세요.</p>
				      </div>
				    </div>
				    <div class="item">
				      <img src="${root }/img/3.jpg" alt="3번그림">
				      <div class="carousel-caption">
				        <h3>쉬운 경기매칭</h3>
				        <p>SML Korea는 간단한 입력으로 상대방을 찾을수 있습니다.</p>
				      </div>
				    </div>
				  </div>
				
				  <!-- Controls -->
				  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				  </a>
				</div>
				...
			</div>
			<div class="col-lg-2">
				
			</div>
		</div>
		<br/>
		
		<!-- 종목별 게시판 이동하는 div -->
		<div class="row" id="smlService">
			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
				      <img src="${root }/img/1.jpg" alt="Soccer">
				      <div class="caption">
				        <h3>축구</h3>
				        <p>축구페이지에서의 리그정보 및 경기일정을 확인하세요</p>
				        <p><a href="${root}/soccer/soccerMain.do" class="btn btn-primary" role="button">이동</a>
				      </div>
				  </div>
 			 </div>
 			 
 			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
				      <img src="${root }/img/2.jpg" alt="Soccer">
				      <div class="caption">
				        <h3>야구</h3>
				        <p>야구페이지에서의 리그정보 및 경기일정을 확인하세요</p>
				        <p><a href="#" class="btn btn-primary" role="button">이동</a>
				      </div>
				  </div>
 			 </div>
 			 
 			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
				      <img src="${root }/img/3.jpg" alt="Soccer">
				      <div class="caption">
				        <h3>풋살</h3>
				        <p>풋살페이지에서의 리그정보 및 경기일정을 확인하세요</p>
				        <p><a href="#" class="btn btn-primary" role="button">이동</a>
				      </div>
				  </div>
 			 </div>
 			 
 			 <div class="col-sm-6 col-md-3">
   				 <div class="thumbnail">
				      <img src="${root }/img/4.jpg" alt="Soccer">
				      <div class="caption">
				        <h3>족구</h3>
				        <p>족구페이지에서의 리그정보 및 경기일정을 확인하세요</p>
				        <p><a href="#" class="btn btn-primary" role="button">이동</a>
				      </div>
				  </div>
 			 </div>
		</div>
		
		<!-- 지도 넣는 div -->
		<div class="row" id="smlMap">
			<div class="col-lg-12">
					<div id="map" style="width:100%;height:400px;"></div>
			</div>
		</div>
		
		<br/><br/>
		
		<!-- 문의넣는 div -->
		<div class="row" id="smlInfo">
			<div class="col-lg-12">
				<div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">도움이 필요하세요?</h2>
                    <hr class="primary">
                    <p>저희 홈페이지에 대한 사용문의 및 건의사항은 아래로 연락주세요!</p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <p>02 - 135 - 2468</p>
                </div>
                <div class="col-lg-4 text-center">
                    <p>smlKorea@smlKorea.com</p>
                </div>
			</div>
		</div>
	</div>
	
	<!-- Modal Join -->
	<form action="${root}/member/registerMember.do" method="post">
	<div class="modal fade" id="popupJoin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">1번째 단계 : 팀정보입력</h4>
		      </div>
		      
		      <div class="modal-body">
		        <div class="row">
				  	<div class="col-sm-12">
					    <div class="row">
					      <div class="col-xs-8 col-sm-3"></div>
					      <div class="col-xs-8 col-sm-6">
					        <div class="input-group">
							      <input type="text" class="form-control" placeholder="팀아이디를 적어주세요." name="teamId">
							      <span class="input-group-btn">
							        <button class="btn btn-default" type="button">중복확인</button>
							      </span>
							 </div><!-- /input-group -->
					      </div>
					    </div>
					    <br/>
					    <div class="row">
					    	<div class="col-xs-8 col-sm-3"></div>
					    	 <div class="col-xs-4 col-sm-6">
					        <input type="password" class="form-control" placeholder="팀 비밀번호를 적어주세요." name="teamPassword">
					        <input type="password" class="form-control" placeholder="비밀번호를 한번더 적어주세요." name="teamPassword2">
					      </div>
					    </div>
					    <br/>
					     <div class="row">
					    	<div class="col-xs-8 col-sm-3"></div>
					    	 <div class="col-xs-4 col-sm-6">
						        <div class="input-group">
							      <input type="text" class="form-control" placeholder="팀이름을 적어주세요." name="teamName">
							      <span class="input-group-btn">
							        <button class="btn btn-default" type="button">중복확인</button>
							      </span>
							    </div><!-- /input-group -->
					      	</div>
					    </div>
					    <br/>
					    
					    <div class="row">
					    	<div class="col-xs-8 col-sm-4"></div>
					    	<div class="col-xs-4 col-sm-6">
					    		
								<label>종목</label>
								<select name="sportType">
									<option></option>
									<option value="축구">축구</option>
									<option value="야구">야구</option>
									<option value="족구">족구</option>
									<option value="풋살">풋살</option>
								</select>
			
								<br/>
								<a>홈구장</a>
								<input type="text" name="homeGround">
								<input type="button" value="지도로 찾기" onclick="searchHomeground(form,'${root}')"> 
								<br/><br/>
								
					    	</div>
					    </div>
					    
					    <div class="row">
					    	<div class="col-xs-8 col-sm-4"></div>
					    	<div class="col-xs-4 col-sm-6">
					        <input class="btn btn-default" type="button" value="다음단계" data-toggle="modal" data-target="#popupJoin2" id="step2">
					         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					      </div>
					    </div>
				  	</div>
				</div>
		      </div>
		    </div>
		  </div>
	</div>
	
	<div class="modal fade" id="popupJoin2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">2번째 단계 : 팀장정보입력</h4>
		      </div>
		      
		      <div class="modal-body">
		        <div class="row">
				  	<div class="col-sm-12">
				  	
					    <div class="row">
					      <div class="col-xs-8 col-sm-3"></div>
					      <div class="col-xs-8 col-sm-6">
					      	<label>이름</label>
					        <input type="text" class="form-control" placeholder="팀장님 이름을 적어주세요" name="memberName">
					        <label>생년월일</label>
					        <input type="text" class="form-control" placeholder="팀장님 생일을 선택해주세요" id="date1" name="memberBirth">
					      </div>
					    </div>
					    <br/>
					    <div class="row">
					    	<div class="col-xs-8 col-sm-3"></div>
					    	 <div class="col-xs-4 col-sm-6">
					    	 	<label>지역:</label>
								<select id="sido" onchange="regionSido('${root }')">
									<option>시/도</option>
								</select>
								<select id="gugun">
									<option>시/구/군</option>
									<option></option>
								</select>		       	  
					      	</div>
					    </div>
					    <br/>
					    <div class="row">
					    	<div class="col-xs-8 col-sm-3"></div>
					    	 <div class="col-xs-4 col-sm-6">
					    	 		<label>이메일:</label>
									<input type="text" name="memberEmail"/>
									<label>연락처:</label>
									<input type="text" name="memberPhone"/>
									"-"는 생략하고 적어주십시요
					    	 </div>
					    </div>
					    <br/>
					    <div class="row">
					    	<div class="col-xs-8 col-sm-3"></div>
					    	 <div class="col-xs-4 col-sm-6">
						    <label>성별</label>
							<span>
								<input type="radio" name="sexValue" value="남"/>남
								<input type="radio" name="sexValue" value="여"/>여
								<input type="hidden" name="memberGender"/>
							</span>
							</div>
						</div>
						
					    <div class="row">
					    	<div class="col-xs-8 col-sm-4"></div>
					    	<div class="col-xs-4 col-sm-6">
					        <input class="btn btn-default" type="submit" value="가입요청" data-toggle="modal">
					        <button type="button" class="btn btn-default" data-dismiss="modal"  id="prevStep1">이전단계로</button>
					      </div>
					    </div>
					 
				  	</div>
				</div>
		      </div>
		    </div>
		  </div>
	</div>
	</form>
	
	<!-- Modal Login-->
	<div class="modal fade" id="popupLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">로그인</h4>
		      </div>
		      
		      <div class="modal-body">
		        <div class="row">
				  	<div class="col-sm-12">
				  	
				  	<form action="${root }/teamPage/login.do" method="POST">
					    <div class="row">
					      <div class="col-xs-8 col-sm-3"></div>
					      <div class="col-xs-8 col-sm-6">
					        <input type="text" class="form-control" placeholder="Input Id" name="id">
					      </div>
					    </div>
					    <br/>
					    <div class="row">
					    	<div class="col-xs-8 col-sm-3"></div>
					    	 <div class="col-xs-4 col-sm-6">
					        <input type="password" class="form-control" placeholder="Input Password" name="password">
					      </div>
					    </div>
					    <br/>
					    <div class="row">
					    	<div class="col-xs-8 col-sm-4"></div>
					    	<div class="col-xs-4 col-sm-6">
					        <input class="btn btn-default" type="submit" value="Login">
					         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					      </div>
					    </div>
					 </form>
					   
				  	</div>
				</div>
		      </div>
		    </div>
		  </div>
	</div>
	
	<!-- Admin Page -->
	<c:if test="${teamGrade == 'AA' }">
		<div>
			<a href="${root}/admin/main.do">관리자페이지</a>
		</div>								
	</c:if>
</body>
</html>