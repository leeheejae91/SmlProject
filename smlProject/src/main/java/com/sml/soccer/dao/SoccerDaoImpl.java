package com.sml.soccer.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.record.dto.RecordDto;
import com.sml.team.dto.TeamDto;

@Component
public class SoccerDaoImpl implements SoccerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * @name : teamSearch
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 팀 검색 메소드
	 */
	@Override
	public int teamSearch(String teamName) {		
		return sqlSession.selectOne("dao.SoccerMapper.teamSearch", teamName);
	}

	@Override
	public List<HashMap<String, Object>> todayMatch() {
		return sqlSession.selectList("dao.SoccerMapper.todayMatch");
	}

	/**
	 * @name : SoccerDaoImpl
	 * @date : 2015. 6. 23.
	 * @author : 이희재
	 * @description : 팀리스트 페이지 이동시 첫 시작으로 전체 팀 리스트 가져오기
	 */
	@Override
	public List<TeamDto> getAllTeamList(String sportType) {
		return sqlSession.selectList("dao.SoccerMapper.getAllTeamSearch", sportType);
	}
}
