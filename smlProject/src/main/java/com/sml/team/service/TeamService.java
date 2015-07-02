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
	public void goTeamPage(ModelAndView mav);
	public void viewTeamMemberInfo(ModelAndView mav);
	public void readTeamBoard(ModelAndView mav);
	public void manageTeamBoard(ModelAndView mav);
	public void writeTeamBoard(ModelAndView mav);
	public void writeOkTeamBoard(ModelAndView mav);
	public void deleteTeamBoard(ModelAndView mav);
	public void updateTeamBoard(ModelAndView mav);
	public void updateOkTeamBoard(ModelAndView mav);
	public void manageTeamMember(ModelAndView mav);
	public void addMember(ModelAndView mav);
	public void deleteMember(ModelAndView mav);
	public void viewTeamRecord(ModelAndView mav);
	
}
