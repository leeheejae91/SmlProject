package com.sml.soccer.dao;

import java.util.HashMap;
import java.util.List;

import com.sml.team.dto.TeamDto;

public interface SoccerDao {
	public int teamSearch(String teamName);
	public List<HashMap<String, Object>> todayMatch();
	public List<TeamDto> getAllTeamList(String sportType);
}
