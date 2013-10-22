package com.cv.service;

import java.util.List;

import com.cv.vo.RecognitionVO;

public interface RecognitionService {

	public void addRecognition(RecognitionVO recognitionVO);

	public List<RecognitionVO> listRecognition();

}
