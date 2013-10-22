package com.cv.vo;

import java.io.Serializable;


public class ConditionVO implements Serializable{


	private int conditionId;

	private String condition;

	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
