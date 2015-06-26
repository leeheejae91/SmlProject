package com.sml.admin.controller;

import java.util.logging.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.admin.service.AdminService;



@Controller

public class AdminController {
	final Logger logger=Logger.getLogger(this.getClass().getName());
		
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin/main.do", method=RequestMethod.GET)
	public String callmain(HttpServletRequest request, HttpServletResponse response){
		logger.info("admin 메인페이지호출-------------------------");
		
		return "/admin/main";	
	}
	
	@RequestMapping(value="/admin/manageTeam.do",method=RequestMethod.GET)
	public ModelAndView manageTeam(HttpServletRequest request, HttpServletResponse response){
		logger.info("manageTeam-------------------");
		ModelAndView mav=new ModelAndView();

		mav.addObject("request",request);	
		adminService.manageTeam(mav);		
		return mav;
	}
	
	/**
	 * @함수명: manageTeamDelete
	 * @작성일: 2015. 6. 25.
	 * @작성자: 정성남
	 * @설명 :
	 */
	@RequestMapping(value="/admin/manageTeamDelete.do",method=RequestMethod.GET)
	
	public ModelAndView manageTeamDelete(HttpServletRequest request, HttpServletResponse response){
		logger.info("manageTeamDelete-------------------");
		ModelAndView mav=new ModelAndView();

		mav.addObject("request",request);	
		adminService.manageTeamDelete(mav);		
		return mav;
	}
	
	@RequestMapping(value="/admin/createLeague.do",method=RequestMethod.GET)
	public String createLeague(){
		
		return "admin/createLeague";
	}
	
	
	
}
