package com.sml.soccer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.common.dao.CommonDao;
import com.sml.common.dto.CommonBoardDto;
import com.sml.record.dto.RecordDto;
import com.sml.referee.dto.RefereeDto;
import com.sml.soccer.dao.SoccerDao;
import com.sml.team.dto.TeamDto;

@Component
public class SoccerServiceImpl implements SoccerService {
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SoccerDao soccerDao;
	
	@Autowired
	private CommonDao commonDao;
	
	//종목 공지게시판 코드
	private int sportCode=0;
	
	/**
	 * @name : soccerMain
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 축구 메인 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerMain(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();		
		HttpServletRequest request=(HttpServletRequest) map.get("request");	
		
		//금주매치
				List<HashMap<String, Object>> todayMatchList=soccerDao.todayMatch();
				
		//공통공지사항				
				
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null)pageNumber="1";
		
		int boardSize=6;
		int currentPage=Integer.parseInt(pageNumber);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=currentPage*boardSize;
		
		int count=commonDao.getCommonBoardCount();
		logger.info("count:" + count);
		
		
		List<CommonBoardDto> commonBoardList=null;
		if(count>0){
			commonBoardList=soccerDao.commonBoard(startRow, endRow, sportCode);
		}
		//logger.info("boardSize:" + commonBoardList.size());
					
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);		
		mav.addObject("count", count);
		mav.addObject("commonBoardList", commonBoardList);
		mav.addObject("todayMatchList", todayMatchList);
		mav.setViewName("soccer/soccerMain");
	}

	/**
	 * @name : teamSearch
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 팀 검색 메소드
	 */
	@Override
	public void teamSearch(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();		
		HttpServletRequest request=(HttpServletRequest) map.get("request");		
		
		String teamName=request.getParameter("teamName");
		//logger.info("SoccerServiceImpl/teamSearch/teamName:" + teamName);
		
		int teamCode=soccerDao.teamSearch(teamName);
		
		mav.setViewName("teamPage/teamPageMain");
	}
	
	/**
	 * @name : soccerRule
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 축구 경기 규칙 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerRule(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerRule");
	}

	/**
	 * @name : SoccerServiceImpl
	 * @date : 2015. 6. 23.
	 * @author : 이희재
	 * @description : 페이지 눌렀을때 전체 팀 리스트 먼저 가져오는 함수
	 */
	@Override
	public void soccerTeamList(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		
		List<TeamDto> teamList=soccerDao.getAllTeamList("축구");
		logger.info("size: " + teamList.size());
		mav.addObject("teamList",teamList);
		mav.setViewName("soccer/soccerTeamList");
	}

	/**
	 * @name : soccerGameScore
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 축구 경기 기록 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerGameScore(ModelAndView mav) {
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerGameScore");
	}

	/**
	 * @name : soccerRefereeList
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 심판현황 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void soccerRefereeList(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map <String, Object> map=mav.getModel();
		mav.setViewName("soccer/soccerRefereeList");
	}


	/**
	 * @name : commonBoard
	 * @date : 2015. 6. 25.
	 * @author : 변형린
	 * @description : 공지사항게시판으로 이동하는 Service 메소드
	 */
	@Override
	public void commonBoard(ModelAndView mav) {
		logger.info("/soccer/serviceImpl/commonBoard----------");
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");	
		
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null)pageNumber="1";
		
		int boardSize=10;
		int currentPage=Integer.parseInt(pageNumber);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=currentPage*boardSize;
		
		int count=commonDao.getCommonBoardCount();
		logger.info("count:" + count);
		
		List<CommonBoardDto> commonBoardList=null;
		if(count>0){
			commonBoardList=soccerDao.commonBoard(startRow, endRow, sportCode);
		}
		logger.info("boardSize:" + commonBoardList.size());
		
		mav.addObject("commonBoardList", commonBoardList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);
		
		mav.setViewName("soccer/soccerCommonBoard");
	}
	
	/**
	 * @name : readCommonBoard
	 * @date : 2015. 6. 26.
	 * @author : 변형린
	 * @description : 공지사항 읽기
	 */
	@Override
	public void readCommonBoard(ModelAndView mav) {
		Map<String,Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		String pageNumber=request.getParameter("pageNumber");
		
		if(pageNumber==null){
			pageNumber="1";
		}
		
		CommonBoardDto commonBoard=commonDao.readCommonBoard(boardNumber);
		mav.addObject("commonBoard",commonBoard);
		mav.addObject("pageNumber",Integer.parseInt(pageNumber));
		mav.addObject("boardNumber",boardNumber);
		mav.setViewName("soccer/soccerCommonBoardRead");
	}
	
}