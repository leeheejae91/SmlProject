package com.sml.referee.service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sml.referee.dao.RefereeDao;
import com.sml.referee.dto.RefereeDto;

@Component
public class RefereeServiceImpl implements RefereeService{
	private final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private RefereeDao refereeDao;
	
	/**
	 * @name : refereeList
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 심판 현황 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void refereeList(ModelAndView mav) {	
		Map<String, Object> map=mav.getModelMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null)pageNumber="1";
		
		int boardSize=10;
		int currentPage=Integer.parseInt(pageNumber);
		int startRow=(currentPage-1)*boardSize+1;
		int endRow=currentPage*boardSize;
		
		int count=refereeDao.refereeCount();
		logger.info("count:" + count);
		
		List<RefereeDto> refereeList=null;
		if(count>0){
			refereeList=refereeDao.refereeList(startRow, endRow);
		}
		logger.info("boardSize:" + refereeList.size());
		
		mav.addObject("refereeList", refereeList);
		mav.addObject("count", count);
		mav.addObject("boardSize", boardSize);
		mav.addObject("currentPage", currentPage);
		
		mav.setViewName("referee/refereeList");
	}

	/**
	 * @name : registerReferee
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 심판 신청 등록 페이지로 이동시키는 Service 메소드
	 */
	@Override
	public void registerReferee(ModelAndView mav) {
		mav.setViewName("referee/refereeRegister");
		
	}

	/**
	 * @name : registerRefereeOk
	 * @date : 2015. 6. 23.
	 * @author : 변형린
	 * @description : 심판 신청 등록 정보를 DB로 넘기는 Service 메소드
	 */
	@Override
	public void registerRefereeOk(ModelAndView mav) {
		// TODO Auto-generated method stub
		Map <String, Object> map= mav.getModelMap();
		RefereeDto refereeDto=(RefereeDto)map.get("refereeDto");
		
		refereeDto.setRefereeYes(0);//default=0; 수락거부
		int check=refereeDao.refereeRegister(refereeDto);
		
		mav.addObject("check", check);
		mav.setViewName("referee/refereeRegisterOk");
	}

}
