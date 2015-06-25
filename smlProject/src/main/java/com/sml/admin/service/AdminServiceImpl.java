package com.sml.admin.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.admin.dao.AdminDao;
import com.sml.member.dto.MemberDto;
import com.sml.team.dto.TeamDto;

@Component
public class AdminServiceImpl implements AdminService{
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public void manageTeam(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null) pageNumber="1";
		
		int boardSize=5;		
		int currentPage=Integer.parseInt(pageNumber);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=currentPage*boardSize;
		
		int count=adminDao.getManageTeamCount();
		logger.info("count:"+count);
		logger.info("currentPage"+currentPage);
		logger.info("startRow"+startRow);
		logger.info("endRow"+endRow);		
		
		List<TeamDto> manageTeamList=null;	
		List<MemberDto> manageMemberList=null;	
		HashMap<String,Object> manageMap=new HashMap<String,Object>();
		manageMap.put("manageTeamList", manageTeamList);
		manageMap.put("manageMemberList", manageMemberList);
		manageMap.put("startRow", startRow);
		manageMap.put("endRow", endRow);
		
		List<HashMap<String,Object>> containerList=null;
		containerList.add(manageMap);
		
		containerList=adminDao.getManageTeam();
			
		mav.addObject("containerList",containerList);
		mav.addObject("manageMap",manageMap);		
		mav.addObject("count",count);		
		mav.addObject("boardSize",boardSize);
		mav.addObject("currentPage",currentPage);
		mav.setViewName("admin/manageTeam");
	}

		
		
		
	

}
