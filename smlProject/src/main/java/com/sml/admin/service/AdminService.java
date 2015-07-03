package com.sml.admin.service;

import org.springframework.web.servlet.ModelAndView;

public interface AdminService {
	public void manageTeam(ModelAndView mav);
	public void manageTeamDelete(ModelAndView mav);
	public void manageReferee(ModelAndView mav);
	public void refereeDelete(ModelAndView mav);
	public void refereeAccept(ModelAndView mav);
	public void refereeSearch(ModelAndView mav);
	
	public void createLeague(ModelAndView mav);
}
