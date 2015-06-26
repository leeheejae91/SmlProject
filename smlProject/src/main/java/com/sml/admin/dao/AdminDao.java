package com.sml.admin.dao;

import java.util.HashMap;
import java.util.List;





import com.sml.member.dto.MemberDto;
import com.sml.referee.dto.RefereeDto;
import com.sml.team.dto.TeamDto;


public interface AdminDao {
	public int getManageTeamCount();
	public List<HashMap<String,Object>> getManageTeam(int startRow,int endRow);
	public int manageTeamDelete(int teamCode);
	public int refereeCount();
	public List<RefereeDto> refereeList(int startRow, int endRow);
	public int refereeDelete(int refereeNumber);
	public int refereeAccept(int refereeNumber);
	public List<RefereeDto> refereeSearch(String refereeName);
}
