package com.sml.member.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sml.member.dao.MemberDao;
import com.sml.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	private Logger logger = Logger.getLogger(MemberServiceImpl.class.getName());
	@Autowired
	private MemberDao dao;
	
	@Override
	public void teamMemberInfo(ModelAndView mav) {	
		logger.info("MemberService teamMemberInfo");
		
		List<MemberDto> member = dao.teamMemberInfo();
		mav.addObject("member" , member);
	}
	
}
