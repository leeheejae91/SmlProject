package com.sml.team.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.team.dto.MatchingDto;
import com.sml.team.service.TeamService;

@Controller
public class TeamController {
	private Logger logger = Logger.getLogger(TeamController.class.getName());
	@Autowired
	private TeamService service;
	
	/**
	 * 
	 * @함수명 : teamPage
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  스타트페이지에서 메인페이지로 이동하는 메소드
	 */
	@RequestMapping(value="/teamPage.do" , method=RequestMethod.GET)
	public String teamPage(HttpServletRequest request){
		logger.info("TeamController teamPage");
		return "teamPage/teamPageMain";
	}
	
	/**
	 * @함수명 : login
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  로그인창 띄우는 메소드
	 */
	@RequestMapping(value="/login.do" , method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request){
		logger.info("TeamController login");
		ModelAndView mav = new ModelAndView("teamPage/login");
		mav.addObject("request" , request);
		service.login(mav);
		return mav;
	}
	
	/**
	 * 
	 * @함수명 : logout
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 로그아웃하는 메소드
	 */
	@RequestMapping(value="/logout.do" , method=RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request){
		logger.info("TeamController logout");
		ModelAndView mav = new ModelAndView("teamPage/logout");
		return mav;
	}
		
	/**
	 * 
	 * @함수명 : viewTeamBoard
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  팀게시판 보는 메소드 (팀장이랑 비회원 구분은  JSP페이지에서 JSTL로 구분 해야할듯)
	 */
	@RequestMapping(value="/viewTeamBoard.do" , method=RequestMethod.GET)
	public ModelAndView viewTeamBoard(){
		logger.info("TeamController viewTeamBoard");
		ModelAndView mav = new ModelAndView("teamPage/teamBoard");
		
		service.viewTeamBoard(mav);
		return mav;
	}
	
	/**
	 * @함수명 : viewSchedule
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  팀스케쥴 보는 메소드 (팀장이랑 비회원 구분은 JSP페이지에서 JSTL로 구분 해야할듯)
	 */
	@RequestMapping(value="/viewSchedule.do" , method=RequestMethod.GET)
	public ModelAndView viewSchedule(){
		logger.info("TeamController viewSchedule");
		ModelAndView mav = new ModelAndView("teamPage/teamSchedule");
		
		service.viewSchedule(mav);
		return mav;
	}
	
	/**
	 * 
	 * @함수명 : gameRecord
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 팀페이지에서 경기기록을 보는 메소드
	 */
	@RequestMapping(value="/viewRecord.do", method=RequestMethod.GET)
	public ModelAndView viewRecord(){
		logger.info("TeamController viewRecord");
		ModelAndView mav = new ModelAndView("teamPage/teamRecord");
		
		service.viewRecord(mav);
		return mav;
	}
		
	/**
	 * 
	 * @함수명 : startMatching
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  매칭관리 페이지이동하는 메소드
	 */
	@RequestMapping(value="/startMatching.do" , method=RequestMethod.GET)
	public String startMatching(){
		logger.info("TeamController startMatching");
		return "teamPage/matching";
	}
	
	/**
	 * 
	 * @함수명 : searchMatching
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  JSP페이지에서 매칭시작누르면 값을 받아와서 서비스클래스에 값을 보내는 메소드
	 */
	@RequestMapping(value="/searchMatching.do" , method=RequestMethod.POST)
	public ModelAndView searchMatching(HttpServletRequest request , MatchingDto matchingDto){
		logger.info("TeamController searchMatching");
		ModelAndView mav = new ModelAndView("teamPage/teamPageMain");
		mav.addObject("request" , request);
		mav.addObject("matchingDto" , matchingDto);
		
		service.searchMatching(mav);
		return mav;
	}
}
