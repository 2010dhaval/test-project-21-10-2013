package com.cv.service;

import java.util.List;

import com.cv.vo.RecognitionVO;

public interface RecognitionService {

	public void addRecognition(RecognitionVO recognitionVO);

	public List<RecognitionVO> listRecognition();

	public RecognitionVO getRecVoByRecId(Integer recId);

	public void addRecognationByDozer(RecognitionVO recognitionVO);

	public List<RecognitionVO> listRecognitionByDozer();

	public RecognitionVO getRecVoByRecIdByDozer(Integer recId);
	
	public void addRecognationByManual(RecognitionVO recognitionVO);

	public List<RecognitionVO> listRecognitionByManual();
	
	public RecognitionVO getRecVoByRecIdByManual(Integer recId);

}
