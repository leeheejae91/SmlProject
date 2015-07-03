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
import com.sml.common.dto.CommonBoardDto;
import com.sml.league.dto.LeagueDto;



/**
 * @함수명: manageTeamDelete
 * @작성일: 2015. 6. 25.
 * @작성자: 정성남
 * @설명 : 팀관리 페이지호출
 */
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
	 * @설명 : 팀관리 페이지에서 팀 삭제 기능
	 */
	@RequestMapping(value="/admin/manageTeamDelete.do",method=RequestMethod.GET)
	
	public ModelAndView manageTeamDelete(HttpServletRequest request, HttpServletResponse response){
		logger.info("manageTeamDelete-------------------");
		ModelAndView mav=new ModelAndView();

		mav.addObject("request",request);	
		adminService.manageTeamDelete(mav);		
		return mav;
	}
	
	
	/**
	 * @name : manageReferee
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 심판 관리 페이지
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
		
		@RequestMapping(value="/admin/createLeague.do",method=RequestMethod.GET)
		public String createLeague(){
			
			return "admin/createLeague";
		}
		
		/**
		 * @함수명: manageTeamDelete
		 * @작성일: 2015. 6. 25.
		 * @작성자: 정성남
		 * @설명 :
		 */
		@RequestMapping(value="/admin/createLeague.do",method=RequestMethod.POST)
		public ModelAndView createLeague(HttpServletRequest request , LeagueDto leagueDto){
			ModelAndView mav = new ModelAndView();
			logger.info("createLeague1-------------------");
			mav.addObject("request" , request);
			mav.addObject("leagueDto" , leagueDto);
			
			adminService.createLeague(mav);
			
			return mav;
		}
		
		
		/**
		 * @함수명: manageLeague
		 * @작성일: 2015. 7. 02
		 * @작성자: 정성남
		 * @설명 : 리그관리 페이지호출
		 */
		
		@RequestMapping(value="/admin/manageLeague.do",method=RequestMethod.GET)
		public ModelAndView manageLeague(HttpServletRequest request , LeagueDto leagueDto){
			logger.info("manageLeague-----------");
			ModelAndView mav=new ModelAndView();
			mav.addObject("request",request);
			mav.addObject("leagueDto",leagueDto);
			
			adminService.manageLeague(mav);
			
			return mav;
		}
		
		/**
		 * @함수명: manageTeamDelete
		 * @작성일: 2015. 7. 02
		 * @작성자: 정성남
		 * @설명 : 리그관리 삭제 기능
		 */
		
		@RequestMapping(value="/admin/leagueDelete.do",method=RequestMethod.GET)
		
		public ModelAndView leagueDelete(HttpServletRequest request, HttpServletResponse response){
			logger.info("leagueDelete-------------------");
			ModelAndView mav=new ModelAndView();

			mav.addObject("request",request);	
			adminService.leagueDelete(mav);		
			return mav;
		}
		
		/**
		 * @함수명: leagueInfo
		 * @작성일: 2015. 7. 02
		 * @작성자: 정성남
		 * @설명 : 리그관리 읽기 기능
		 */
		
		@RequestMapping(value="/admin/leagueInfo.do",method=RequestMethod.GET)
		public ModelAndView leagueInfo(HttpServletRequest request, HttpServletResponse response){
			logger.info("leagueInfo-------------------");
			ModelAndView mav=new ModelAndView();
			mav.addObject("request",request);			
			adminService.leagueInfo(mav);		
			
			return mav;
		}
		
		/**
		 * @함수명: leagueUpdate
		 * @작성일: 2015. 7. 02
		 * @작성자: 정성남
		 * @설명 : 리그관리 삭제 기능
		 */
		
		
		@RequestMapping(value="/admin/leagueUpdate.do",method=RequestMethod.GET)
		public ModelAndView leagueUpdate(HttpServletRequest request, HttpServletResponse response,LeagueDto leagueDto){
			logger.info("leagueUpdate-----------");
			ModelAndView mav=new ModelAndView();
			mav.addObject("request",request);
			mav.addObject("leagueDto",leagueDto);
			adminService.leagueUpdate(mav);
			
			return mav;
		}
		
		/**
		 * @함수명: leagueUpdateOk
		 * @작성일: 2015. 7. 02
		 * @작성자: 정성남
		 * @설명 : 리그관리 삭제 기능
		 */
		
		
		@RequestMapping(value="/admin/leagueUpdate.do",method=RequestMethod.POST)
		public ModelAndView leagueUpdateOk(HttpServletRequest request, LeagueDto leagueDto){
			logger.info("leagueUpdateOk-----------");
			ModelAndView mav=new ModelAndView();
			mav.addObject("request",request);
			mav.addObject("leagueDto",leagueDto);

			adminService.leagueUpdateOk(mav);
			return mav;
		}		
		
	
}
