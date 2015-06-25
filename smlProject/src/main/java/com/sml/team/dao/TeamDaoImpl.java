package com.sml.team.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.member.dto.MemberDto;
import com.sml.team.dto.MatchingDto;
import com.sml.team.dto.ScheduleDto;
import com.sml.team.dto.TeamBoardDto;
import com.sml.team.dto.TeamDto;

@Component
public class TeamDaoImpl implements TeamDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private HashMap<String , Object> hMap;
	
	/**
	 * @함수명:idCheck
	 * @작성일:2015. 6. 23.
	 * @작성자:조영석
	 * @설명문:아이디 중복체크를 위한 데이터베이스연결
	 */
	@Override
	public String idCheck(String teamId) {
		
		return sqlSession.selectOne("team.dao.TeamMapper.idCheckSelect",teamId);
	}

	/**
	 * @함수명:teamIdCheck
	 * @작성일:2015. 6. 23.
	 * @작성자:조영석
	 * @설명문:팀원명 중복체크를 위한 데이터베이스연결
	 */
	@Override
	public String teamIdCheck(String teamName) {

		return sqlSession.selectOne("team.dao.TeamMapper.teamIdCheck",teamName);
	}

	@Override
	/**
	 * 
	 * @함수명 : login
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   :  서비스에서 요청받은 값을 데이터베이스에 연결시켜 값을 반환받는 메소드
	 */
	public TeamDto login(String id, String password) {
//		System.out.println("id"+id+"password"+password);
		
		hMap = new HashMap<String , Object>();
		
		hMap.put("id", id);
		hMap.put("password", password);

		TeamDto srt=sqlSession.selectOne("team.dao.TeamMapper.loginOk", hMap);
				
		System.out.println("srt : "+srt.getTeamName());
		return srt;
	}

	@Override
	/**
	 * 
	 * @함수명 : viewTeamBoard
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 서비스에서 요청받은 값을 데이터베이스에 연결시켜 팀게시판 목록 리스트를 반환 받는 메소드
	 */
	public List<TeamBoardDto> viewTeamBoard(String teamName,int startRow, int endRow) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("teamName", teamName);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		return sqlSession.selectList("team.dao.TeamMapper.viewTeamBoardList",map);
	}

	@Override
	/**
	 * 
	 * @함수명 : viewSchedule
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 서비스에서 요청받은 값을 데이터베이스에서 연결해서 스케쥴 값들을 반환 받는 메소드
	 */
	public List<ScheduleDto> viewSchedule() {
		return sqlSession.selectList("team.dao.TeamMapper.teamScheduleList");
	}

	@Override
	/**
	 * 
	 * @함수명 : searchMatching
	 * @작성일 : 2015. 6. 23.
	 * @작성자 : 이한빈
	 * @설명   : 서비스에서 요청받은 값을 데이터베이스에 연결해서 값을 삽입하는 메소드
	 */
	public int searchMatching(MatchingDto matchingDto) {
		return sqlSession.insert("team.dao.TeamMapper.searchMatching" , matchingDto);
	}


	/**
	 * @name : TeamDaoImpl
	 * @date : 2015. 6. 25.
	 * @author : 이희재
	 * @description : 팀 정보를 갖고 오기 위한 함수
	 */
	@Override
	public TeamDto getTeamInfo(String teamName) {
		return sqlSession.selectOne("team.dao.TeamMapper.getTeamInfo",teamName);
	}

	/**
	 * @name : TeamDaoImpl
	 * @date : 2015. 6. 25.
	 * @author : 이희재
	 * @description : 팀 멤버 리스트를 갖고 오기 위한 함수
	 */
	@Override
	public List<MemberDto> getTeamMemberList(String teamName) {
		
		return sqlSession.selectList("team.dao.TeamMapper.getTeamMemberList",teamName);
	}

	
	/**
	 * @name : TeamDaoImpl
	 * @date : 2015. 6. 25.
	 * @author : 이희재
	 * @description : 페이징 기법을 위한 전체 게시물 수 출력
	 */
	@Override
	public int getBoardCount(String teamName) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("team.dao.TeamMapper.getBoardCount",teamName);
	}
	
	
	
}
