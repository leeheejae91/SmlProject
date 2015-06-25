package com.sml.soccer.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.soccer.service.SoccerService;



@Controller
public class SoccerController{
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SoccerService soccerService;	
	
	@RequestMapping(value="/soccer/soccerMain.do", method=RequestMethod.GET)
	public ModelAndView soccerMain(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/soccerMain---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		soccerService.soccerMain(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/soccer/teamSearch.do", method=RequestMethod.GET)
	public ModelAndView teamSearch(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/teamSearch---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		soccerService.teamSearch(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/soccer/soccerRule.do", method=RequestMethod.GET)
	public ModelAndView soccerRule(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/soccerRule---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		soccerService.soccerRule(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/soccer/soccerTeamList.do", method=RequestMethod.GET)
	public ModelAndView soccerTeamList(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/soccerTeamList---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		soccerService.soccerTeamList(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/soccer/soccerGameScore.do", method=RequestMethod.GET)
	public ModelAndView soccerGameScore(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/soccerGameScore---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		soccerService.soccerGameScore(mav);
		
		return mav;
	}
}
