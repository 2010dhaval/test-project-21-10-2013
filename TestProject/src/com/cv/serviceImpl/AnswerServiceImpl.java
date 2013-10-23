package com.cv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.AnswerDao;
import com.cv.model.Answer;
import com.cv.service.AnswerService;
import com.cv.utils.DozerHelper;
import com.cv.utils.DozerUtil;
import com.cv.vo.AnswerVO;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerDao answerDao;	

	@Override
	public List<AnswerVO> getAnswerVoList() {
		
		List<AnswerVO> answerVOs = DozerHelper.map(DozerUtil.xmlConfig(), 
				this.answerDao.getAnswerModelList(), AnswerVO.class, "answer");
		
		return answerVOs;
	}

	@Override
	public void addOrEditAnswer(AnswerVO answerVO) {
		
		Answer answer = DozerUtil.xmlConfig().map(answerVO, Answer.class, "answer");
		
		this.answerDao.addOrEditAnswer(answer);		
	}

}
