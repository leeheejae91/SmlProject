package com.sml.team.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sml.member.dto.MemberDto;
import com.sml.team.dao.TeamDao;
import com.sml.team.dto.MatchingDto;
import com.sml.team.dto.ScheduleDto;
import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;


@Service
public class TeamServiceImpl implements TeamService{
	private Logger logger = Logger.getLogger(TeamServiceImpl.class.getName());
	@Autowired
	private TeamDao dao;
	

	/**
	 * @함수명:registerTeam
	 * @작성일:2015. 6. 23.
	 * @작성자:조영석
	 * @설명문:팀만들기를 위한 서비스메소드
	 */
	@Override
	public void registerTeam(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String teamId=request.getParameter("teamId");
		String teamPassword=request.getParameter("teamPassword");
		String teamName=request.getParameter("teamName");
		String sportType=request.getParameter("sportType");
		String homeGround=request.getParameter("homeGround");
		
		mav.addObject("teamId",teamId);
		mav.addObject("teamPassword",teamPassword);
		mav.addObject("teamName",teamName);
		mav.addObject("sportType",sportType);
		mav.addObject("homeGround", homeGround);
		mav.setViewName("member/registerMember");
		}
	
	/**
	 * @함수명:idCheck
	 * @작성일:2015. 6. 23.
	 * @작성자:조영석
	 * @설명문:아이디 중복체크를 위한 서비스메소드
	 */
	@Override
	public void idCheck(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String teamId=request.getParameter("teamId");
		
		String check=dao.idCheck(teamId);
		
		mav.addObject("teamId",teamId);
		mav.addObject("check",check);
		mav.setViewName("member/idCheck");
		
	}

	/**
	 * @함수명:teamIdCheck
	 * @작성일:2015. 6. 23.
	 * @작성자:조영석
	 * @설명문:팀이름 중복체크를 위한 서비스메소드
	 */
	@Override
	public void teamIdCheck(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String teamName=request.getParameter("teamName");
		
		String teamCheck=dao.teamIdCheck(teamName);
		
		mav.addObject("teamName",teamName);
		mav.addObject("teamCheck",teamCheck);
		mav.setViewName("member/teamIdCheck");
	}
	

	/**
	 * @함수명:login
	 * @작성일:2015. 6. 25.
	 * @작성자:조영석
	 * @설명문:로그인 을위한 서비스 메소드
	 */
	public void login(ModelAndView mav) {
		logger.info("Service Login");
		
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		TeamDto team = dao.login(id,password);
		
		if(team!=null){
			System.out.println("teamteamteamteamteam!!!"+team);
			String teamGrade = team.getTeamGrade();
			String teamId = team.getTeamId();
			String teamName= team.getTeamName();
			
			mav.addObject("teamGrade" , teamGrade);
			mav.addObject("teamId" , teamId);
			mav.addObject("teamName" , teamName);
		}
		
		mav.setViewName("teamPage/loginOk");
	}

	@Override
	/**
	 * 
	 * @함수명 : viewSchedule
	 * @작성일 : 2015. 6. 25.
	 * @작성자 : 이희재
	 * @설명   : 팀 게시판에서 팀 공지사항 보기
	 */
	public void viewTeamBoard(ModelAndView mav) {
		logger.info("Service viewTeamBoard");
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		System.out.println(teamName);
		
		int count=dao.getBoardCount(teamName);
		// 팀 전체 게시물 수
		
		int boardSize=3;
		// 한 블록 당 출력될 게시물 수
		
		int blockSize=2;
		// 한 페이지당 들어갈 블록
		
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int blockCount=count/boardSize + (count%boardSize==0? 0:1);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=startRow+boardSize-1;
		
		List<TeamBoardDto> teamBoardList = dao.viewTeamBoard(teamName,startRow,endRow);
		// 팀 게시물 전체 가져오기
		System.out.println(teamBoardList.size());
		
		mav.addObject("blockCount", blockCount);
		mav.addObject("teamName",teamName);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("currentPage",currentPage);
		mav.addObject("teamBoardList" , teamBoardList);
		mav.setViewName("teamPage/teamBoard");
	}
	
	@Override
	/**
	 * 
	 * @함수명 : viewSchedule
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 팀컨트롤러에서 팀스케쥴보기 요청이 오면 실행되는 메소드
	 */
	public void viewSchedule(ModelAndView mav) {
		logger.info("Service viewSchedule");
		
		List<ScheduleDto> scheduleList = dao.viewSchedule();
		mav.addObject("scheduleList" , scheduleList);
	}

	@Override
	/**
	 * 
	 * @함수명 : viewRecord
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 희재가 기록에 관한 패키지 만든후에 만들기로함 
	 */
	public void viewRecord(ModelAndView mav) {
		logger.info("Service viewRecord");
	}

	

	/**
	 * @함수명:editSchedule
	 * @작성일:2015. 6. 25.
	 * @작성자:조영석
	 * @설명문:일정 입력 데이터처리를 위한 메소드 
	 */
	@Override
	public void editSchedule(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		ScheduleDto scheduleDto=(ScheduleDto)map.get("scheduleDto");
		
		String teamId=request.getParameter("teamId");
		
		scheduleDto.setScheduleDate(new Date());
		
		int check=dao.editSchedule(scheduleDto,teamId);
		String title=scheduleDto.getscheduleTitle();
		
		mav.addObject("check",check);
		mav.addObject("title",title);
		mav.setViewName("teamPage/editScheduleOk");
	}
	
	/**
	 * @name : teamPage
	 * @date : 2015. 6. 25.
	 * @author : 이희재
	 * @description : 팀 페이지로 이동하는 함수
	 * 					팀 명에 따라 페이지가 달라지는 함수
	 */
	@Override
	public void goTeamPage(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		logger.info(request.getParameter("teamName"));
		TeamDto team=dao.getTeamInfo(teamName);
		
		mav.addObject("team",team);
		mav.setViewName("teamPage/teamPageMain");
	}

	/**
	 * @name : teamPage
	 * @date : 2015. 6. 25.
	 * @author : 이희재
	 * @description : 팀 멤버 페이지를 볼 수 있는 함수
	 */
	@Override
	public void viewTeamMemberInfo(ModelAndView mav) {
		logger.info("Service manageTeamMember");
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		
		int count=dao.getTeamMemberCount(teamName);
		// 팀 멤버 전체 수 출력
		
		int boardSize=3;
		// 한 블록 당 출력될 게시물 수
		
		int blockSize=2;
		// 한 페이지당 들어갈 블록
		
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int blockCount=count/boardSize + (count%boardSize==0? 0:1);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=startRow+boardSize-1;
		
		List<MemberDto> teamMemberList = dao.getTeamMemberList(teamName,startRow,endRow);
		
		mav.addObject("blockCount", blockCount);
		mav.addObject("teamName",teamName);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("currentPage",currentPage);
		mav.addObject("teamMemberList" , teamMemberList);
		mav.setViewName("teamPage/teamMemberInfo");
	}

	/**
	 * @name : teamPage
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 게시판 읽기 함수
	 */
	@Override
	public void readTeamBoard(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String teamName=request.getParameter("teamName");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		
		TeamBoardDto board=dao.getBoardDto(boardNumber);
		
		mav.addObject("board",board);
		mav.addObject("teamName", teamName);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("teamPage/readTeamBoard");
	}
	
	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 게시판에서 팀 관리 페이지로 이동
	 */
	public void manageTeamBoard(ModelAndView mav) {
		logger.info("Service viewTeamBoard");
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		
		int count=dao.getBoardCount(teamName);
		// 팀 전체 게시물 수
		
		int boardSize=3;
		// 한 블록 당 출력될 게시물 수
		
		int blockSize=2;
		// 한 페이지당 들어갈 블록
		
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int blockCount=count/boardSize + (count%boardSize==0? 0:1);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=startRow+boardSize-1;
		
		List<TeamBoardDto> teamBoardList = dao.viewTeamBoard(teamName,startRow,endRow);
		// 팀 게시물 전체 가져오기
		
		mav.addObject("blockCount", blockCount);
		mav.addObject("teamName",teamName);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("currentPage",currentPage);
		mav.addObject("teamBoardList" , teamBoardList);
		mav.setViewName("teamPage/manageTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 게시판에서 공지 쓰기
	 */
	@Override
	public void writeTeamBoard(ModelAndView mav) {
		logger.info("Service viewTeamBoard");
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		TeamDto dto=dao.getTeamInfo(teamName);
		
		mav.addObject("writer",dto.getTeamLeaderName());
		mav.addObject("teamName",teamName);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("teamPage/writeTeamBoard");
	}
	
	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 게시판에서 공지 쓰기 완료
	 */
	@Override
	public void writeOkTeamBoard(ModelAndView mav) {
		logger.info("Service writeOkTeamBoard");
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		
		int teamCode=dao.getTeamInfo(teamName).getTeamCode();
		
		TeamBoardDto board=(TeamBoardDto) map.get("teamBoardDto");
		board.setTeamCode(teamCode);
		board.setBoardDate(new Date());
		int value=dao.writeTeamBoard(board);
		System.out.println(value);
		
		mav.addObject("writeValue",value);
		mav.addObject("teamName",teamName);
		mav.addObject("currentPage", currentPage);
		mav.setViewName("teamPage/okTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 게시판에서 공지 삭제
	 */
	
	@Override
	public void deleteTeamBoard(ModelAndView mav) {
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		
		int deleteValue=dao.deleteTeamBoard(boardNumber);
		
		mav.addObject("teamName", teamName);
		mav.addObject("deleteValue", deleteValue);
		mav.addObject("currentPage",currentPage);
		mav.setViewName("teamPage/okTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 게시판에서 공지 수정을 위한 불러오기
	 */
	
	@Override
	public void updateTeamBoard(ModelAndView mav) {
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		
		TeamBoardDto board=dao.getBoardDto(boardNumber);
		mav.addObject("teamName", teamName);
		mav.addObject("board", board);
		mav.addObject("currentPage",currentPage);
		mav.setViewName("teamPage/writeTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 게시판에서 공지 수정완료
	 */
	@Override
	public void updateOkTeamBoard(ModelAndView mav) {
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String teamName=request.getParameter("teamName");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		TeamBoardDto board=(TeamBoardDto) map.get("board");
		board.setBoardDate(new Date());
		
		int updateValue=dao.updateTeamBoard(board);
		mav.addObject("teamName", teamName);
		mav.addObject("updateValue", updateValue);
		mav.addObject("currentPage",currentPage);
		mav.setViewName("teamPage/okTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 6. 26.
	 * @author : 이희재
	 * @description : 팀 멤버 페이지로 이동
	 */
	
	@Override
	public void manageTeamMember(ModelAndView mav) {
		logger.info("Service manageTeamMember");
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		
		int count=dao.getTeamMemberCount(teamName);
		// 팀 멤버 전체 수 출력
		
		int boardSize=3;
		// 한 블록 당 출력될 멤버 수
		
		int blockSize=2;
		// 한 페이지당 들어갈 블록
		
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int blockCount=count/boardSize + (count%boardSize==0? 0:1);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=startRow+boardSize-1;
		
		List<MemberDto> teamMemberList = dao.getTeamMemberList(teamName,startRow,endRow);
		// 팀 멤버 해당 순으로 가져오기
		
		mav.addObject("blockCount", blockCount);
		mav.addObject("teamName",teamName);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("currentPage",currentPage);
		mav.addObject("teamMemberList" , teamMemberList);
		mav.setViewName("teamPage/manageTeamMember");
	}

	
	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 2.
	 * @author : 이희재
	 * @description : 팀 멤버 페이지로 이동
	 */
	
	@Override
	public void addMember(ModelAndView mav) {
		HashMap<String, Object> hMap=mav.getModelMap();
		MemberDto member=(MemberDto) hMap.get("member");
		HttpServletRequest request=(HttpServletRequest) hMap.get("request");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		String teamName=request.getParameter("teamName");
		
		int teamCode=dao.getTeamInfo(teamName).getTeamCode();
		int memberValue=dao.addMember(member,teamCode);
		
		mav.addObject("currentPage",currentPage);
		mav.addObject("memberValue",memberValue);
		mav.setViewName("teamPage/okTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 2.
	 * @author : 이희재
	 * @description : 팀 멤버 삭제 서비스
	 */
	@Override
	public void deleteMember(ModelAndView mav) {
		HashMap<String, Object> hMap=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) hMap.get("request");
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		int memberCode=Integer.parseInt(request.getParameter("memberCode"));
		
		int deleteValue=dao.deleteMember(memberCode);
		
		mav.addObject("currentPage",currentPage);
		mav.addObject("deleteMemberValue",deleteValue);
		mav.setViewName("teamPage/okTeamBoard");
	}

	
	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 2.
	 * @author : 이희재
	 * @description : 팀 기록 출력하기
	 */
	@Override
	public void viewTeamRecord(ModelAndView mav) {
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		
		int count=dao.getRecordCount(teamName);
		// 팀 멤버 전체 수 출력
		
		int boardSize=5;
		// 한 블록 당 출력될 게시물 수
		
		int blockSize=2;
		// 한 페이지당 들어갈 블록
		
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int blockCount=count/boardSize + (count%boardSize==0? 0:1);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=startRow+boardSize-1;
		
		List<HashMap<String, Object>> recordList = dao.recordList(teamName,startRow,endRow);
		
		mav.addObject("blockCount", blockCount);
		mav.addObject("teamName",teamName);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("blockSize", blockSize);
		mav.addObject("currentPage",currentPage);
		mav.addObject("recordList" , recordList);
		mav.setViewName("teamPage/teamRecord");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 2.
	 * @author : 이희재
	 * @description : 멤버 등록을 위한 지역 추출
	 */
	@Override
	public void searchRegion(ModelAndView mav) {
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String sido=null;
		List<String> list=null;
		if(request.getParameter("sido")==null){
			list=dao.getSidoList();
		}else{
			sido=request.getParameter("sido");
			list=dao.getGugunList(sido);
		}
		
		mav.addObject("list",list);
		mav.setViewName("member/regionOption");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 2.
	 * @author : 이희재
	 * @description : 매칭을 위한 페이지 이동
	 */
	
	@Override
	public void matching(ModelAndView mav) {
		HashMap<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		int teamCode=dao.getTeamInfo(teamName).getTeamCode();
		
		MatchingDto matchingDto=dao.getTeamMatchingInfo(teamCode);
		
		if(matchingDto==null){
			String homeGround=dao.getTeamGround(teamCode);
			
			mav.addObject("teamCode", teamCode);
			mav.addObject("homeGround", homeGround);
			mav.addObject("teamName",teamName);
			mav.setViewName("teamPage/matching");
		}else if(matchingDto!=null){
			mav.addObject("matchingDto", matchingDto);
			mav.addObject("teamCode", teamCode);
			mav.addObject("teamName",teamName);
			mav.setViewName("teamPage/matching");
		}
		
	}
	
	
	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 6.
	 * @author : 이희재
	 * @description : 매칭과 동시에 매칭 정보를 매칭 테이블에 입력.
	 */
	@Override
	public void searchMatching(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MatchingDto matchingDto = (MatchingDto) map.get("matchingDto");
		String teamName=request.getParameter("teamName");
		
		matchingDto.setMatchingSport(dao.getTeamInfo(teamName).getSportType());
		matchingDto.setMatchingState("전");
		
		int check = dao.searchMatching(matchingDto);
		mav.addObject("teamName",teamName);
		mav.addObject("matchingCheck" , check);
		mav.setViewName("teamPage/okTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 6.
	 * @author : 이희재
	 * @description : 해당 매칭 정보 삭제
	 */
	@Override
	public void deleteMatching(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String teamName=request.getParameter("teamName");
		int matchingCode=Integer.parseInt(request.getParameter("matchingCode"));
		
		int matchingDelete=dao.deleteMatching(matchingCode);
		
		mav.addObject("teamName", teamName);
		mav.addObject("matchingDelete",matchingDelete);
		mav.setViewName("teamPage/okTeamBoard");
	}

	/**
	 * @name : TeamServiceImpl
	 * @date : 2015. 7. 6.
	 * @author : 이희재
	 * @description : 매칭 정보를 기반으로 서칭하기
	 */
	@Override
	public void searching(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int teamCode=Integer.parseInt(request.getParameter("teamCode"));
		
		mav.addObject("check", 1);
	}
}
