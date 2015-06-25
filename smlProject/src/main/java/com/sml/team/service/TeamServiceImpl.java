package com.sml.team.service;

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
	
	@Override
	/**
	 * 
	 * @함수명 : login
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 팀컨트롤러에서 로그인 요청이 오면 실행되는 메소드
	 */
	public void login(ModelAndView mav) {
		logger.info("Service Login");
		
		Map<String , Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		TeamDto team = dao.login(id,password);
		String teamGrade = team.getTeamGrade();
		String teamLeaderName = team.getTeamLeaderName();
		
		mav.addObject("teamGrade" , teamGrade);
		mav.addObject("teamLeaderName" , teamLeaderName);
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
	
	
}
