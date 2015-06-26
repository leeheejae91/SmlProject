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
	
	/**
	 * @name : manageReferee
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 
	 */
	@RequestMapping(value="/admin/manageReferee.do",method=RequestMethod.GET)
	public ModelAndView manageReferee(HttpServletRequest request, HttpServletResponse response){
		logger.info("manageReferee-------------------");
		ModelAndView mav=new ModelAndView();

		mav.addObject("request",request);	
		adminService.manageReferee(mav);		
		return mav;
	}
	
	
		/**
		 * @name : manageReferee
		 * @date : 2015. 6. 25.
		 * @author : 변형린
		 * @description : 심판관리자 페이지에서 심판 삭제
		 */
		@RequestMapping(value="/admin/refereeDelete.do",method=RequestMethod.GET)
	public ModelAndView refereeDelete(HttpServletRequest request, HttpServletResponse response){
		logger.info("refereeDelete-------------------");
		ModelAndView mav=new ModelAndView();

		mav.addObject("request",request);	
		adminService.refereeDelete(mav);		
		return mav;
	}
	
		/**
		 * @name : refereeDelete
		 * @date : 2015. 6. 25.
		 * @author : 변형린
		 * @description : 심판 신청 수락
		 */
		@RequestMapping(value="/admin/refereeAccept.do",method=RequestMethod.GET)
		public ModelAndView refereeAccept(HttpServletRequest request, HttpServletResponse response){
			logger.info("refereeAccept-------------------");
			ModelAndView mav=new ModelAndView();

			mav.addObject("request",request);	
			adminService.refereeAccept(mav);		
			return mav;
		}
		
		/**
		 * @name : refereeAccept
		 * @date : 2015. 6. 25.
		 * @author : 변형린
		 * @description : 심판 검색
		 */
		@RequestMapping(value="/admin/refereeSearch.do",method=RequestMethod.GET)
		public ModelAndView refereeSearch(HttpServletRequest request, HttpServletResponse response){
			logger.info("refereeSearch-------------------");
			ModelAndView mav=new ModelAndView();

			mav.addObject("request",request);	
			adminService.refereeSearch(mav);		
			return mav;
		}
	
}
