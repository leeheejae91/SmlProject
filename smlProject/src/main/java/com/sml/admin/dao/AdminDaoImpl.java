package com.sml.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.league.dto.LeagueDto;
import com.sml.referee.dto.RefereeDto;

@Component
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getManageTeamCount() {
		return sqlSession.selectOne("dao.adminDaoMapper.getManageTeamCount");
	}

	@Override
	public List<HashMap<String, Object>> getManageTeam(int startRow,int endRow){
		HashMap<String,Object> hMap=new HashMap<String,Object>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSession.selectList("dao.adminDaoMapper.getManageTeam",hMap);
	}

	@Override
	public int manageTeamDelete(int teamCode) {
		// TODO Auto-generated method stub
		return sqlSession.delete("dao.adminDaoMapper.manageTeamDelete",teamCode);
	}
	

	/**
	 * @name : refereeCount
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 심판 명수
	 */
	@Override
	public int refereeCount() {
		return sqlSession.selectOne("dao.adminDaoMapper.refereeCount");
	}

	/**
	 * @name : refereeList
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 심판 db에서 리스트로 가져오기
	 */
	@Override
	public List<RefereeDto> refereeList(int startRow, int endRow) {
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSession.selectList("dao.adminDaoMapper.refereeList", hMap);
	}

	/**
	 * @name : refereeDelete
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 심판 삭제 DAO
	 */
	@Override
	public int refereeDelete(int refereeNumber) {
		return sqlSession.delete("dao.adminDaoMapper.refereeDelete", refereeNumber);
	}

	/**
	 * @name : refereeAccept
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 심판 수락 DAO
	 */
	@Override
	public int refereeAccept(int refereeNumber) {
		return sqlSession.update("dao.adminDaoMapper.refereeAccept", refereeNumber);
	}

	/**
	 * @name : refereeSearch
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 심판 검색 중복이름일 경우를 대비 List 사용
	 */
	@Override
	public List<RefereeDto> refereeSearch(String refereeName) {
		return sqlSession.selectList("dao.adminDaoMapper.refereeSearch", refereeName);
	}

	/**
	 * @함수명: createLeague
	 * @작성일: 2015. 6. 26.
	 * @작성자: 정성남
	 * @설명 :
	 */
	@Override
	public int createLeague(LeagueDto leagueDto) {		
		
		return sqlSession.insert("dao.adminDaoMapper.createLeague",leagueDto);
	}

}
