package com.sml.referee.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.referee.dto.RefereeDto;

@Component
public class RefereeDaoImpl implements RefereeDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int refereeRegister(RefereeDto refereeDto) {
		return sqlSession.insert("dao.RefereeMapper.refereeRegister", refereeDto);
	}

}
