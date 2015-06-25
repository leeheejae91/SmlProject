package com.sml.admin.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.common.service.CommonService;
@Controller
public class AdminController {
	final Logger logger=Logger.getLogger(this.getClass().getName());
		
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/admin/main.do", method=RequestMethod.GET)
	public String callmain(HttpServletRequest request, HttpServletResponse response){
		logger.info("admin 메인페이지호출-------------------------");
		
		return "/admin/main";	
	}
	
	@RequestMapping(value="/admin/manageTeam.do",method=RequestMethod.GET)
	public ModelAndView manageTeam(HttpServletRequest request, HttpServletResponse response){
		logger.info("팀관리 컨트롤러------------");
		ModelAndView mav=new ModelAndView();
		
		//commonService.manageTeam(mav);
		return null;
	}
	
	
	
}
