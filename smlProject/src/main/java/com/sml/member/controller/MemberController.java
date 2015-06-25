package com.sml.member.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.member.service.MemberService;

@Controller
public class MemberController {
	private Logger logger = Logger.getLogger(MemberController.class.getName());
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/teamMemberInfo.do" , method=RequestMethod.GET)
	public ModelAndView teamMemberInfo(){
		logger.info("MemberController teamMemberInfo");
		ModelAndView mav = new ModelAndView();
		service.teamMemberInfo(mav);
		return mav;
	}
}
