package com.sml.team.dao;

import java.util.List;

import com.sml.team.dto.MatchingDto;
import com.sml.team.dto.ScheduleDto;
import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;


public interface TeamDao {
	
	public String idCheck(String teamId);
	
	public String teamIdCheck(String teamName);
	
	public TeamDto login(String id, String password);

	public List<TeamBoardDto> viewTeamBoard();

	public List<ScheduleDto> viewSchedule();

	public int searchMatching(MatchingDto matchingDto);

}
