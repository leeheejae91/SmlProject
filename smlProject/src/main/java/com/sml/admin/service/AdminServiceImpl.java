package com.sml.admin.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.admin.dao.AdminDao;
@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao admindao;
	
	@Override
	public void manageTeam(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		
		
		
	}

}
