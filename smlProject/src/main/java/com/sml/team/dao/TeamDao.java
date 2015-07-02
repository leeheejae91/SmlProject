package com.sml.team.dao;

import java.util.List;

import com.sml.member.dto.MemberDto;
import com.sml.team.dto.MatchingDto;
import com.sml.team.dto.ScheduleDto;
import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;


public interface TeamDao {
	public String idCheck(String teamId);
	public String teamIdCheck(String teamName);
	public TeamDto login(String id, String password);
	public List<TeamBoardDto> viewTeamBoard(String teamName, int startRow, int endRow);
	public List<ScheduleDto> viewSchedule();
	public int searchMatching(MatchingDto matchingDto);
	public int editSchedule(ScheduleDto scheduleDto,String teamId);
	public TeamDto getTeamInfo(String teamName);
	public List<MemberDto> getTeamMemberList(String teamName,int startRow, int endRow);
	public int getBoardCount(String teamName);
	public TeamBoardDto getBoardDto(int boardNumber);
	public int writeTeamBoard(TeamBoardDto board);
	public int deleteTeamBoard(int boardNumber);
	public int updateTeamBoard(TeamBoardDto board);
	public int getTeamMemberCount(String name);
	public int addMember(MemberDto member,int teamCode);
	public int deleteMember(int memberCode);
}
