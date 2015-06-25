package com.sml.soccer.service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.soccer.dao.SoccerDao;
import com.sml.team.dto.TeamDto;


@Component
public class SoccerServiceImpl implements SoccerService {
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SoccerDao soccerDao;
	
	@Override
	public void soccerMain(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();		
		//HttpServletRequest request=(HttpServletRequest) map.get("request");			
		mav.setViewName("soccer/soccerMain");
	}

	@Override
	public void teamSearch(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();		
		HttpServletRequest request=(HttpServletRequest) map.get("request");		
		
		String teamName=request.getParameter("teamName");
		//logger.info("SoccerServiceImpl/teamSearch/teamName:" + teamName);
		
		int teamCode=soccerDao.teamSearch(teamName);
		
		mav.setViewName("teamPage/teamPageMain");
	}
	
	@Override
	public void soccerRule(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerRule");
	}

	@Override
	public void soccerTeamList(ModelAndView mav) {

		/**
		 * @name : SoccerServiceImpl
		 * @date : 2015. 6. 23.
		 * @author : 이희재
		 * @description : 페이지 눌렀을때 전체 팀 리스트 먼저 가져오는 함수
		 */
		
		Map <String, Object> map=mav.getModel();
		
		List<TeamDto> teamList=soccerDao.getAllTeamList("축구");
		logger.info("size: " + teamList.size());
		mav.addObject("teamList",teamList);
		mav.setViewName("soccer/soccerTeamList");
	}

	@Override
	public void soccerGameScore(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerGameScore");
	}

	@Override
	public void soccerRefereeList(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerRefereeList");
	}

	
	
	
}