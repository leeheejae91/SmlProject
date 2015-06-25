package com.sml.record.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecordDaoImpl implements RecordDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
}
