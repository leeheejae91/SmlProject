package com.sml.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.sml.common.dto.CommonBoardDto;
import com.sml.league.dto.LeagueDto;
import com.sml.referee.dto.RefereeDto;


public interface AdminDao {
	public int getManageTeamCount();
	public List<HashMap<String,Object>> getManageTeam(int startRow,int endRow);
	public int manageTeamDelete(int teamCode);
	public int refereeCount();
	public List<RefereeDto> refereeList(int startRow, int endRow);
	public int refereeDelete(int refereeNumber);
	public int refereeAccept(int refereeNumber);
	public List<RefereeDto> refereeSearch(String refereeName);
	public int createLeague(LeagueDto leagueDto);
	public int getManageLeagueCount();
	public List<LeagueDto> manageLeagueList(int startRow,int endRow);
	public int leagueDelete(int leagueCode);
	public LeagueDto leagueInfo(int leagueCode);
	public LeagueDto leagueUpdate(int leagueCode);
	public int leagueUpdateOk(LeagueDto leagueDto);
}
