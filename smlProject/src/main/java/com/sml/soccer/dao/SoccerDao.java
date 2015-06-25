package com.sml.soccer.dao;

import java.util.HashMap;
import java.util.List;

import com.sml.record.dto.RecordDto;
import com.sml.record.dto.TodayMatchDto;

public interface SoccerDao {
	
	public int teamSearch(String teamName);
	public List<HashMap<String, Object>> todayMatch();
}
