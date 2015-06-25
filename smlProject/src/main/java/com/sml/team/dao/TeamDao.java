package com.sml.team.dao;

import java.util.List;

import com.sml.team.dto.MatchingDto;
import com.sml.team.dto.ScheduleDto;
import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;


public interface TeamDao {
	/**
	 * 
	 * @함수명 : login
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  
	 */
	public TeamDto login(String id, String password);

	public List<TeamBoardDto> viewTeamBoard();

	public List<ScheduleDto> viewSchedule();

	public int searchMatching(MatchingDto matchingDto);
}
