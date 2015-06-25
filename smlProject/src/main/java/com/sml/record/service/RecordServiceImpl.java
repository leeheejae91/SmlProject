package com.sml.record.service;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sml.member.service.MemberServiceImpl;
import com.sml.record.dao.RecordDao;
import com.sml.record.dto.RecordDto;

@Service
public class RecordServiceImpl implements RecordService {
	private Logger logger = Logger.getLogger(MemberServiceImpl.class.getName());
	@Autowired
	private RecordDao recordDao;
	
	@Override
	public void soccerGameScore(ModelAndView mav) {
		HashMap<String, Object> hMap=mav.getModelMap();
		
//		List<RecordDto> recordList=recordDao.get
	}
}
