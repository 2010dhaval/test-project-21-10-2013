package com.cv.service;

import java.util.List;

import com.cv.vo.ConditionLinkVO;

public interface ConditionLinkService {

	public void addConditionLink(ConditionLinkVO conditionLinkVO);

	public List<ConditionLinkVO> getConditionLinkList(Integer recId);

}
