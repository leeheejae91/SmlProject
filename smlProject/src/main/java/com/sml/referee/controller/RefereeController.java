package com.sml.referee.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.referee.dto.RefereeDto;
import com.sml.referee.service.RefereeService;

@Controller
public class RefereeController {
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private RefereeService refereeService;	
	
	@RequestMapping(value="/referee/refereeList.do", method=RequestMethod.GET)
	public ModelAndView refereeList(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/refereeList---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		refereeService.refereeList(mav);
		
		return mav;
	}	
		
	@RequestMapping(value="/referee/registerReferee.do", method=RequestMethod.GET)
	public ModelAndView registerReferee(HttpServletRequest request, HttpServletResponse response){
		logger.info("Controller/registerReferee---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		
		refereeService.registerReferee(mav);
		
		return mav;
	}	
	
	@RequestMapping(value="/referee/registerReferee.do", method=RequestMethod.POST)
	public ModelAndView registerRefereeOk(HttpServletRequest request, HttpServletResponse response, RefereeDto refereeDto){
		logger.info("Controller/registerRefereeOk---------");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("request", request);
		mav.addObject("refereeDto", refereeDto);
		
		refereeService.registerRefereeOk(mav);
		
		return mav;
	}	
}
