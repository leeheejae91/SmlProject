package com.sml.admin.dao;

import java.util.HashMap;
import java.util.List;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;







import com.sml.member.dto.MemberDto;
import com.sml.team.dto.TeamDto;

@Component
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getManageTeamCount() {
		
		return sqlSession.selectOne("dao.adminDaoMapper.getManageTeamCount");
	}

	@Override
	public List<HashMap<String, Object>> getManageTeam() {
		
		return sqlSession.selectList("dao.adminDaoMapper.getManageTeam");
	}

	@Override
	public int manageTeamDelete(int teamCode) {
		// TODO Auto-generated method stub
		return sqlSession.delete("dao.adminDaoMapper.manageTeamDelete",teamCode);
	}


}
