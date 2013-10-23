package com.cv.service;

import java.util.List;

import com.cv.vo.AnswerVO;

public interface AnswerService {
	
		
	public void addOrEditAnswer(AnswerVO answerVO);
	
	public List<AnswerVO> getAnswerVoList();

}
