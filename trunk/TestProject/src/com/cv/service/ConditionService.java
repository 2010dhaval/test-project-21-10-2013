package com.cv.service;

import java.util.List;

import com.cv.vo.ConditionVO;

public interface ConditionService {

	public void addCondition(ConditionVO conditionVO);

	public List<ConditionVO> listCondition();

}
