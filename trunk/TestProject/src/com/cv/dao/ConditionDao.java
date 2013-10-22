package com.cv.dao;

import java.util.List;

import com.cv.model.Condition;

public interface ConditionDao {

	public void addCondition(Condition condition);

	public List<Condition> listCondition();
	
}
