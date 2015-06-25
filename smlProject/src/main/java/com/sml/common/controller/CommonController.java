package com.sml.common.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sml.common.dto.CommonBoardDto;
import com.sml.common.service.CommonService;

@Controller
public class CommonController {	
	final Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private CommonService commonService;

	@RequestMapping(value="/board/addCommonBoard.do", method=RequestMethod.GET)
	public ModelAndView addCommonBoard(HttpServletRequest request, HttpServletResponse response){
		logger.info("글작성 컨트롤러-------------------------");
		ModelAndView mav=new ModelAndView();
		commonService.addCommonBoard(mav);
		return mav;
	}
	
	@RequestMapping(value="/board/addCommonBoard.do",method=RequestMethod.POST)
	public ModelAndView addCommonBoard(HttpServletRequest request,CommonBoardDto commonBoardDto){
		logger.info("글작성Ok 컨트롤러-------------------------");
		ModelAndView mav=new ModelAndView();
		mav.addObject("commonBoardDto",commonBoardDto);
		commonService.addCommonBoardOk(mav);	
		return mav;
	}
	
	@RequestMapping(value="/board/adminBoard.do", method=RequestMethod.GET)
	public ModelAndView adminBoard(HttpServletRequest request, HttpServletResponse response){
		logger.info("adminBoard-------------------");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);	
		commonService.adminBoard(mav);		
		return mav;
	}
	
	@RequestMapping(value="/board/deleteCommonBoard.do",method=RequestMethod.GET)
	public ModelAndView deleteCommonBoard(HttpServletRequest request, HttpServletResponse response){
		logger.info("deleteCommonBoard-------------------");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);			
		commonService.deleteCommonBoard(mav);		
		
		return mav;
	}
	
	@RequestMapping(value="/board/readCommonBoard.do",method=RequestMethod.GET)
	public ModelAndView readCommonBoard(HttpServletRequest request, HttpServletResponse response){
		logger.info("readCommonBoard-------------------");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);			
		commonService.readCommonBoard(mav);		
		
		return mav;
	}
	
	@RequestMapping(value="/board/updateCommonBoard.do",method=RequestMethod.GET)
	public ModelAndView updateCommonBoard(HttpServletRequest request, HttpServletResponse response,CommonBoardDto commonBoardDto){
		logger.info("boardUpdate-----------");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("commonBoardDto",commonBoardDto);
		commonService.updateCommonBoardSelect(mav);
		
		return mav;
	}
	
	@RequestMapping(value="/board/updateCommonBoard.do",method=RequestMethod.POST)
	public ModelAndView updateCommonBoard(HttpServletRequest request, CommonBoardDto commonBoardDto){
		logger.info("boardUpdate-----------");
		ModelAndView mav=new ModelAndView();
		mav.addObject("request",request);
		mav.addObject("commonBoardDto",commonBoardDto);

		commonService.updateCommonBoardOk(mav);
		return mav;
	}		
}
