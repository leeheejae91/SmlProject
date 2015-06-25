package com.sml.team.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.team.service.TeamService;

@Controller
public class TeamController {
	private Logger logger = Logger.getLogger(TeamController.class.getName());
	@Autowired
	private TeamService service;
	
	@RequestMapping(value="/teamPage.do" , method=RequestMethod.GET)
	public String teamPage(HttpServletRequest request){
		logger.info("Controller teamPage");
		return "teamPage/teamPageMain";
	}
	
	@RequestMapping(value="/login.do" , method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request){
		logger.info("Controller login");
		ModelAndView mav = new ModelAndView();
		mav.addObject("request" , request);
		service.login(mav);
		return mav;
	}
	
	@RequestMapping(value="/logout.do" , method=RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request){
		logger.info("Controller logout");
		ModelAndView mav = new ModelAndView("teamPage/logout");
		return mav;
	}
		
	@RequestMapping(value="/viewSchedule.do" , method=RequestMethod.GET)
	public ModelAndView viewSchedule(){
		logger.info("Controller viewSchedule");
		ModelAndView mav = new ModelAndView();
		
		service.viewSchedule(mav);
		return null;
	}
	
	@RequestMapping(value="/viewTeamBoard.do" , method=RequestMethod.GET)
	public ModelAndView viewTeamBoard(){
		logger.info("Controller viewTeamBoard");
		ModelAndView mav = new ModelAndView();
		
		service.viewTeamBoard(mav);
		return null;
	}
	
	@RequestMapping(value="/manageTeamMember.do" , method=RequestMethod.GET)
	public ModelAndView manageTeamMember(){
		logger.info("Controller manageTeamMember");
		
		return null;
	}
	@RequestMapping(value="/manageTeamSchedule.do" , method=RequestMethod.GET)
	public ModelAndView manageTeamSchedule(){
		logger.info("Controller manageTeamSchedule");
		
		return null;
	}
	@RequestMapping(value="/startMatching.do" , method=RequestMethod.GET)
	public ModelAndView startMatching(){
		logger.info("Controller startMatching");
		
		return null;
	}
}
