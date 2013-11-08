package com.cv.dao;

import java.util.List;

import com.cv.model.Recognition;
import com.cv.vo.RecognitionVO;

public interface RecognitionDao {

	public void addRecognition(Recognition recognition);

	public List<Recognition> listRecognition();

	public Recognition getRecVoByRecId(Integer recId);

	public void addRecognationByDozer(Recognition recognition);
	
	public Recognition getRecVoByRecIdByDozer(Integer recId);

	public List<Recognition> listRecognitionByDozer();

	public void addRecognationByManual(Recognition recognition);

	public List<Recognition> listRecognitionByManual();
	
	public Recognition getRecVoByRecIdByManual(Integer recId);
}
