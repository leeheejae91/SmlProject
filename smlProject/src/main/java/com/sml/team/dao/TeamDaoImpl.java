package com.sml.team.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;

@Component
public class TeamDaoImpl implements TeamDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private HashMap<String , String> hMap;
	
	@Override
	public TeamDto login(String id, String password) {
		hMap = new HashMap<String , String>();
		hMap.put("id", id);
		hMap.put("password", password);
		
		return sqlSession.selectOne("login" , hMap);
	}

	@Override
	public List<TeamBoardDto> viewTeamBoard() {
		return sqlSession.selectList("viewTeamBoardList");
	}	
}
