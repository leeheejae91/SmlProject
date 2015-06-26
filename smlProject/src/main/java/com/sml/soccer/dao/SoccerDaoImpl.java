package com.sml.soccer.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.common.dto.CommonBoardDto;
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

	/**
	 * @name : todayMatch
	 * @date : 2015. 6. 26.
	 * @author : 변형린
	 * @description : 금주매치 정보 가져오는 메소드
	 */
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
	
	/**
	 * @name : commonBoardDto
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 축구페이지에 공지사항 가져오는 DAO
	 */
	@Override
	public List<CommonBoardDto> commonBoard(int startRow, int endRow) {
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSession.selectList("dao.SoccerMapper.commonBoard", hMap);
	}
}
