package com.cv.dao;

import java.util.List;

import com.cv.model.Recognition;

public interface RecognitionDao {

	public void addRecognition(Recognition recognition);

	public List<Recognition> listRecognition();
	
	public Recognition getRecVoByRecId(Integer recId);

}
