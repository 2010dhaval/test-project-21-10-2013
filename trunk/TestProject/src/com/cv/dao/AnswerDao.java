package com.cv.dao;

import java.util.List;
import com.cv.model.Answer;

public interface AnswerDao {

	public void addOrEditAnswer(Answer answer);

	public List<Answer> getAnswerModelList();	
	
}
