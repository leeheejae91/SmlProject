package com.sml.referee.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.referee.dto.RefereeDto;

@Component
public class RefereeDaoImpl implements RefereeDao{

	@Autowired
	private SqlSession sqlSession;

	/**
	 * @name : refereeRegister
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 심판등록 신청하는 DAO
	 */
	@Override
	public int refereeRegister(RefereeDto refereeDto) {
		return sqlSession.insert("dao.RefereeMapper.refereeRegister", refereeDto);
	}

	@Override
	public int refereeCount() {
		return sqlSession.selectOne("dao.RefereeMapper.refereeCount");
	}

	@Override
	public List<RefereeDto> refereeList(int startRow, int endRow) {
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		hMap.put("startRow", startRow);
		hMap.put("endRow", endRow);
		return sqlSession.selectList("dao.RefereeMapper.refereeList", hMap);
	}

}
