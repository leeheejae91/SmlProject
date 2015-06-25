package com.sml.referee.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.referee.dao.RefereeDao;
import com.sml.referee.dto.RefereeDto;

@Component
public class RefereeServiceImpl implements RefereeService{

	@Autowired
	private RefereeDao refereeDao;
	
	@Override
	public void refereeList(ModelAndView mav) {			
		mav.setViewName("referee/refereeList");
	}

	@Override
	public void registerReferee(ModelAndView mav) {
		mav.setViewName("referee/refereeRegister");
		
	}

	@Override
	public void registerRefereeOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map <String, Object> map= mav.getModelMap();
		RefereeDto refereeDto=(RefereeDto)map.get("refereeDto");
		
		refereeDto.setRefereeYes(0);//default=0; 수락거부
		int check=refereeDao.refereeRegister(refereeDto);
		
		mav.addObject("check", check);
		mav.setViewName("referee/refereeRegisterOk");
	}

}
