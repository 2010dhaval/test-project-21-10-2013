package com.cv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.RecognitionDao;
import com.cv.model.Recognition;
import com.cv.service.RecognitionService;
import com.cv.utils.DozerHelper;
import com.cv.utils.DozerUtil;
import com.cv.vo.RecognitionVO;

@Service
public class RecognitionServiceImpl implements RecognitionService {

	@Autowired
	private RecognitionDao recognitionDao;

	@Override
	public void addRecognition(RecognitionVO recognitionVO) {
		// TODO Auto-generated method stub

		// dozer convertio
		Recognition recognition = DozerUtil.xmlConfig().map(recognitionVO,
				Recognition.class, "recognition");

		this.recognitionDao.addRecognition(recognition);
	}

	@Override
	public List<RecognitionVO> listRecognition() {
		// TODO Auto-generated method stub

		// dozer convertion
		List<RecognitionVO> recognitionVOList = DozerHelper.map(
				DozerUtil.xmlConfig(), this.recognitionDao.listRecognition(),
				RecognitionVO.class, "recognition");

		return recognitionVOList;
	}

}
