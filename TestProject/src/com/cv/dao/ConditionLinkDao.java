package com.cv.dao;

import java.util.List;

import com.cv.model.ConditionLink;

public interface ConditionLinkDao {

	public List<ConditionLink> getConditionLinkList(Integer recId);
}
