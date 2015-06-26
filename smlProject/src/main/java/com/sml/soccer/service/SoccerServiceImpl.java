package com.sml.soccer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.record.dto.RecordDto;
import com.sml.soccer.dao.SoccerDao;
import com.sml.team.dto.TeamDto;

@Component
public class SoccerServiceImpl implements SoccerService {
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SoccerDao soccerDao;
	
	/**
	 * @name : soccerMain
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 축구 메인 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerMain(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();		
		//HttpServletRequest request=(HttpServletRequest) map.get("request");	
		
		List<HashMap<String, Object>> todayMatchList=soccerDao.todayMatch();
		
		mav.addObject("todayMatchList", todayMatchList);
		mav.setViewName("soccer/soccerMain");
	}

	/**
	 * @name : teamSearch
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 팀 검색 메소드
	 */
	@Override
	public void teamSearch(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();		
		HttpServletRequest request=(HttpServletRequest) map.get("request");		
		
		String teamName=request.getParameter("teamName");
		//logger.info("SoccerServiceImpl/teamSearch/teamName:" + teamName);
		
		int teamCode=soccerDao.teamSearch(teamName);
		
		mav.setViewName("teamPage/teamPageMain");
	}
	
	/**
	 * @name : soccerRule
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 축구 경기 규칙 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerRule(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerRule");
	}

	/**
	 * @name : SoccerServiceImpl
	 * @date : 2015. 6. 23.
	 * @author : 이희재
	 * @description : 페이지 눌렀을때 전체 팀 리스트 먼저 가져오는 함수
	 */
	@Override
	public void soccerTeamList(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		
		List<TeamDto> teamList=soccerDao.getAllTeamList("축구");
		logger.info("size: " + teamList.size());
		mav.addObject("teamList",teamList);
		mav.setViewName("soccer/soccerTeamList");
	}

	/**
	 * @name : soccerGameScore
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 축구 경기 기록 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerGameScore(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerGameScore");
	}

	/**
	 * @name : soccerRefereeList
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 심판현황 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerRefereeList(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerRefereeList");
	}

	
	
	
}