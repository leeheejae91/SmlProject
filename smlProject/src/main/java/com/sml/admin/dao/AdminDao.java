package com.sml.admin.dao;

import java.util.HashMap;
import java.util.List;




import com.sml.member.dto.MemberDto;
import com.sml.team.dto.TeamDto;


public interface AdminDao {
	public int getManageTeamCount();
	public List<HashMap<String,Object>> getManageTeam();
	public int manageTeamDelete(int teamCode);
}
