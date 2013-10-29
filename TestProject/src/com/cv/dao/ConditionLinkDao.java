package com.cv.dao;

import java.util.List;

import com.cv.model.ConditionLink;

public interface ConditionLinkDao {

	public void addConditionLink(ConditionLink conditionLink);

	public List<ConditionLink> getConditionLinkList(Integer recId);
}
