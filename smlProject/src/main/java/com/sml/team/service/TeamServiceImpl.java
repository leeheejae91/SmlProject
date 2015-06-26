package com.sml.team.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
		
		mav.addObject("teamId",teamId);
		mav.addObject("teamPassword",teamPassword);
		mav.addObject("teamName",teamName);
		mav.addObject("sportType",sportType);
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
		System.out.println("teamteamteamteamteam!!!"+team);
		String teamGrade = team.getTeamGrade();
		String teamId = team.getTeamId();
		
		mav.addObject("teamGrade" , teamGrade);
		mav.addObject("teamId" , teamId);
		mav.setViewName("teamPage/loginOk");
	}

	@Override
	/**
	 * 
	 * @함수명 : viewTeamBoard
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 팀컨트롤러에서 팀공지사항 보기 요청이 오면 실행되는 메소드 
	 */
	public void viewTeamBoard(ModelAndView mav) {
		logger.info("Service viewTeamBoard");
		List<TeamBoardDto> teamBoardList = dao.viewTeamBoard();
		mav.addObject("teamBoardList" , teamBoardList);
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

	@Override
	/**
	 * 
	 * @함수명 : searchMatching
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  매칭시작을 누르면 데이터값을 처리하는 메소드
	 */
	public void searchMatching(ModelAndView mav) {
		Map<String , Object> map = mav.getModelMap();
		//HttpServletRequest request = (HttpServletRequest) map.get("request");
		MatchingDto matchingDto = (MatchingDto) map.get("matchingDto");
		
		int check = dao.searchMatching(matchingDto);
		mav.addObject("check" , check);
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
		
		System.out.println("teamIdteamIdteamId:"+teamId);
		scheduleDto.setScheduleDate(new Date());
		
		int check=dao.editSchedule(scheduleDto,teamId);
		
	}
}
