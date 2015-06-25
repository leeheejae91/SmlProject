package com.sml.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sml.member.dto.MemberDto;

@Component
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberDto> teamMemberInfo() {
		return sqlSession.selectList("teamMemberList");
	}

}
