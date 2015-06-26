package com.sml.team.service;

import org.springframework.web.servlet.ModelAndView;

public interface TeamService {
	public void login(ModelAndView mav);
	public void viewSchedule(ModelAndView mav);
	public void viewTeamBoard(ModelAndView mav);
	public void viewRecord(ModelAndView mav);
	public void searchMatching(ModelAndView mav);
	public void registerTeam(ModelAndView mav);
	public void idCheck(ModelAndView mav);
	public void teamIdCheck(ModelAndView mav);
	public void editSchedule(ModelAndView mav);
}
