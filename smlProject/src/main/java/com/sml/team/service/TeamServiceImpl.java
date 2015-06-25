package com.sml.team.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sml.team.dao.TeamDao;
import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;

@Service
public class TeamServiceImpl implements TeamService{
	private Logger logger = Logger.getLogger(TeamServiceImpl.class.getName());
	@Autowired
	private TeamDao dao;
	
	@Override
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
	public void viewSchedule(ModelAndView mav) {
		logger.info("Service viewSchedule");
	}

	@Override
	public void viewTeamBoard(ModelAndView mav) {
		logger.info("Service viewTeamBoard");
		List<TeamBoardDto> teamBoardList = dao.viewTeamBoard();
		mav.addObject("teamBoardList" , teamBoardList);
		mav.setViewName("teamPage/teamBoard");
	}
	
}
