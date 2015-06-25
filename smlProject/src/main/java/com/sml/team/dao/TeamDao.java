package com.sml.team.dao;

import java.util.List;

import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;


public interface TeamDao {
	public TeamDto login(String id, String password);

	public List<TeamBoardDto> viewTeamBoard();
}
